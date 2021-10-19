package com.paas.runup.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.paas.runup.dto.StudentDTO;

@Repository
public interface StudentDAO {
	public void insertStudent (StudentDTO s) throws Exception;
	public void updateStudent (StudentDTO s) throws Exception;
	public void deleteStudent (int s_no) throws Exception;
	List<StudentDTO> getStudentList(int s_no) throws Exception; 
	StudentDTO getStudentByIDPW(String s_id,String s_password) throws Exception;
	StudentDTO searchStudentID(String s_name,String s_email) throws Exception;
	StudentDTO searchStudentPW(String s_name, String s_id, String s_email) throws Exception;
	StudentDTO updateStudentPW(String s_password) throws Exception;
	Optional<StudentDTO> findByEmail(String s_email) throws Exception;
}
