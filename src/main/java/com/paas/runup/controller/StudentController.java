package com.paas.runup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.paas.runup.dto.StudentDTO;
import com.paas.runup.service.StudentService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value="/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@ApiOperation("학생 - 마이페이지 조회")
	@RequestMapping(value= "/getStudentList", method=RequestMethod.GET)
	public List<StudentDTO> getStudentAll(int s_no) throws Exception{
		System.out.println("학생테이블 전체 검색 메소드-START");
		final List<StudentDTO> studentList = studentService.getStudentList(s_no);
		return studentList;
	}
	
//	@ApiOperation("학생 - 회원가입")
//	@RequestMapping(value= "/insertStudent", method=RequestMethod.POST)
//	@ResponseBody
//	public int insertStudent(StudentDTO student) throws Exception{
//		System.out.println("학생테이블 삽입 메소드-START");
//		int studentDTO = studentService.insertStudent(student);
//		return studentDTO;
//	}
	
	@ApiOperation("학생 - 회원정보 수정")
	@ApiImplicitParams({
        @ApiImplicitParam(name="student", value="StudentDTO", dataType = "com.paas.runup.dto.StudentDTO", example= "2018"),
	})
	@RequestMapping(value= "/updateStudent", method=RequestMethod.PUT)
	public void updateStudent(@Validated @RequestBody StudentDTO student) throws Exception{
		System.out.println("학생테이블 갱신 메소드-START");
		try {
			studentService.updateStudent(student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@ApiOperation("학생 - 회원정보 탈퇴")
    @ApiImplicitParams({
            @ApiImplicitParam(name="s_no", value="학생번호", dataType = "int", example= "2018"),
    })
	@RequestMapping(value= "/deleteStudent", method=RequestMethod.DELETE)
	public void deleteStudent(int s_no) throws Exception{
		System.out.println("학생테이블 삭제 메소드-START");
		studentService.deleteStudent(s_no);
	}
	
}
