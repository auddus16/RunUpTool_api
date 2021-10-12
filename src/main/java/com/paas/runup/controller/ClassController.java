package com.paas.runup.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paas.runup.dto.AttendDTO;
import com.paas.runup.dto.ClassDTO;
import com.paas.runup.service.AttendService;
import com.paas.runup.service.ClassService;

@RestController
public class ClassController {
	
	@Autowired
	private ClassService classService;
	@Autowired
	private AttendService attendService;
	
	@GetMapping(value= "/class/{t_no}", produces= MediaType.APPLICATION_JSON_VALUE)
	public List<ClassDTO> getClassList(@PathVariable int t_no) throws Exception{
		System.out.println("수업테이블 전체 조회");
		final List<ClassDTO> classList = classService.selectClassAll(t_no);
		
		return classList;
	}
	
	@GetMapping(value= "/class/newclass", produces= MediaType.APPLICATION_JSON_VALUE)
	public boolean newClass(@Validated @RequestBody ClassDTO c) {
		System.out.println("새로운 수업 추가");
		int res= 0;
		try {
			res= classService.insertClass(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(res== 0){ //수업 추가 실패
			return false;
		}
		
		return true;
	}
	
	@GetMapping(value="/class/add/{c_no}", produces= MediaType.APPLICATION_JSON_VALUE)
	public ClassDTO addStudent(@PathVariable int c_no) throws Exception{
		System.out.println("학생 수 1 증가");
		int res= classService.addStudent(c_no);
		if(res== 0) {
			return null;
		}
		
		return classService.selectClass(c_no); 
	}
	
	@GetMapping(value= "/attend/{day}", produces= MediaType.APPLICATION_JSON_VALUE)
	public List<AttendDTO> getClassList(@PathVariable String day) throws Exception{
		System.out.println("출석테이블 날짜로 조회");
		
		return attendService.selectAttendByDate(day);
	}
}
