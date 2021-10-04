package com.paas.runup.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.paas.runup.dto.StudentDTO;

@Repository
public interface StudentDAO {
	List<StudentDTO> getStudentList() throws Exception;
}
