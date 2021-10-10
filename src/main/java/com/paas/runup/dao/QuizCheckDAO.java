package com.paas.runup.dao;

import java.util.List;

import com.paas.runup.dto.QuizCheckDTO;

public interface QuizCheckDAO {
	List<QuizCheckDTO> selectQuizCheckList() throws Exception;
	QuizCheckDTO selectQuizCheck(int qc_no) throws Exception;
	void insertQuizCheck(QuizCheckDTO quizCheck) throws Exception;
	void updateQuizCheck (QuizCheckDTO quizCheck) throws Exception;
	void deleteQuizCheck (int qc_no) throws Exception;
}
