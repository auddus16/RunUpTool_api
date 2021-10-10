package com.paas.runup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paas.runup.dto.ClassDTO;
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
@RequestMapping(value="/classS")
public class ClassSController {
	
	@Autowired
	private ClassService classService;

	@ApiOperation("학생 - 수업 리스트 조회")
	@RequestMapping(value= "", method= RequestMethod.GET)
	public List<ClassDTO> getClassList() throws Exception{
		System.out.println("수업 리스트 조회 메소드 시작");
		//(세션)학생 s_no를 가지고 Register검색
		//나오는 Class리스트로 class검색
		return null;
	}
	
	
	
}
