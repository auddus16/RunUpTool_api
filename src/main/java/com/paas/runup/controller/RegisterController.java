package com.paas.runup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.paas.runup.dto.RegisterDTO;
import com.paas.runup.service.ClassService;
import com.paas.runup.service.RegisterService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value="/register")
public class RegisterController {
	
	@Autowired
	private ClassService classService;
	
	@Autowired
	private RegisterService registerService;
	
	@ResponseBody
	
	@ApiOperation(value="학생 수업 등록", notes="수업에 학생을 등록시킨다.")
	@RequestMapping(value= "", method= RequestMethod.POST)
	public boolean registerStudent(@RequestBody RegisterDTO r) throws Exception{
		
		System.out.println("학생 수업 등록 조회 메소드 시작");
		//등록 테이블 삽입
		if(registerService.insertRegister(r)!=0) {
			
			System.out.println("수업 학생 수 증가 메소드 시작");
			//수업 테이블 학생 수 증가
			if(classService.addStudent(r.getC_no())==0) {
				System.out.println("수업 학생 수 증가 실패!!");
			}
			
			System.out.println("학생 수업 등록 성공");
			
			return true;
		}
		
		System.out.println("학생 수업 등록 실패!!");
		
		return false;
		
	}
	
	@ApiOperation(value= "해당 수업에서 학생 삭제", notes="수업에서 학생을 삭제한다.")
	@RequestMapping(value= "/del", method= RequestMethod.DELETE)
	public boolean deleteRegister(@RequestBody RegisterDTO r) throws Exception {
		
		System.out.println("등록 삭제 메소드 시작");
		
		//등록 테이블 삭제
		if(registerService.deleteRegister(r)!=0) {
			//수업 테이블 학생 수 감소
			if(classService.subStudent(r.getC_no())==0) {
				System.out.println("수업 학생 수 감소 실패!!");
			}
			System.out.println("수업 삭제 완료");
			
			return true;
			
		}
		
		System.out.println("수업 삭제 실패!!");
		
		return false;
	}
}
