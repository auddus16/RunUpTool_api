package com.paas.runup.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paas.runup.service.AttendService;
import com.paas.runup.service.ClassService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value="/attendT")
public class AttendTController {
	
	@Autowired
	private ClassService classService;
	@Autowired
	private AttendService attendService;
	
	@RequestMapping(value= "/{c_no}/{day}", method= RequestMethod.GET)
	@ApiOperation("선생님 - 해당 수업 날짜별 출석 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name="day", value="조회날짜", dataType = "String", example= "YYYYMMDD"),
            @ApiImplicitParam(name="c_no", value="조회수업번호", dataType = "int", example= "1")
    })
	public void getAttendList(@PathVariable String day, @PathVariable int c_no) throws Exception{ //20211006
		System.out.println("출석 조회메소드 시작");
		//1. 학생 조인 수업
		//2. c_no와 day로 attend 테이블 검색
		//3. s_name이 나올 수 있도록
	}
	
	@RequestMapping(value= "/{c_no}/{day}/modify/{s_no}/{s_state}", method= RequestMethod.GET)
	@ApiOperation("선생님 - 출결상태 수정하기")
	@ApiImplicitParams({
		@ApiImplicitParam(name="day", value="조회날짜", dataType = "String", example= "YYYYMMDD"),
		@ApiImplicitParam(name="className", value="조회수업이름", dataType = "String", example= "도덕"),
		@ApiImplicitParam(name="stuName", value="학생이름", dataType = "String", example= "홍길동"),
		@ApiImplicitParam(name="state", value="출결상태", dataType = "int", example= "1")
		
	})
	public void modifyAttend(@PathVariable String day, @PathVariable String className, @PathVariable String stuName, @PathVariable int state, HttpServletResponse response) throws Exception{ //20211006
		System.out.println("출결 수정 메소드 시작");
		//1. 출결테이블에 학생이름을 추가????
	}
	
	
	
}
