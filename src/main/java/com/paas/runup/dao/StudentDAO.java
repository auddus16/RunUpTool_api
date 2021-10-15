package com.paas.runup.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.paas.runup.dto.StudentDTO;

@Repository
public interface StudentDAO {
	public void insertStudent (String s_id, String s_name,Date s_birth, boolean s_gender,String s_school,int s_grade,int s_class,String s_password,String s_email) throws Exception;
	public void updateStudent (String s_id, String s_name,Date s_birth, boolean s_gender,String s_school,int s_grade,int s_class,String s_password,String s_email) throws Exception;
	public void deleteStudent (int s_no) throws Exception;
	List<StudentDTO> getStudentList(int s_no) throws Exception; 
	StudentDTO getStudentByIDPW(String s_id,String s_password) throws Exception;
}
