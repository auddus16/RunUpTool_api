package com.paas.runup.dto;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TeacherDTO {
//	T_NO INT PRIMARY KEY AUTO_INCREMENT,
//	T_ID VARCHAR(20) NOT NULL,
//	T_NAME VARCHAR(20) NOT NULL,
//	T_BIRTH DATE NOT NULL,
//	T_GENDER BOOLEAN NOT NULL,
//	T_SCHOOL VARCHAR(20) NOT NULL,
//	T_PASSWORD VARCHAR(20) NOT NULL,
//	T_EMAIL VARCHAR(20) NOT NULL
	
	private int t_no; 
	private String t_id;
	private String t_name;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern= "yyyy-MM-dd", timezone="Asia/Seoul")
	private Date t_birth;
	private boolean t_gender;
	private String t_school;
	private String t_password;
	private String t_email;
	
	public int getT_no() {
		return t_no;
	}
	public void setT_no(int t_no) {
		this.t_no = t_no;
	}
	public String getT_id() {
		return t_id;
	}
	public void setT_id(String t_id) {
		this.t_id = t_id;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public Date getT_birth() {
		return t_birth;
	}
	public void setS_birth(Date t_birth) {
		this.t_birth = t_birth;
	}
	public boolean isT_gender() {
		return t_gender;
	}
	public void setT_gender(boolean t_gender) {
		this.t_gender = t_gender;
	}
	public String getT_school() {
		return t_school;
	}
	public void setT_school(String t_school) {
		this.t_school = t_school;
	}
	public String getT_password() {
		return t_password;
	}
	public void setT_password(String t_password) {
		this.t_password = t_password;
	}
	public String getT_email() {
		return t_email;
	}
	public void setS_email(String t_email) {
		this.t_email = t_email;
	}
}
