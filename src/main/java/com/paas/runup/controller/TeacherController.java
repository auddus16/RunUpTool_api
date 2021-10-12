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

import com.paas.runup.dto.TeacherDTO;
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
	
	@ApiOperation("선생님 - 마이페이지 조회")
	@RequestMapping(value= "/getTeacherList",method=RequestMethod.GET)
	public List<TeacherDTO> getTeacherAll(int t_no) throws Exception{
		System.out.println("교사테이블 전체 검색 메소드-START");
		final List<TeacherDTO> teacherList = teacherService.getTeacherList(t_no);
		return teacherList;
	}
	
//	@ApiOperation("선생님 - 회원가입")
//	@RequestMapping(value= "/insertTeacher", method=RequestMethod.POST)
//	public int insertTeacher(TeacherDTO teacher) throws Exception{
//		System.out.println("교사테이블 삽입 메소드-START");
//		int teacherDTO = teacherService.insertTeacher(teacher);
//		return teacherDTO;
//	}
	
	@ApiOperation("선생님 - 회원정보 수정")
	@ApiImplicitParams({
        @ApiImplicitParam(name="teacher", value="TeacherDTO", dataType = "com.paas.runup.dto.TeacherDTO", example= "1"),
	})
	@RequestMapping(value= "/updateTeacher", method=RequestMethod.PUT)
	public void updateStudent(@Validated @RequestBody TeacherDTO teacher) throws Exception{
		System.out.println("교사테이블 갱신 메소드-START");
		try {
			teacherService.updateTeacher(teacher);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@ApiOperation("선생님 - 회원정보 탈퇴")
    @ApiImplicitParams({
            @ApiImplicitParam(name="t_no", value="선생님번호", dataType = "int", example= "1"),
    })
	@RequestMapping(value= "/deleteTeacher", method=RequestMethod.DELETE)
	public void deleteTeacher(int t_no) throws Exception{
		System.out.println("교사테이블 삭제 메소드-START");
		teacherService.deleteTeacher(t_no);
		
	}
	
}
