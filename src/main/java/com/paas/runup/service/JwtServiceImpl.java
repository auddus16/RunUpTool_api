package com.paas.runup.service;

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

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtServiceImpl implements JwtService {

    private String secretKey = "MySecretKeyWelcomeMyFirstJwt";

    private Logger logger = LoggerFactory.getLogger(JwtServiceImpl.class);

    @Override
    public String makeJwt(HttpServletRequest res) throws Exception {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        Date expireTime  = new Date();
        expireTime.setTime(expireTime.getTime() + 1000 * 60 * 1);
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        Map<String, Object> headerMap = new HashMap<String, Object>();

        headerMap.put("typ", "JWT");
        headerMap.put("alg", "HS256");

        Map<String, Object> map = new HashMap<String, Object>();

        String s_name = res.getParameter("s_name");
//        String id = res.getParameter("id");

        map.put("s_name", s_name);
//        map.put("id", id);

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
            logger.info("s_name :" + claims.get("s_name"));
//            logger.info("Id :" + claims.get("id"));
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