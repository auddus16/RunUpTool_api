package com.paas.runup.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.paas.runup.dto.AttendDTO;
import com.paas.runup.dto.ClassDTO;
import com.paas.runup.dto.RegisterDTO;
import com.paas.runup.service.AttendService;
import com.paas.runup.service.ClassService;
import com.paas.runup.service.RegisterService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value="/class")
public class ClassController {
	
	@Autowired
	private ClassService classService;
	
	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private AttendService attendService;
	
	@ResponseBody
	
	@ApiOperation(value="선생님 - 수업 리스트 조회", notes="선생님의 수업 리스트를 조회한다.")
	@RequestMapping(value= "/teacher", method= RequestMethod.GET)
	public List<ClassDTO> getClassList() throws Exception{
		
		System.out.println("수업 리스트 조회 메소드 시작");
		//선생님 번호로 수업리스트 검색
		int t_no= 1;//++t_no는 세션값 저장
		
		return classService.selectClassByTeacher(t_no);
	}
	
	@ApiOperation(value= "수업 상세정보 조회", notes="하나의 수업 정보를 조회한다.")
	@ApiImplicitParam(name="c_no", value="수업 번호", dataType = "int", example= "1")
	@RequestMapping(value= "/detail/{c_no}", method= RequestMethod.GET)
	public ClassDTO getClass(@PathVariable int c_no) throws Exception{
		
		System.out.println("수업 상세정보 조회 메소드 시작");
		
		return classService.selectClassByClass(c_no);
	}
	
	@ApiOperation(value= "수업 출결정보 조회", notes="해당 수업의 출결 정보를 조회한다.")
	@ApiImplicitParams({
		@ApiImplicitParam(name="c_no", value="수업 번호", dataType = "int", example= "1"),
		@ApiImplicitParam(name="day", value="조회 날짜", dataType = "String", example= "YYYYMMDD")
	})
	@RequestMapping(value= "/teacher/attend/{c_no}/{day}", method= RequestMethod.GET)
	public List<AttendDTO> getAttendList(@PathVariable int c_no, @PathVariable String day) throws Exception{
		
		System.out.println("수업 출결정보 조회 메소드 시작");
		
		Map<String, Object> hm= new HashMap<String, Object>();
		hm.put("c_no", c_no);
		hm.put("day", day);
		
		return attendService.selectAttendByDate(hm);
	}
	
	@ApiOperation(value= "선생님 - 새로운 수업 추가", notes="선생님이 새로운 수업을 생성한다.")
	@RequestMapping(value = "/teacher/new", method = RequestMethod.POST)
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
	@RequestMapping(value= "/teacher/{c_no}", method= RequestMethod.PUT)
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
	@RequestMapping(value= "teacher/del/{c_no}", method= RequestMethod.DELETE)
	public boolean deleteClass(@PathVariable int c_no) throws Exception {
		
		System.out.println("수업 삭제 메소드 시작");
		
		if(classService.deleteClass(c_no)==0) {
			System.out.println("수업 삭제 실패!!");
			
			return false;
		}
		
		System.out.println("수업 삭제 완료");
		
		return true;
	}
	
	@ApiOperation(value="학생 - 수업 리스트 조회", notes="학생의 수업 리스트를 조회한다.")
	@RequestMapping(value= "/student", method= RequestMethod.GET)
	public List<ClassDTO> getClassList2() throws Exception{
		
		System.out.println("수업 리스트 조회 메소드 시작");
		
		int s_no= 1;//++s_no는 세션값 저장
		
		List<RegisterDTO> registerList= registerService.selRegisterAllByStudent(s_no);//등록 테이블 먼저 검색
		
		List<ClassDTO> classList= new ArrayList<ClassDTO>(); //수업정보 저장
		for(RegisterDTO r : registerList) {
			System.out.println(r.getC_no());
			classList.add(classService.selectClassByClass(r.getC_no()));
		}
		
		return classList;
	}
	
	@ApiOperation(value="학생 - 수업 출결 조회", notes="학생의 수업 출결 리스트를 조회한다.")
	@RequestMapping(value= "/student/attend/{c_no}", method= RequestMethod.GET)
	public List<AttendDTO> getAttendList(@PathVariable int c_no) throws Exception{
		
		System.out.println("수업 출결 조회 메소드 시작");
		
		int s_no= 4;//++s_no는 세션값 저장
		
		return attendService.selectAttendList(s_no, c_no);
	}
}
