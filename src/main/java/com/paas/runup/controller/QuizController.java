package com.paas.runup.controller;

import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@RequestMapping("/quiz/getQuizAll")
	public List<QuizDTO> getQuizAll() throws Exception{
		System.out.println("퀴즈테이블 전체 검색 메소드-START");
		final List<QuizDTO> quizList = quizService.selectQuizList();
		
		return quizList;
	}
	
	@RequestMapping("/quiz/getQuiz")
	public QuizDTO getQuiz() throws Exception{
		System.out.println("퀴즈 검색 메소드-START");
		final QuizDTO quiz = quizService.selectQuiz(3);
		
		return quiz;
	}
	
	@RequestMapping("/quiz/addQuiz")
	public QuizDTO addQuiz() throws Exception{
		System.out.println("퀴즈 추가 메소드-START");
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
	
	@RequestMapping("/quiz/modifyQuiz")
	public QuizDTO modifyQuiz() throws Exception{
		System.out.println("퀴즈 수정 메소드-START");
		
		//test
		QuizDTO quiz = quizService.selectQuiz(3);
		quiz.setQ_ans("답 수정");
		quizService.updateQuiz(quiz);
		
		return quiz;
	}
	
	@RequestMapping("/quiz/deleteQuiz")
	public void deleteQuiz() throws Exception{
		System.out.println("퀴즈 삭제 메소드-START");
		
		//test
		quizService.deleteQuiz(4);
	}
	
	
}
