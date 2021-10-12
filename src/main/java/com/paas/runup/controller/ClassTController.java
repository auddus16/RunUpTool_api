//package com.paas.runup.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.paas.runup.dto.ClassDTO;
//import com.paas.runup.service.ClassService;
//import com.paas.runup.service.RegisterService;
//
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@RestController
//@RequiredArgsConstructor
//@RequestMapping(value="/classT")
//public class ClassTController {
//	
//	@Autowired
//	private ClassService classService;
//	
//	@Autowired
//	private RegisterService registerService;
//	
//	@ApiOperation("선생님 - 수업 리스트 조회")
//	@RequestMapping(value= "", method= RequestMethod.GET)
//	public List<ClassDTO> getClassList() throws Exception{
//		System.out.println("수업 리스트 조회 메소드 시작");
//		//1. 선생님 -> classService.selectClassByTeacher(t_no)
//		//t_no는 세션값
//		return null;
//	}
//	
//	@ApiOperation("선생님 - 수업 상세 조회")
//	@RequestMapping(value= "/{c_no}", method= RequestMethod.GET)
//	@ApiImplicitParams({
//        @ApiImplicitParam(name="c_no", value="수업번호", dataType = "int", example= "1"),
//	})
//	public ClassDTO getClass(@PathVariable int c_no) throws Exception{
//		System.out.println("수업 상세 조회 메소드 시작");
//		//1. 선생님 -> classService.selectClassByTeacher(t_no)
//		//t_no는 세션값
//		return null;
//	}
//	
//	@ApiOperation("선생님 - 해당 수업 학생 수 조회")
//	@ApiImplicitParams({
//        @ApiImplicitParam(name="c_no", value="수업번호", dataType = "int", example= "1"),
//	})
//	@RequestMapping(value= "/cnt/{c_no}", method= RequestMethod.GET)
//	public int getClassStuNum(@PathVariable int c_no) throws Exception{
//		System.out.println("수업 학생 수 조회 메소드 시작");
//		//등록테이블 검색
//		return 0;
//	}
//	
//	@ApiOperation("선생님 - 새로운 수업 추가")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name="class", value="ClassDTO", dataType = "com.paas.runup.dto.ClassDTO", example= "1"),
//    })
//	@RequestMapping(value= "/new", method= RequestMethod.POST)
//	public void addNewClass(@Validated @RequestBody ClassDTO c) {
//		System.out.println("새로운 수업 추가 메소드 시작");
//		
//		//세션에 저장된 선생님 번호로 c.setT_no(---)
//		//classService.insertClass(class)
//		
//	}
//	
//	@ApiOperation("선생님 - 수업 정보 수정")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name="class", value="ClassDTO", dataType = "com.paas.runup.dto.ClassDTO", example= "1"),
//    })
//	@RequestMapping(value= "/class", method= RequestMethod.PUT)
//	public void modifyClass(@Validated @RequestBody ClassDTO c) {
//		System.out.println("수업 정보 수정 메소드 시작");
//		try {
//			classService.updateClass(c);//수업 갱신
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//	
//	@ApiOperation("선생님 - 수업 삭제")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name="c_no", value="수업번호", dataType = "int", example= "1"),
//    })
//	@RequestMapping(value= "/del/{c_no}", method= RequestMethod.DELETE)
//	public void deleteClass(@PathVariable int c_no) {
//		System.out.println("수업 삭제 메소드 시작");
//		
//	}
//	
//	@ApiOperation("선생님 - 수업 학생 초대")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name="c_no", value="수업번호", dataType = "int", example= "1"),
//    })
//	@RequestMapping(value= "/invite/{c_no}", method= RequestMethod.POST)
//	public void inviteClass(@PathVariable int c_no, @Validated @RequestBody List<String> email) {
//		System.out.println("학생 초대 메소드 시작");
//		
//	}
//
//	//학생이 초대 이메일을 수락했을때 동작을 어디에 써야하는가..?
//	
//	
//}
