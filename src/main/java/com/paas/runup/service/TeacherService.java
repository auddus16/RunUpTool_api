package com.paas.runup.service;

import java.util.Date;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paas.runup.dao.TeacherDAO;
import com.paas.runup.dto.StudentDTO;
import com.paas.runup.dto.TeacherDTO;

@Service
@MapperScan(basePackages="com.paas.runup.dao")
public class TeacherService implements TeacherDAO {
	
	@Autowired
	TeacherDAO teacherDAO;
	
	@Override /*선생님 전체 목록 조회*/
	public List<TeacherDTO> getTeacherList(int t_no) throws Exception {
		return teacherDAO.getTeacherList(t_no);
	}
	
	@Override /*선생님 전체 목록 삽입*/
	public void insertTeacher(String t_id, String t_name, Date t_birth, boolean t_gender,String t_school,String t_password,String t_email) throws Exception {
		teacherDAO.insertTeacher(t_id,t_name,t_birth,t_gender,t_school,t_password,t_email);
	}
	
	@Override /*선생님 전체 목록 갱신*/
	public void updateTeacher(String t_id, String t_name, Date t_birth, boolean t_gender,String t_school,String t_password,String t_email) throws Exception{
		teacherDAO.updateTeacher(t_id,t_name,t_birth,t_gender,t_school,t_password,t_email);
	}
	
	@Override /*선생님 전체 목록 삭제*/
	public void deleteTeacher(int t_no) throws Exception {
		teacherDAO.deleteTeacher(t_no);
	}
	
	@Override /*로그인시 선생님 목록 조회*/
	public TeacherDTO getTeacherByIDPW(String t_id, String t_password) throws Exception {
		// TODO Auto-generated method stub
		return teacherDAO.getTeacherByIDPW(t_id, t_password); //아이디 비번 select
	}
}
