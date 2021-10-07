package com.paas.runup.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.paas.runup.dto.StudentDTO;

@Repository
public interface StudentDAO {
	public int insertStudent (StudentDTO student) throws Exception;
	public int updateStudent (StudentDTO student) throws Exception;
	public int deleteStudent (int s_no) throws Exception;
	List<StudentDTO> getStudentList() throws Exception; 
}
