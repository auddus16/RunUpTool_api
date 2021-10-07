package com.paas.runup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.paas.runup.dto.StudentDTO;
import com.paas.runup.service.StudentService;

@RestController
@RequestMapping(value="/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value= "/getStudentList", method=RequestMethod.GET)
	@ResponseBody
	public List<StudentDTO> getStudentAll() throws Exception{
		System.out.println("학생테이블 전체 검색 메소드-START");
		final List<StudentDTO> studentList = studentService.getStudentList();
		
		return studentList;
	}
	
	@RequestMapping(value= "/insertStudent", method=RequestMethod.POST)
	@ResponseBody
	public int insertStudent(StudentDTO student) throws Exception{
		System.out.println("학생테이블 삽입 메소드-START");
		int studentDTO = studentService.insertStudent(student);
		return studentDTO;
	}
	
	@RequestMapping(value= "/updateStudent", method=RequestMethod.PUT)
	@ResponseBody
	public int updateStudent(StudentDTO student) throws Exception{
		System.out.println("학생테이블 갱신 메소드-START");
		int studentDTO = studentService.updateStudent(student);
		return studentDTO;
	}
	
	@RequestMapping(value= "/deleteStudent", method=RequestMethod.DELETE)
	@ResponseBody
	public int deleteStudent(int s_no) throws Exception{
		System.out.println("학생테이블 삭제 메소드-START");
		int studentDTO = studentService.deleteStudent(s_no);
		return studentDTO;
	}
	
}
