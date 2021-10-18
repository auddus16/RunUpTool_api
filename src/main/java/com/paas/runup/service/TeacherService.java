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
	public void insertTeacher(TeacherDTO t) throws Exception {
		teacherDAO.insertTeacher(t);
	}
	
	@Override /*선생님 전체 목록 갱신*/
	public void updateTeacher(TeacherDTO t) throws Exception{
		teacherDAO.updateTeacher(t);
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
	
	@Override /*선생님 아이디 찾기*/
	public TeacherDTO searchTeacherID(String t_name, String t_email) throws Exception {
		// TODO Auto-generated method stub
		return teacherDAO.searchTeacherID(t_name, t_email); 
	}
	
	@Override /*선생님 비밀번호 찾기*/
	public TeacherDTO searchTeacherPW(String t_name, String t_id, String t_email) throws Exception {
		// TODO Auto-generated method stub
		return teacherDAO.searchTeacherPW(t_name, t_id, t_email); 
	}
	
	@Override /*선생님 비밀번호 재설정*/
	public TeacherDTO updateTeacherPW(String t_password) throws Exception {
		// TODO Auto-generated method stub
		return teacherDAO.updateTeacherPW(t_password);
		
	}
}
