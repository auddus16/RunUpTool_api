package com.paas.runup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.paas.runup.dto.TeacherDTO;
import com.paas.runup.service.TeacherService;

import io.swagger.annotations.ApiImplicitParam;
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
	
	@ResponseBody
	
	@ApiOperation("선생님 - 마이페이지 조회")
	@ApiImplicitParam(name="t_no", value="선생님 번호", example = "1")
	@RequestMapping(value= "/getTeacherList", method=RequestMethod.GET)
	public List<TeacherDTO> getTeacherAll(int t_no) throws Exception{
		System.out.println("선생님테이블 전체 검색 메소드-START");
		final List<TeacherDTO> teacherList = teacherService.getTeacherList(t_no);
		return teacherList;
	}
	
	@ApiOperation("선생님 - 회원가입")
	@RequestMapping(value= "/signupTeacher", method=RequestMethod.POST)
	public void signupTeacher(@RequestBody TeacherDTO t) throws Exception{
		System.out.println("선생님테이블 삽입 메소드-START");
		teacherService.insertTeacher(t);
	}
	
	@ApiOperation("선생님 - 회원정보 수정")
	@RequestMapping(value= "/updateTeacher", method=RequestMethod.PUT)
	public void updateTeacher(@RequestBody TeacherDTO t) throws Exception{
		System.out.println("선생님테이블 갱신 메소드-START");
		teacherService.updateTeacher(t);
	}

	@ApiOperation("선생님 - 회원정보 탈퇴")
	@RequestMapping(value= "/deleteStudent", method=RequestMethod.DELETE)
	public void deleteTeacher(int t_no) throws Exception{
		System.out.println("선생님테이블 삭제 메소드-START");
		teacherService.deleteTeacher(t_no);
	}
	
    @ApiOperation(value = "선생님 - 아이디찾기")
    @RequestMapping(value = "/searchTeacherID", method= RequestMethod.GET)
    public void searchTeacherID(@PathVariable String t_name, @PathVariable String t_email ) throws Exception {
		System.out.println("선생님아이디찾기 메소드-START");
		TeacherDTO teacherDTO = teacherService.searchTeacherID(t_name, t_email);
		
		if (teacherDTO != null) {
			System.out.println("선생님 회원정보 있음");
		}
		else {
			System.out.println("선생님 회원정보 없음");
		}
			
	}
    
    @ApiOperation(value = "선생님 - 비밀번호찾기")
    @RequestMapping(value = "/searchTeacherPW", method= RequestMethod.GET)
    public void searchTeacherPW(@PathVariable String t_name, @PathVariable String t_id, @PathVariable String t_email ) throws Exception {
		System.out.println("선생님비밀번호찾기 메소드-START");
		TeacherDTO teacherDTO = teacherService.searchTeacherPW(t_name, t_id, t_email);
		
		if (teacherDTO != null) {
			System.out.println("선생님 회원정보 있음");
		}
		else {
			System.out.println("선생님 회원정보 없음");
		}
			
	}
    
    @ApiOperation(value="선생님 - 비밀번호재설정")
	@RequestMapping(value="/updateSTeacherPW", method=RequestMethod.PUT)
	public void uupdateSTeacherPW(@PathVariable int t_no, @PathVariable String t_password) throws Exception{
    	System.out.println("선생님비밀번호재설정 메소드-START");
    	teacherService.updateTeacherPW(t_password);
	}
	
}
