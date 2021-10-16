package com.paas.runup.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.paas.runup.dto.StudentDTO;
//
import com.paas.runup.service.JwtService;
import com.paas.runup.service.StudentService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value="/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	@Autowired
	private JwtService jwtService;
	
	@ApiOperation("학생 - 마이페이지 조회")
	@RequestMapping(value= "/getStudentList", method=RequestMethod.GET)
	public List<StudentDTO> getStudentAll(int s_no) throws Exception{
		System.out.println("학생테이블 전체 검색 메소드-START");
		final List<StudentDTO> studentList = studentService.getStudentList(s_no);
		return studentList;
	}
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@ApiOperation("학생 - 회원가입")
	@RequestMapping(value= "/signupStudent", method=RequestMethod.POST)
	@ResponseBody
	public void signupStudent(String s_id, String s_name,Date s_birth, boolean s_gender,String s_school,int s_grade,int s_class,String s_password,String s_email) throws Exception{
		System.out.println("학생테이블 삽입 메소드-START");
		studentService.insertStudent(s_id,s_name,s_birth,s_gender,s_school,s_grade,s_class,s_password,s_email);
	}
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@ApiOperation("학생 - 회원정보 수정")
	@RequestMapping(value= "/updateStudent", method=RequestMethod.PUT)
	public void updateStudent(String s_id, String s_name,Date s_birth, boolean s_gender,String s_school,int s_grade,int s_class,String s_password,String s_email) throws Exception{
		System.out.println("학생테이블 갱신 메소드-START");
		studentService.updateStudent(s_id,s_name,s_birth,s_gender,s_school,s_grade,s_class,s_password,s_email);
	}

	@ApiOperation("학생 - 회원정보 탈퇴")
	@RequestMapping(value= "/deleteStudent", method=RequestMethod.DELETE)
	public void deleteStudent(int s_no) throws Exception{
		System.out.println("학생테이블 삭제 메소드-START");
		studentService.deleteStudent(s_no);
	}
	
	@ApiOperation(value = "학생 - 로그인")
    @RequestMapping(value = "/loginStudent/{s_id}/{s_password}", method= RequestMethod.GET)
    public String loginStudent(@PathVariable String s_id, @PathVariable String s_password ) throws Exception {
		System.out.println("학생로그인 메소드-START");
		StudentDTO studentDTO = studentService.getStudentByIDPW(s_id, s_password);
		
		if (studentDTO != null) {
			return jwtService.makeJwt(studentDTO);
		}
		else {
			System.out.println("학생 회원정보 없음");
			return null;
		}
			
	}	
	
    @GetMapping("/jwt/auth")
    public boolean authToken(HttpServletRequest res) throws Exception {
        String jwt = res.getHeader("jwt");

        if(jwt == null) {
        	System.out.println("토큰 없음");
            return false;
        } else {
            return jwtService.checkJwt(jwt);
        }
        
    }
    
}
