package com.paas.runup.service;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paas.runup.dao.AttendDAO;
import com.paas.runup.dto.AttendDTO;

@Service
@MapperScan(basePackages="com.paas.runup.dao")
public class AttendService implements AttendDAO{
	
	@Autowired
	AttendDAO attendDAO;
	
	@Override
	public List<AttendDTO> selectAttendByDate(String day) throws Exception {
		// TODO Auto-generated method stub
		return attendDAO.selectAttendByDate(day);
	}

	@Override
	public AttendDTO selectAttend(int a_no) throws Exception {
		// TODO Auto-generated method stub
		return attendDAO.selectAttend(a_no);
	}

	@Override
	public int updateAttend(AttendDTO a) throws Exception {
		// TODO Auto-generated method stub
		return attendDAO.updateAttend(a);
	}

	@Override
	public int updateAttendTime(int a_no) throws Exception {
		// TODO Auto-generated method stub
		return attendDAO.updateAttendTime(a_no);
	}

	@Override
	public int updateAttendState(int a_no, int a_state) throws Exception {
		// TODO Auto-generated method stub
		return attendDAO.updateAttendState(a_no, a_state);
	}

	@Override
	public int deleteAttend(int a_no) throws Exception {
		// TODO Auto-generated method stub
		return attendDAO.deleteAttend(a_no);
	}

	@Override
	public int insertAttend(AttendDTO a) throws Exception {
		// TODO Auto-generated method stub
		return attendDAO.insertAttend(a);
	}

}
