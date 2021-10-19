//package com.paas.runup.config;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import com.paas.runup.dao.StudentDAO;
//import com.paas.runup.dto.StudentDTO;
//
//@Component
//public class JwtAuthenticationProvider implements AuthenticationProvider {
//
//    @Autowired
//    private StudentDAO studentDAO;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String email = authentication.getName();
//        String password = authentication.getCredentials().toString();
//
//        StudentDTO member = null;
//		try {
//			member = studentDAO.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//        if(passwordEncoder.matches(member.getS_password(), password)) {
//            throw new BadCredentialsException("UnAuthorized");
//        }
//
//        return new UsernamePasswordAuthenticationToken(email, password);
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
//    }
//}
