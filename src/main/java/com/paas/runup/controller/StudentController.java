package com.paas.runup.controller;

import java.util.Date;
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
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


//
import com.paas.runup.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.http.HttpServletRequest;

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
	
//	@ApiOperation("학생 - 마이페이지 조회")
//	@RequestMapping(value= "/getStudentList", method=RequestMethod.GET)
//	public List<StudentDTO> getStudentAll(int s_no) throws Exception{
//		System.out.println("학생테이블 전체 검색 메소드-START");
//		final List<StudentDTO> studentList = studentService.getStudentList(s_no);
//		return studentList;
//	}
//	
//	@ApiOperation("학생 - 회원가입")
//	@RequestMapping(value= "/insertStudent", method=RequestMethod.POST)
//	@ResponseBody
//	public int insertStudent(StudentDTO student) throws Exception{
//		System.out.println("학생테이블 삽입 메소드-START");
//		int studentDTO = studentService.insertStudent(student);
//		return studentDTO;
//	}
//	
//	@ApiOperation("학생 - 회원정보 수정")
//	@ApiImplicitParams({
//        @ApiImplicitParam(name="student", value="StudentDTO", dataType = "com.paas.runup.dto.StudentDTO", example= "2018"),
//	})
//	@RequestMapping(value= "/updateStudent", method=RequestMethod.PUT)
//	public void updateStudent(@Validated @RequestBody StudentDTO student) throws Exception{
//		System.out.println("학생테이블 갱신 메소드-START");
//		try {
//			studentService.updateStudent(student);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//	
//	@ApiOperation("학생 - 회원정보 탈퇴")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name="s_no", value="학생번호", dataType = "int", example= "2018"),
//    })
//	@RequestMapping(value= "/deleteStudent", method=RequestMethod.DELETE)
//	public void deleteStudent(int s_no) throws Exception{
//		System.out.println("학생테이블 삭제 메소드-START");
//		studentService.deleteStudent(s_no);
//	}
	
	//테스트
	
	//회원가입
	@ApiOperation(value = "가입", notes = "회원가입을 한다.")
    @RequestMapping(value = "/signup", method= RequestMethod.POST)
    public String signin(StudentDTO student, HttpServletRequest res) throws Exception {
		
		StudentDTO s = new StudentDTO();
		//(#{s_no},#{s_id},#{s_name},#{s_birth},#{s_gender},#{s_school},#{s_grade},#{s_class},#{s_password},#{s_email}
		Date date = new Date(24 * 3600 * 1000);
		s.setS_no(14);
		s.setS_id("zzzaaz");
		s.setS_name("김윤adsd진zd진d");
		s.setS_birth(date);
		s.setS_gender(true);
		s.setS_school("상암고등학교");
		s.setS_grade(3);
		s.setS_class(2);
		s.setS_password("dbswls");
		s.setS_email("이메dsszssdda일d일d");
		
		System.out.println("회원가입");
		studentService.insertStudent(s);
		
//		String jwt = jwtService.makeJwt(res);
//      System.out.println(jwt);
		
		return jwtService.makeJwt(res);
		
		
    }

	
//	@RequestMapping(value="/jwt/create", method= RequestMethod.POST)
//    public String createJwt(HttpServletRequest res) throws Exception {
//        String jwt = jwtService.makeJwt(res);
//        System.out.println(jwt);
//
//        return "check";
//    }

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
