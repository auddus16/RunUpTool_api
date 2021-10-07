package com.paas.runup.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RegisterDTO {
	/*
	R_NO INT PRIMARY KEY AUTO_INCREMENT,
	C_NO INT NOT NULL, 
	S_NO INT NOT NULL,
	R_TIME DATETIME NOT NULL DEFAULT NOW(),
	FOREIGN KEY(C_NO) REFERENCES CLASS(C_NO) ON DELETE CASCADE ON UPDATE CASCADE, 
	FOREIGN KEY(S_NO) REFERENCES STUDENT(S_NO) ON DELETE CASCADE ON UPDATE CASCADE
	 */
	
	private int r_no;
	private int c_no;
	private int s_no;	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern= "yyyy-MM-dd hh:mm:ss", timezone="Asia/Seoul")
	private Date r_time;
	
	public int getR_no() {
		return r_no;
	}
	public void setR_no(int r_no) {
		this.r_no = r_no;
	}
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	public Date getR_time() {
		return r_time;
	}
	public void setR_time(Date r_time) {
		this.r_time = r_time;
	}
	
	
}
