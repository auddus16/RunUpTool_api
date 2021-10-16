package com.paas.runup.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.paas.runup.dto.StudentDTO;

//import java.io.UnsupportedEncodingException;
//
//import org.springframework.stereotype.Service;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import lombok.extern.slf4j.Slf4j;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//@Slf4j
//@Service("jwtService")
//public class JwtServiceImpl implements JwtService{
//
//	private static final String SALT =  "luvookSecret";
//	
//	private Logger logger = LoggerFactory.getLogger(JwtServiceImpl.class);
//	
//	@Override
//	public <T> String create(String key, T data, String subject){
//		String jwt = Jwts.builder()
//						 .setHeaderParam("typ", "JWT")
//						 .setHeaderParam("regDate", System.currentTimeMillis())
//						 .setSubject(subject)
//						 .claim(key, data)
//						 .signWith(SignatureAlgorithm.HS256, this.generateKey())
//						 .compact();
//		return jwt;
//	}	
//
//	private byte[] generateKey(){
//		byte[] key = null;
//		try {
//			key = SALT.getBytes("UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			if(logger.isInfoEnabled()){
//				e.printStackTrace();
//			}else{
//				logger.error("Making JWT Key Error ::: {}", e.getMessage());
//			}
//		}
//		
//		return key;
//	}
//}
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtServiceImpl implements JwtService {

    private String secretKey = "MySecretKeyWelcomeMyFirstJwt";

    private Logger logger = LoggerFactory.getLogger(JwtServiceImpl.class);

    @Override
    public String makeJwt(StudentDTO studentDTO) throws Exception {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        Date expireTime  = new Date();
        expireTime.setTime(expireTime.getTime() + 1000 * 60 * 1);
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        Map<String, Object> headerMap = new HashMap<String, Object>();

        headerMap.put("typ", "JWT");
        headerMap.put("alg", "HS256");

        Map<String, Object> map = new HashMap<String, Object>();
        
        map.put("s_id", studentDTO.getS_id());
        map.put("s_password", studentDTO.getS_password());
        map.put("s_no", studentDTO.getS_no());
        map.put("s_email", studentDTO.getS_email());
        map.put("s_name", studentDTO.getS_name());

        JwtBuilder builder = Jwts.builder().setHeader(headerMap)
                .setClaims(map)
                .setExpiration(expireTime)
                .signWith(signatureAlgorithm, signingKey);

        return builder.compact();
    }

    @Override
    public boolean checkJwt(String jwt) throws Exception {
        try {
            Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secretKey))
                    .parseClaimsJws(jwt).getBody();

            logger.info("토큰 정상");
            logger.info("expireTime :" + claims.getExpiration());
            logger.info("s_id :" + claims.get("s_id"));
            logger.info("s_name :" + claims.get("s_name"));
            logger.info("s_password :" + claims.get("s_password"));
            logger.info("s_no :" + claims.get("s_no"));
            logger.info("s_email :" + claims.get("s_email"));
            return true;
        } catch (ExpiredJwtException exception) {
            logger.info("토큰 만료");
            return false;
        } catch (JwtException exception) {
            logger.info("토큰 변조");
            return false;
        }
    }
    
    
}