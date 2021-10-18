package com.paas.runup.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paas.runup.dto.AttendDTO;
import com.paas.runup.dto.RegisterDTO;
import com.paas.runup.service.AttendService;
import com.paas.runup.service.RegisterService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value="/attend")
public class AttendController {
	/*
	1날짜로 해당 수업 출석 검색 -> 학생이름, 출석 상태 필요(조인)
	2출석 수정하기 -> 수정할 날짜와 학생번호(학생이름?), 출석상태
	X3출석하기(갱신-10분 계산해서 state값 설정해주기)
	X4출석시작하기(삽입)
	5학생이 자기 출결 검색
	  */
	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private AttendService attendService;
	
//	@RequestMapping(value= "/{c_no}/{day}", method= RequestMethod.GET)
//	@ApiOperation("선생님 - 해당 수업 날짜별 출석 조회")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name="day", value="조회날짜", dataType = "String", example= "YYYYMMDD"),
//            @ApiImplicitParam(name="c_no", value="조회수업번호", dataType = "int", example= "1")
//    })
//	public void getAttendList(@PathVariable String day, @PathVariable int c_no) throws Exception{ //20211006
//		System.out.println("출석 조회메소드 시작");
//		//1. 학생 조인 수업
//		//2. c_no와 day로 attend 테이블 검색
//		//3. s_name이 나올 수 있도록
//	}
//	
//	@RequestMapping(value= "/{c_no}/{day}/modify/{s_no}/{s_state}", method= RequestMethod.GET)
//	@ApiOperation("선생님 - 출결상태 수정하기")
//	public void modifyAttend(@PathVariable String day, @PathVariable String className, @PathVariable String stuName, @PathVariable int state, HttpServletResponse response) throws Exception{ //20211006
//		System.out.println("출결 수정 메소드 시작");
//		//1. 출결테이블에 학생이름을 추가????
//	}
	
	@ApiOperation(value= "선생님 - 출결 시작하기", notes="선생님이 출결을 시작한다.")
	@ApiImplicitParam(name="c_no", value="수업 번호", dataType = "int", example= "1")
	@RequestMapping(value = "/{c_no}", method = RequestMethod.POST)
	public boolean startAttend(@PathVariable int c_no) throws Exception {
		
		//수업별로 학생리스트 검색한 후, 그 학생들 출석테이블에 insert
		List<RegisterDTO> registerList= registerService.selRegisterAllByClass(c_no);
		
		for(RegisterDTO r : registerList) {
			if(attendService.insertAttend(r.getS_no(), r.getC_no())==0){
				System.out.println("출결시작 실패!!");
				
				return false;
			}
			System.out.println(r.getC_no()+"에 "+r.getS_no()+"번 학생 추가");
			//System.out.println(r.getR_time());
		}
		
		System.out.println("출결 시작 완료");
			
		return true;
	}
	
	@ApiOperation(value= "학생 - 출석 체크", notes= "학생이 출석체크를 한다.")
	@ApiImplicitParams({
      @ApiImplicitParam(name="c_no", value="수업 번호", dataType = "int", example= "1"),
      @ApiImplicitParam(name="s_no", value="학생 번호", dataType = "int", example= "1")
	})
	@RequestMapping(value= "/{c_no}/{s_no}", method= RequestMethod.PUT)
	public boolean modifyClass(@PathVariable int c_no, @PathVariable int s_no) throws Exception {
		//먼저 오늘 출석시작한 수업에서 자신의 레코드를 검색한다.
		//그 레코드의 출석시작검색해준다.
		System.out.println("학생 출석 메소드 시작");
		
		AttendDTO attendDTO= attendService.selectAttend(s_no, c_no); //수정할 attendDTO 저장
		
		if (attendDTO == null) {
			System.out.println("출석테이블 검색 실패!!");
		}
		else {
			//++출결상태 정하기..
			SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
			Date start= format.parse(attendDTO.getA_starttime());//출결 시작시간

			String curTime= format.format(System.currentTimeMillis());
			attendDTO.setA_time(curTime);//출석누른 시간으로 DTO set
			Date end= format.parse(curTime);//출석 누른 시간
			
			System.out.println("출결 시작: " + start + "출결 확인: " + end);
			
			long diff= (end.getTime() - start.getTime()) / (60 * 1000);
			System.out.println(diff+"분 경과");
			
			//출결 상태 설정
			int newState = 2; 
			if(diff <= 10) {//정상 출석
				newState = 0;
			}
			else {//지각
				newState = 1;
			}
			
			attendDTO.setA_state(newState);//DTO 출석상태 변경
			
			attendService.updateAttend(attendDTO);
		}
		
		
		return true;

	}
	
}
