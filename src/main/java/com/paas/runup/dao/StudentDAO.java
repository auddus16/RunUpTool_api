package com.paas.runup.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.paas.runup.dto.StudentDTO;

@Repository
public interface StudentDAO extends UserDAO{
	StudentDTO selectStudent(int s_no) throws Exception;
	void insertStudent(StudentDTO student) throws Exception;
	void updateStudent(StudentDTO student) throws Exception;
	void deleteStudent(int s_no) throws Exception; 
	
	StudentDTO getStudentByIDPW(String s_id,String s_password) throws Exception;
	String searchStudentID(String s_name,String s_email) throws Exception;
	StudentDTO searchStudentPW(String s_name, String s_id, String s_email) throws Exception;
	StudentDTO updateStudentPW(String s_password) throws Exception;
}
