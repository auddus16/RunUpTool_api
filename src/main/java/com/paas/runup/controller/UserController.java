package com.paas.runup.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.paas.runup.config.JwtTokenUtil;
import com.paas.runup.dto.UserDTO;
import com.paas.runup.service.JwtUserDetailsService;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailService;

    @ResponseBody
    
    @ApiOperation(value="선생님, 학생 - 로그인", notes="이메일과 비밀번호를 입력하여 로그인한다.")
	@RequestMapping(value= "/login", method= RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        
    	System.out.println("login!!");
    	
    	final UserDTO member = userDetailService.authenticateByEmailAndPassword
                (authenticationRequest.getEmail(), authenticationRequest.getPassword());
        
    	System.out.println(member.getUser_name());
        Map<String, Object> map = new HashMap<String, Object>();
        
        map.put("user_password", member.getUser_password());
        map.put("user_no", member.getUser_no());
        map.put("user_email", member.getUser_email());
        map.put("user_name", member.getUser_name());
        
        final String token = "Bearer "+jwtTokenUtil.generateToken(member.getUser_email(), map);
        
        return ResponseEntity.ok(new JwtResponse(token));
    }

}

@Data
@NoArgsConstructor
@Getter
@Setter
class JwtRequest {
	
	@ApiModelProperty(name = "email", value = "이메일", example = "XXXX@gmail.com")
	private String email;
	@ApiModelProperty(name = "password", value = "비밀 번호", example = "password111")
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