package com.paas.runup.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.paas.runup.dto.TeacherDTO;

@Repository
public interface TeacherDAO {
	public void insertTeacher (TeacherDTO teacher);
	public void updateTeacher (TeacherDTO teacher);
	public void deleteTeacher (TeacherDTO teacher);
	List<TeacherDTO> getTeacherList() throws Exception; 
}
