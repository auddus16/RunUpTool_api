package com.paas.runup.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.paas.runup.dto.StudentDTO;
import com.paas.runup.dto.TeacherDTO;

@Repository
public interface TeacherDAO extends UserDAO{
   TeacherDTO selectTeacher(int t_no) throws Exception; 
   void insertTeacher (TeacherDTO t) throws Exception;
   void updateTeacher (TeacherDTO t) throws Exception;
   void deleteTeacher (int t_no) throws Exception;
   
   TeacherDTO getTeacherByIDPW(String t_id,String t_password) throws Exception;
   String searchTeacherID(String t_name,String t_email) throws Exception;
   TeacherDTO searchTeacherPW(String t_name, String t_id, String t_email) throws Exception;
   TeacherDTO updateTeacherPW(String t_password) throws Exception;
}