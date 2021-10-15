package com.paas.runup.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.paas.runup.dto.StudentDTO;
import com.paas.runup.dto.TeacherDTO;

@Repository
public interface TeacherDAO {
	public void insertTeacher (String t_id, String t_name, Date t_birth, boolean t_gender,String t_school,String t_password,String t_email) throws Exception;
	public void updateTeacher (String t_id, String t_name, Date t_birth, boolean t_gender,String t_school,String t_password,String t_email) throws Exception;
	public void deleteTeacher (int t_no) throws Exception;
	List<TeacherDTO> getTeacherList(int t_no) throws Exception; 
	TeacherDTO getTeacherByIDPW(String t_id,String t_password) throws Exception;
}
