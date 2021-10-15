package com.paas.runup.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.paas.runup.dto.StudentDTO;
import com.paas.runup.dto.TeacherDTO;
import com.paas.runup.service.JwtService;
import com.paas.runup.service.TeacherService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value="/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private JwtService jwtService;
	
	@ApiOperation("선생님 - 마이페이지 조회")
	@RequestMapping(value= "/getTeacherList", method=RequestMethod.GET)
	public List<TeacherDTO> getTeacherAll(int t_no) throws Exception{
		System.out.println("선생님테이블 전체 검색 메소드-START");
		final List<TeacherDTO> teacherList = teacherService.getTeacherList(t_no);
		return teacherList;
	}
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@ApiOperation("선생님 - 회원가입")
	@RequestMapping(value= "/signupTeacher", method=RequestMethod.POST)
	@ResponseBody
	public void signupTeacher(String t_id, String t_name, Date t_birth, boolean t_gender,String t_school,String t_password,String t_email) throws Exception{
		System.out.println("선생님테이블 삽입 메소드-START");
		teacherService.insertTeacher(t_id, t_name, t_birth, t_gender, t_school,t_password,t_email);
	}
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@ApiOperation("선생님 - 회원정보 수정")
	@RequestMapping(value= "/updateTeacher", method=RequestMethod.PUT)
	public void updateTeacher(String t_id, String t_name, Date t_birth, boolean t_gender,String t_school,String t_password,String t_email) throws Exception{
		System.out.println("선생님테이블 갱신 메소드-START");
		teacherService.updateTeacher(t_id, t_name, t_birth, t_gender, t_school,t_password,t_email);
	}

	@ApiOperation("선생님 - 회원정보 탈퇴")
	@RequestMapping(value= "/deleteStudent", method=RequestMethod.DELETE)
	public void deleteTeacher(int t_no) throws Exception{
		System.out.println("선생님테이블 삭제 메소드-START");
		teacherService.deleteTeacher(t_no);
	}
	
	@ApiOperation(value = "선생님 - 로그인")
    @RequestMapping(value = "/loginTeacher", method= RequestMethod.GET)
    public String loginTeacher(String t_id, String t_password, HttpServletRequest request) throws Exception {
		System.out.println("선생님로그인 메소드-START");
		TeacherDTO teacherDTO = teacherService.getTeacherByIDPW(t_id, t_password);
		
		if (teacherDTO != null) {
			return jwtService.makeJwt(request);
		}
		else {
			System.out.println("선생님 회원정보 없음");
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
