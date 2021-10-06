package com.paas.runup.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.paas.runup.dto.StudentDTO;

@Repository
public interface StudentDAO {
	public void insertStudent (StudentDTO student);
	public void updateStudent (StudentDTO student);
	public void deleteStudent (StudentDTO student);
	List<StudentDTO> getStudentList() throws Exception; 
}
