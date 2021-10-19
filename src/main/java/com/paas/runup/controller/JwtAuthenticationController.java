package com.paas.runup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paas.runup.config.JwtTokenUtil;
import com.paas.runup.dto.StudentDTO;
import com.paas.runup.service.JwtUserDetailsService;

import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        final StudentDTO member = userDetailService.authenticateByEmailAndPassword
                (authenticationRequest.getEmail(), authenticationRequest.getPassword());
        final String token = "Bearer "+jwtTokenUtil.generateToken(member.getS_email());
        return ResponseEntity.ok(new JwtResponse(token));
    }

}

@Data
class JwtRequest {
	private String email;
	private String password;

    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}

@Data
@AllArgsConstructor
class JwtResponse {
	private String token;

    public JwtResponse(String token2) {
		// TODO Auto-generated constructor stub
    	this.token=token2;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


}