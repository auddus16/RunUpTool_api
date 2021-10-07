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

public class QuizCheckDTO {
//	QC_NO INT PRIMARY KEY AUTO_INCREMENT,
//	Q_NO INT NOT NULL,
//	S_NO INT NOT NULL,
//	QC_STATE BOOLEAN NOT NULL DEFAULT FALSE,
//	QC_TIME DATETIME NOT NULL DEFAULT NOW(),
//	QC_ANS VARCHAR(200) NOT NULL DEFAULT ‘답 없음.’,
//	FOREIGN KEY(Q_NO) REFERENCES QUIZ(Q_NO) ON DELETE CASCADE ON UPDATE CASCADE,
//	FOREIGN KEY(S_NO) REFERENCES STUDENT(S_NO) ON DELETE CASCADE ON UPDATE CASCADE

	
	private int qc_no;
	private int q_no;
	private int s_no;
	private boolean qc_state;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern= "yyyy-MM-dd", timezone="Asia/Seoul")
	private Date qc_time;
	private String qc_ans;
	
	
	public int getQc_no() {
		return qc_no;
	}
	public void setQc_no(int qc_no) {
		this.qc_no = qc_no;
	}
	public int getQ_no() {
		return q_no;
	}
	public void setQ_no(int q_no) {
		this.q_no = q_no;
	}
	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	public boolean getQc_state() {
		return qc_state;
	}
	public void setQc_state(boolean qc_state) {
		this.qc_state = qc_state;
	}
	public Date getQc_time() {
		return qc_time;
	}
	public void setQc_time(Date qc_time) {
		this.qc_time = qc_time;
	}
	public String getQc_ans() {
		return qc_ans;
	}
	public void setQc_ans(String qc_ans) {
		this.qc_ans = qc_ans;
	}

}
