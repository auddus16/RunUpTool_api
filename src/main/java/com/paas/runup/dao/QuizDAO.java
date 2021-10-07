package com.paas.runup.dao;

import java.util.List;

import com.paas.runup.dto.QuizDTO;

public interface QuizDAO {
	List<QuizDTO> selectQuizList() throws Exception;
	QuizDTO selectQuiz(int q_no) throws Exception;
	void insertQuiz(QuizDTO quiz) throws Exception;
	void updateQuiz (QuizDTO quiz) throws Exception;
	void deleteQuiz (int q_no) throws Exception;
}