package com.paas.runup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.paas.runup.dto.TeacherDTO;
import com.paas.runup.service.TeacherService;

@RestController
@RequestMapping(value="/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping(value= "/getTeacherList",method=RequestMethod.GET)
	@ResponseBody
	public List<TeacherDTO> getTeacherAll() throws Exception{
		System.out.println("교사테이블 전체 검색 메소드-START");
		final List<TeacherDTO> teacherList = teacherService.getTeacherList();
		return teacherList;
	}
	
	@RequestMapping(value= "/insertTeacher", method=RequestMethod.POST)
	@ResponseBody
	public int insertTeacher(TeacherDTO teacher) throws Exception{
		System.out.println("교사테이블 삽입 메소드-START");
		int teacherDTO = teacherService.insertTeacher(teacher);
		return teacherDTO;
	}
	
	@RequestMapping(value= "/updateTeacher", method=RequestMethod.PUT)
	@ResponseBody
	public int updateStudent(TeacherDTO teacher) throws Exception{
		System.out.println("교사테이블 갱신 메소드-START");
		int teacherDTO = teacherService.updateTeacher(teacher);
		return teacherDTO;
	}
	
	@RequestMapping(value= "/deleteTeacher", method=RequestMethod.DELETE)
	@ResponseBody
	public int deleteTeacher(int t_no) throws Exception{
		System.out.println("교사테이블 삭제 메소드-START");
		int teacherDTO = teacherService.deleteTeacher(t_no);
		return teacherDTO;
	}
	
}