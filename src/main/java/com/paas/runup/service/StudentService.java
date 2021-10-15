package com.paas.runup.service;

import java.util.Date;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paas.runup.dao.StudentDAO;
import com.paas.runup.dto.StudentDTO;

@Service
@MapperScan(basePackages="com.paas.runup.dao")
public class StudentService implements StudentDAO {
	
	@Autowired
	StudentDAO studentDAO;
	
	@Override /*학생 전체 목록 조회*/
	public List<StudentDTO> getStudentList(int s_no) throws Exception {
		return studentDAO.getStudentList(s_no);
	}
	
	@Override /*학생 전체 목록 삽입*/
	public void insertStudent(String s_id, String s_name, Date s_birth, boolean s_gender,String s_school,int s_grade,int s_class,String s_password,String s_email) throws Exception {
		studentDAO.insertStudent(s_id,s_name,s_birth,s_gender,s_school,s_grade,s_class,s_password,s_email);
	}
	
	@Override /*학생 전체 목록 갱신*/
	public void updateStudent(String s_id, String s_name, Date s_birth, boolean s_gender,String s_school,int s_grade,int s_class,String s_password,String s_email) throws Exception{
		studentDAO.updateStudent(s_id,s_name,s_birth,s_gender,s_school,s_grade,s_class,s_password,s_email);
	}
	
	@Override /*학생 전체 목록 삭제*/
	public void deleteStudent(int s_no) throws Exception {
		studentDAO.deleteStudent(s_no);
	}

	@Override /*로그인시 학생 목록 조회*/
	public StudentDTO getStudentByIDPW(String s_id, String s_password) throws Exception {
		// TODO Auto-generated method stub
		return studentDAO.getStudentByIDPW(s_id, s_password); //아이디 비번 select
	}
	
}

