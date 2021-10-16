package com.paas.runup.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AttendDTO {
	/*
	A_NO INT PRIMARY KEY AUTO_INCREMENT,
	S_NO INT NOT NULL,
	C_NO INT NOT NULL,
	A_STATE INT NOT NULL DEFAULT 2,
	A_STARTTIME NOT NULL DEFAULT NOW(),
	A_TIME DATETIME NOT NULL DEFAULT NOW(),
	FOREIGN KEY(C_NO) REFERENCES CLASS(C_NO) ON DELETE CASCADE ON UPDATE CASCADE, 
	FOREIGN KEY(S_NO) REFERENCES STUDENT(S_NO) ON DELETE CASCADE ON UPDATE CASCADE
	 */
	
	private int a_no;
	private int s_no;
	private int c_no;
	private int a_state;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern= "yyyy-MM-dd hh:mm:ss", timezone="Asia/Seoul")
	private Date a_starttime;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern= "yyyy-MM-dd hh:mm:ss", timezone="Asia/Seoul")
	private Date a_time;
	
	private StudentDTO student; 
	
	public int getA_no() {
		return a_no;
	}
	public void setA_no(int a_no) {
		this.a_no = a_no;
	}
	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public int getA_state() {
		return a_state;
	}
	public void setA_state(int a_state) {
		this.a_state = a_state;
	}
	public Date getA_starttime() {
		return a_starttime;
	}
	public void setA_starttime(Date a_starttime) {
		this.a_starttime = a_starttime;
	}
	public Date getA_time() {
		return a_time;
	}
	public void setA_time(Date a_time) {
		this.a_time = a_time;
	}
	
}
