package com.paas.runup.service;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paas.runup.dao.QuizCheckDAO;
import com.paas.runup.dto.QuizCheckDTO;

@Service
@MapperScan(basePackages="com.paas.runup.dao")
public class QuizCheckService implements QuizCheckDAO{

	@Autowired
	private QuizCheckDAO quizCheckDAO;
	
	@Override
	public List<QuizCheckDTO> selectQuizCheckList() throws Exception {
		// TODO Auto-generated method stub
		List<QuizCheckDTO> quizCheckList= quizCheckDAO.selectQuizCheckList();
		return quizCheckList;
	}

	@Override
	public QuizCheckDTO selectQuizCheck(int qc_no) throws Exception {
		// TODO Auto-generated method stub
		QuizCheckDTO quizCheck = quizCheckDAO.selectQuizCheck(qc_no);
		return quizCheck;
	}

	@Override
	public void insertQuizCheck(QuizCheckDTO quizCheck) throws Exception {
		// TODO Auto-generated method stub
		quizCheckDAO.insertQuizCheck(quizCheck);
	}

	@Override
	public void updateQuizCheck(QuizCheckDTO quizCheck) throws Exception {
		// TODO Auto-generated method stub
		quizCheckDAO.updateQuizCheck(quizCheck);
		
	}

	@Override
	public void deleteQuizCheck(int qc_no) throws Exception {
		// TODO Auto-generated method stub
		quizCheckDAO.deleteQuizCheck(qc_no);
	}

	
	

}
