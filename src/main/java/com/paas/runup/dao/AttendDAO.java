package com.paas.runup.dao;

import java.util.List;

import com.paas.runup.dto.AttendDTO;

public interface AttendDAO {
	List<AttendDTO> selectAttendByDate(String day) throws Exception;//날짜로 등록 조회
	
	AttendDTO selectAttend(int s_no, int c_no) throws Exception;
	
	int updateAttend(AttendDTO a) throws Exception; //전체 갱신
	
	int updateAttendTime(int a_no) throws Exception; //출석시간을 현재 시간으로 갱신
	
	int updateAttendState(int a_no, int a_state) throws Exception; //출석상태 변경
	
	int deleteAttend(int a_no) throws Exception;
	
	int insertAttend(int s_no, int c_no) throws Exception;	//출석상태는 '결석'으로 삽입
	
}
