package com.paas.runup.service;

import java.util.List;
import java.util.Optional;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.paas.runup.dao.StudentDAO;
import com.paas.runup.dao.UserDAO;
import com.paas.runup.dto.StudentDTO;
import com.paas.runup.dto.UserDTO;

@Service
@MapperScan(basePackages="com.paas.runup.dao")
public class StudentService implements StudentDAO, UserDAO {
	
	@Autowired
	StudentDAO studentDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override /*학생 전체 목록 조회*/
	public List<StudentDTO> getStudentList(int s_no) throws Exception {
		return studentDAO.getStudentList(s_no);
	}
	
	@Override /*학생 전체 목록 삽입*/
	public void insertStudent(StudentDTO s) throws Exception {
		s.setS_password(passwordEncoder.encode(s.getS_password()));
		studentDAO.insertStudent(s);
	}
	
	@Override /*학생 전체 목록 갱신*/
	public void updateStudent(StudentDTO s) throws Exception{
		studentDAO.updateStudent(s);
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
	
	@Override /*학생 아이디 찾기*/
	public StudentDTO searchStudentID(String s_name, String s_email) throws Exception {
		// TODO Auto-generated method stub
		return studentDAO.searchStudentID(s_name, s_email); 
	}
	
	@Override /*학생 비밀번호 찾기*/
	public StudentDTO searchStudentPW(String s_name, String s_id, String s_email) throws Exception {
		// TODO Auto-generated method stub
		return studentDAO.searchStudentPW(s_name, s_id, s_email); 
	}
	
	@Override /*학생 비밀번호 재설정*/
	public StudentDTO updateStudentPW(String s_password) throws Exception {
		// TODO Auto-generated method stub
		return studentDAO.updateStudentPW(s_password);
		
	}

	@Override
	public Optional<UserDTO> findByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.findByEmail(email);
	}
}

