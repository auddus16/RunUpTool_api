package com.paas.runup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.paas.runup.dto.ClassDTO;
import com.paas.runup.service.ClassService;
import com.paas.runup.service.RegisterService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value="/classT")
public class ClassTController {
	@Autowired
	private ClassService classService;
	
	
	@ResponseBody
	
	@ApiOperation(value="선생님 - 수업 리스트 조회", notes="선생님의 수업 리스트를 조회한다.")
	@RequestMapping(value= "", method= RequestMethod.GET)
	public List<ClassDTO> getClassList() throws Exception{
		
		System.out.println("수업 리스트 조회 메소드 시작");
		//선생님 번호로 수업리스트 검색
		int t_no= 1;//++t_no는 세션값 저장
		
		return classService.selectClassByTeacher(t_no);
	}
	
	@ApiOperation(value= "선생님 - 수업 상세정보 조회", notes="하나의 수업 정보를 조회한다.")
	@ApiImplicitParam(name="c_no", value="수업 번호", dataType = "int", example= "1")
	@RequestMapping(value= "/detail/{c_no}", method= RequestMethod.GET)
	public ClassDTO getClass(@PathVariable int c_no) throws Exception{
		
		System.out.println("수업 상세정보 조회 메소드 시작");
		
		return classService.selectClassByClass(c_no);
	}
	
	@ApiOperation(value= "선생님 - 새로운 수업 추가", notes="선생님이 새로운 수업을 생성한다.")
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public boolean addNewClass(@RequestBody ClassDTO c) throws Exception {
		
		System.out.println("새로운 수업 추가 메소드 시작");

		c.setT_no(1);// ++세션에 저장된 선생님 번호로 c.setT_no(---)
		
		if (classService.insertClass(c) == 0) {
			System.out.println("새로운 수업 추가 실패!!");
			
			return false;
		}

		System.out.println("새로운 수업 추가 완료");
		
		return true;
	}
	
	@ApiOperation(value= "선생님 - 수업 정보 수정", notes= "선생님이 수업 정보를 수정한다.")
	@RequestMapping(value= "/class/{c_no}", method= RequestMethod.PUT)
	public boolean modifyClass(@RequestBody ClassDTO c, @PathVariable int c_no) throws Exception {
		
		System.out.println("수업 정보 수정 메소드 시작");
		
		c.setC_no(c_no); //수업번호 set해주기
		
		if(classService.updateClass(c)==0) {
			System.out.println("수업 정보 수정 실패!!");
			return false;
		}
		
		System.out.println("수업 정보 수정 완료");

		return true;

	}
	
	@ApiOperation(value= "선생님 - 수업 삭제", notes= "선생님이 수업을 삭제한다.")
    @ApiImplicitParam(name="c_no", value="수업 번호", dataType = "int", example= "1")
	@RequestMapping(value= "/del/{c_no}", method= RequestMethod.DELETE)
	public boolean deleteClass(@PathVariable int c_no) throws Exception {
		
		System.out.println("수업 삭제 메소드 시작");
		
		if(classService.deleteClass(c_no)==0) {
			System.out.println("수업 삭제 실패!!");
			return false;
		}
		
		System.out.println("수업 삭제 완료");
		
		return true;
	}
}
