package com.paas.runup.service;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paas.runup.dao.TeacherDAO;
import com.paas.runup.dto.TeacherDTO;

@Service
@MapperScan(basePackages="com.paas.runup.dao")
public class TeacherService implements TeacherDAO {
	
	@Autowired
	TeacherDAO teacherDAO;
	
	@Override
	public List<TeacherDTO> getTeacherList() throws Exception {
		List<TeacherDTO> teacherList= teacherDAO.getTeacherList();
		
		return teacherList;
	}
	@Override
	public int insertTeacher(TeacherDTO teacher)/*회원가입*/throws Exception {
		int insertTeacher=teacherDAO.insertTeacher(teacher);
		return insertTeacher;
	}
	
	@Override
	public int updateTeacher(TeacherDTO teacher) throws Exception{
		int updateTeacher=teacherDAO.updateTeacher(teacher);
		return updateTeacher;
	}
	@Override
	public int deleteTeacher(int t_no)/*탈퇴*/ throws Exception{
		int deleteTeacher=teacherDAO.deleteTeacher(t_no);
		return deleteTeacher;
	}

}
