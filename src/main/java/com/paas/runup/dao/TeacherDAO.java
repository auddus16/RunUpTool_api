package com.paas.runup.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.paas.runup.dto.TeacherDTO;

@Repository
public interface TeacherDAO {
	public int insertTeacher (TeacherDTO teacher) throws Exception;
	public int updateTeacher (TeacherDTO teacher) throws Exception;
	public int deleteTeacher (int t_no) throws Exception;
	List<TeacherDTO> getTeacherList(int t_no) throws Exception; 
}
