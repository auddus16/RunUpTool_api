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

}
