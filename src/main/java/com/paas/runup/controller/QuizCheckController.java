package com.paas.runup.controller;

import java.sql.Time;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.paas.runup.dao.QuizCheckDAO;
import com.paas.runup.dto.QuizCheckDTO;
import com.paas.runup.service.QuizCheckService;

@RestController
public class QuizCheckController {
	
	@Autowired
	private QuizCheckService quizCheckService;
	
	@ResponseBody
	@RequestMapping(value="/quizCheck/getQuizCheckAll", method=RequestMethod.GET)
	public List<QuizCheckDTO> getQuizCheckAll() throws Exception{
		System.out.println("제출한 퀴즈 테이블 전체 검색");
		final List<QuizCheckDTO> quizCheckList = quizCheckService.selectQuizCheckList();
		
		return quizCheckList;
	}
	
	@RequestMapping(value="/quizCheck/getQuizCheckDetail/{qc_no}", method=RequestMethod.GET)
	public QuizCheckDTO getQuizCheckDetail(int qc_no) throws Exception{
		System.out.println("제출한 퀴즈 상세 검색");
		final QuizCheckDTO quizCheck = quizCheckService.selectQuizCheck(qc_no);
		
		return quizCheck;
	}
	
	@RequestMapping(value="/quizCheck/addQuizCheck", method=RequestMethod.POST)
	public QuizCheckDTO addQuiz() throws Exception{
		System.out.println("제출한 퀴즈 추가");
		QuizCheckDTO quizCheck = new QuizCheckDTO();
		
//		//test
//		Time time = new Time(0, 3, 0);
//		quiz.setC_no(1);
//		quiz.setQ_ques("문제");
//		quiz.setQ_ans("답");
//		quiz.setQ_type(false);
//		quiz.setQ_timelimit(time);
		quizCheckService.insertQuizCheck(quizCheck);
		
		return quizCheck;
	}
	
	@RequestMapping(value="/quizCheck/modifyQuizCheck/{qc_no}", method=RequestMethod.PUT)
	public QuizCheckDTO modifyQuizCheck() throws Exception{
		System.out.println("제출한 퀴즈 수정");
		
		//test
		QuizCheckDTO quizCheck = quizCheckService.selectQuizCheck(3);
//		quizCheck.setQ_ans("답 수정");
		quizCheckService.updateQuizCheck(quizCheck);
		
		return quizCheck;
	}
	
	@RequestMapping(value="/quizCheck/deleteQuizCheck", method= {RequestMethod.DELETE, RequestMethod.GET})
	public void deleteQuizCheck(HttpServletResponse response) throws Exception{
		System.out.println("제출한 퀴즈 삭제");
		
		//test
		quizCheckService.deleteQuizCheck(3);
		String redirect_uri = "/quizCheck/getQuizCheckAll";
		response.sendRedirect(redirect_uri);
	}
	
	
}
