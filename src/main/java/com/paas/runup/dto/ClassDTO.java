package com.paas.runup.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ClassDTO {
	/*
	C_NO INT PRIMARY KEY AUTO_INCREMENT,
	C_NAME VARCHAR(20) NOT NULL,
	C_TIME VARCHAR(20) NOT NULL,
	C_STUNUM INT NOT NULL,
	T_NO INT NOT NULL,
	FOREIGN KEY(T_NO) REFERENCES TEACHER(T_NO) ON DELETE 
CASCADE ON UPDATE CASCADE
	 */
	
	private int c_no;
	private String c_name;
	private String c_time;
	private int c_stunum;
	private int t_no;
	
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_time() {
		return c_time;
	}
	public void setC_time(String c_time) {
		this.c_time = c_time;
	}
	public int getC_stunum() {
		return c_stunum;
	}
	public void setC_stunum(int c_stunum) {
		this.c_stunum = c_stunum;
	}
	public int getT_no() {
		return t_no;
	}
	public void setT_no(int t_no) {
		this.t_no = t_no;
	}
	
	
}
