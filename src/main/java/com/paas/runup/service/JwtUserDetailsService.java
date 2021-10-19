package com.paas.runup.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.paas.runup.dao.StudentDAO;
import com.paas.runup.dto.StudentDTO;
/*JwtUserDetailsService는 들어온 email으로 Member를 찾아서 결과적으로 User 객체를 반환해주는 역할 + 
 * 컨트롤러에서 넘어온 email과 password 값이 db에 저장된 비밀번호와 일치하는지 검사한다.*/

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private StudentDAO studentDAO;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        StudentDTO member= null;
        
		try {
			member = studentDAO.findByEmail(email)
			       .orElseThrow(() -> new UsernameNotFoundException(email));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        
        grantedAuthorities.add(new SimpleGrantedAuthority(member.getS_name()));
        
        return new User(member.getS_email(), member.getS_password(), grantedAuthorities);
    }

    public StudentDTO authenticateByEmailAndPassword(String email, String password) throws UsernameNotFoundException, Exception {
    	StudentDTO member = studentDAO.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));

        if(!passwordEncoder.matches(password, member.getS_password())) {
            throw new BadCredentialsException("Password not matched");
        }

        return member;
    }

}

