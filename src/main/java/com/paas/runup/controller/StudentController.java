package com.paas.runup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.paas.runup.dto.StudentDTO;
import com.paas.runup.service.StudentService;

@RestController
@RequestMapping(value="/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping(value= "", produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<StudentDTO> getStudentAll() throws Exception{
		System.out.println("학생테이블 전체 검색 메소드-START");
		final List<StudentDTO> studentList = studentService.getStudentList();
		
		return studentList;
	}
}
