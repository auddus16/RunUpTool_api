package com.paas.runup.dao;

import java.util.List;

import com.paas.runup.dto.RegisterDTO;

public interface RegisterDAO {
	List<RegisterDTO> selRegisterAllByClass(int c_no) throws Exception;//수업번호로 등록 조회
	
	List<RegisterDTO> selRegisterAllByStudent(int s_no) throws Exception;//학생번호로 등록 조회
	
	//RegisterDTO selectRegister(int c_no) throws Exception;
	
	//int updateRegister(RegisterDTO c) throws Exception;
	
	int delRegisterByClass(int c_no) throws Exception;
	
	int delRegisterByStudent(int s_no) throws Exception;
	
	int insertRegister(RegisterDTO r) throws Exception;	
	
}
