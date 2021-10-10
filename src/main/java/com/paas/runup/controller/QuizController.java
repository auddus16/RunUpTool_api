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

import com.paas.runup.dao.QuizDAO;
import com.paas.runup.dto.QuizDTO;
import com.paas.runup.service.QuizService;

@RestController
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	@ResponseBody
	@RequestMapping(value="/quiz/getQuizAll", method=RequestMethod.GET)
	public List<QuizDTO> getQuizAll() throws Exception{
		System.out.println("퀴즈테이블 전체 검색");
		final List<QuizDTO> quizList = quizService.selectQuizList();
		
		return quizList;
	}
	
	@RequestMapping(value="/quiz/getQuizDetail/{q_no}", method=RequestMethod.GET)
	public QuizDTO getQuizDetail(int q_no) throws Exception{
		System.out.println("퀴즈 상세 검색");
		final QuizDTO quiz = quizService.selectQuiz(q_no);
		
		return quiz;
	}
	
	@RequestMapping(value="/quiz/addQuiz", method=RequestMethod.POST)
	public QuizDTO addQuiz() throws Exception{
		System.out.println("퀴즈 추가");
		QuizDTO quiz = new QuizDTO();
		
		//test
		Time time = new Time(0, 3, 0);
		quiz.setC_no(1);
		quiz.setQ_ques("문제");
		quiz.setQ_ans("답");
		quiz.setQ_type(false);
		quiz.setQ_timelimit(time);
		quizService.insertQuiz(quiz);
		
		return quiz;
	}
	
	@RequestMapping(value="/quiz/modifyQuiz/{q_no}", method=RequestMethod.PUT)
	public QuizDTO modifyQuiz() throws Exception{
		System.out.println("퀴즈 수정");
		
		//test
		QuizDTO quiz = quizService.selectQuiz(3);
		quiz.setQ_ans("답 수정");
		quizService.updateQuiz(quiz);
		
		return quiz;
	}
	
	@RequestMapping(value="/quiz/deleteQuiz", method= {RequestMethod.DELETE, RequestMethod.GET})
	public void deleteQuiz(HttpServletResponse response) throws Exception{
		System.out.println("퀴즈 삭제");
		
		//test
		quizService.deleteQuiz(3);
		String redirect_uri = "/quiz/getQuizAll";
		response.sendRedirect(redirect_uri);
	}
	
	
}
