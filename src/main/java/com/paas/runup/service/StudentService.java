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
	
	@Override
	public List<StudentDTO> getStudentList() throws Exception {
		List<StudentDTO> studentList= studentDAO.getStudentList();
		return studentList;
	}
	@Override
	public int insertStudent(StudentDTO student) throws Exception/*회원가입*/ {
		int insertStudent=studentDAO.insertStudent(student);
		return insertStudent;
	}
	
	@Override
	public int updateStudent(StudentDTO student) throws Exception{
		int updateStudent=studentDAO.updateStudent(student);
		return updateStudent;
	}
	@Override
	public int deleteStudent(int s_no)/*탈퇴*/ throws Exception {
		int deleteStudent=studentDAO.deleteStudent(s_no);
		return deleteStudent;
	}

}
