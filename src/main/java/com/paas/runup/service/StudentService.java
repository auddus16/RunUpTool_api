package com.paas.runup.service;

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
	public int insertStudent(StudentDTO student) throws Exception {
		return studentDAO.insertStudent(student);
	}
	
	@Override /*학생 전체 목록 갱신*/
	public int updateStudent(StudentDTO student) throws Exception{
		return studentDAO.updateStudent(student);
	}
	
	@Override /*학생 전체 목록 삭제*/
	public int deleteStudent(int s_no)/*탈퇴*/ throws Exception {
		return studentDAO.deleteStudent(s_no);
	}
	
}

