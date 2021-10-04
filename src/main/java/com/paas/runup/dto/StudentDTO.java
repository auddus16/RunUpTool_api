package com.paas.runup.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class StudentDTO {
	/*
	S_NO INT PRIMARY KEY AUTO_INCREMENT,
	S_ID VARCHAR(20) NOT NULL, 
	S_NAME VARCHAR(20) NOT NULL, 
	S_BIRTH DATE NOT NULL, 
	S_GENDER BOOLEAN NOT NULL, 
	S_SCHOOL VARCHAR(20) NOT NULL, 
	S_GRADE INT NOT NULL,
	S_CLASS INT NOT NULL,
	S_PASSWORD VARCHAR(20) NOT NULL, 
	S_EMAIL VARCHAR(20) UNIQUE KEY NOT NULL
	 */
	
	private int s_no; 
	private String s_name;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern= "yyyy-MM-dd", timezone="Asia/Seoul")
	private Date s_birth;
	private boolean s_gender;
	private String s_school;
	private int s_grade;
	private int s_class;
	private String s_password;
	private String s_email;
	
	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public Date getS_birth() {
		return s_birth;
	}
	public void setS_birth(Date s_birth) {
		this.s_birth = s_birth;
	}
	public boolean isS_gender() {
		return s_gender;
	}
	public void setS_gender(boolean s_gender) {
		this.s_gender = s_gender;
	}
	public String getS_school() {
		return s_school;
	}
	public void setS_school(String s_school) {
		this.s_school = s_school;
	}
	public int getS_grade() {
		return s_grade;
	}
	public void setS_grade(int s_grade) {
		this.s_grade = s_grade;
	}
	public int getS_class() {
		return s_class;
	}
	public void setS_class(int s_class) {
		this.s_class = s_class;
	}
	public String getS_password() {
		return s_password;
	}
	public void setS_password(String s_password) {
		this.s_password = s_password;
	}
	public String getS_email() {
		return s_email;
	}
	public void setS_email(String s_email) {
		this.s_email = s_email;
	}
	
	
}
