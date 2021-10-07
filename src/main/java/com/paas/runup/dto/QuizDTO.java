package com.paas.runup.dto;

import java.sql.Time;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class QuizDTO {
//	Q_NO INT PRIMARY KEY AUTO_INCREMENT,
//	C_NO INT NOT NULL,
//	Q_QUES VARCHAR(200) NOT NULL,
//	Q_ANS VARCHAR(200) NOT NULL DEFAULT ‘답 없음.’,
//	Q_TYPE BOOLEAN NOT NULL,
//	Q_TIMELIMIT TIME NOT NULL,
//	FOREIGN KEY(C_NO) REFERENCES CLASS(C_NO) ON DELETE CASCADE ON UPDATE CASCADE
	
	private int q_no;
	private int c_no;
	private String q_ques;
	private String q_ans;
	private boolean q_type;
	private Time q_timelimit;
	
	
	public int getQ_no() {
		return q_no;
	}
	public void setQ_no(int q_no) {
		this.q_no = q_no;
	}
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public String getQ_ques() {
		return q_ques;
	}
	public void setQ_ques(String q_ques) {
		this.q_ques = q_ques;
	}
	public String getQ_ans() {
		return q_ans;
	}
	public void setQ_ans(String q_ans) {
		this.q_ans = q_ans;
	}
	public boolean getQ_type() {
		return q_type;
	}
	public void setQ_type(boolean q_type) {
		this.q_type = q_type;
	}
	public Time getQ_timelimit() {
		return q_timelimit;
	}
	public void setQ_timelimit(Time q_timelimit) {
		this.q_timelimit = q_timelimit;
	}


}
