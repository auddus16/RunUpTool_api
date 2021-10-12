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
	
	@Override /*선생님 전체 목록 조회*/
	public List<TeacherDTO> getTeacherList(int t_no) throws Exception {
		return teacherDAO.getTeacherList(t_no);
	}
	@Override /*학생 전체 목록 삽입*/
	public int insertTeacher(TeacherDTO teacher)/*회원가입*/throws Exception {
		return teacherDAO.insertTeacher(teacher);
	}
	
	@Override /*학생 전체 목록 갱신*/
	public int updateTeacher(TeacherDTO teacher) throws Exception{
		return teacherDAO.updateTeacher(teacher);
	}
	@Override /*학생 전체 목록 삭제*/
	public int deleteTeacher(int t_no)/*탈퇴*/ throws Exception{
		return teacherDAO.deleteTeacher(t_no);
	}

}
