package com.paas.runup.dto;

import java.sql.Time;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
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
	
//	@ApiModelProperty(name = "q_no", example = "1")
	@ApiParam(value = "퀴즈 번호")
	private int q_no;
	
//	@ApiModelProperty(name = "c_no", example = "1")
	@ApiParam(value = "수업 번호")
	private int c_no;
	
//	@ApiModelProperty(name = "q_ques", example = "사과를 영어로?")
	@ApiParam(value = "퀴즈 문제")
	private String q_ques;
	
//	@ApiModelProperty(name = "q_ans", example = "apple")
	@ApiParam(value = "퀴즈 답")
	private String q_ans;
	
//	@ApiModelProperty(name = "q_type", example = "0")
	@ApiParam(value = "퀴즈 유형(0:단답형 1:서술형)")
	private boolean q_type;
	
//	@ApiModelProperty(name = "q_timelimit", example = "00:03:00")
	@ApiParam(value = "퀴즈 제한 시간")
	private String q_timelimit;
	
	
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
	public String getQ_timelimit() {
		return q_timelimit;
	}
	public void setQ_timelimit(String q_timelimit) {
		this.q_timelimit = q_timelimit;
	}


}
