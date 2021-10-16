package com.paas.runup.service;

import com.paas.runup.dto.StudentDTO;

public interface JwtService {
    public String makeJwt(StudentDTO studentDTO) throws Exception;
    public boolean checkJwt(String jwt) throws Exception;
}
