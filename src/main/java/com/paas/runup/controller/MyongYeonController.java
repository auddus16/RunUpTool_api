package com.paas.runup.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paas.runup.dto.AttendDTO;
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
public class MyongYeonController {
	
	@Autowired
	private ClassService classService;
	@Autowired
	private AttendService attendService;
	
	
	@ApiOperation("선생님-수업테이블 전체 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name="t_no", value="선생님 번호", dataType = "int", example= "1"),
    })
	@RequestMapping(value= "/class/{t_no}", method= RequestMethod.GET)
	public List<ClassDTO> getClassList(@PathVariable int t_no) throws Exception{
		System.out.println("수업테이블 전체 조회");
		final List<ClassDTO> classList = classService.selectClassAll(t_no);
		
		return classList;
	}
	
	@RequestMapping(value= "/class/newclass", method= RequestMethod.POST)
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
	
	@RequestMapping(value= "/class/add/{c_no}", method= RequestMethod.PUT)
	public ClassDTO addStudent(@PathVariable int c_no) throws Exception{
		System.out.println("학생 수 1 증가");
		int res= classService.addStudent(c_no);
		System.out.println(res);
		if(res== 0) {
			return null;
		}
		
		return classService.selectClass(c_no); 
	}
	
	@RequestMapping(value= "/attend/{day}", method= RequestMethod.GET)
	public void getClassList(@PathVariable String day, HttpServletResponse response) throws Exception{ //20211006
		System.out.println("출석테이블 날짜로 조회");
		response.sendRedirect("/attend/get/1");
		//return attendService.selectAttendByDate(day);
	}
	
	@RequestMapping(value= "/attend/get/{a_no}", method= RequestMethod.GET)
	public AttendDTO getAttend(@PathVariable int a_no) throws Exception{
		System.out.println("수업테이블 전체 조회");
		final AttendDTO attend = attendService.selectAttend(a_no);
		
		return attend;
	}
	
}