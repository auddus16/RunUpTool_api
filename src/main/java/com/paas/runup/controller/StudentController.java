package com.paas.runup.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.paas.runup.email.EmailUtil;
import com.paas.runup.dto.StudentDTO;
import com.paas.runup.service.StudentService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.Random;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/student")
public class StudentController {

   @Autowired
   private StudentService studentService;
   
   @Autowired
   private EmailUtil emailUtil;

   @ResponseBody

   @ApiOperation(value = "학생 - 학생 정보 조회", notes = "s_no를 통해 학생 정보를 조회한다.")
   @ApiImplicitParam(name = "s_no", value = "학생 번호", example = "1")
   @RequestMapping(value = "/getStudent/{s_no}", method = RequestMethod.GET)
   public StudentDTO getStudent(@PathVariable int s_no) throws Exception {
      System.out.println("학생 정보 조회");

      return studentService.selectStudent(s_no);
   }

   @ApiOperation(value = "학생 - 회원가입", notes = "학생 회원가입을 한다.")
   @RequestMapping(value = "/signupStudent", method = RequestMethod.POST)
   public void signupStudent(@RequestBody StudentDTO student) throws Exception {
      System.out.println("학생 회원가입");
            
      studentService.insertStudent(student);
   }
   
   @ApiOperation(value= "학생 - 회원가입 이메일 인증", notes="학생 회원가입을 위해 이메일을 인증한다.")
   @RequestMapping(value= "/StudentEmail", method = RequestMethod.POST)
   public boolean saveLocation(HttpServletRequest request, @PathVariable String email) {
      System.out.println("학생 이메일 인증 시작");

      emailUtil.sendEmail(email+"님께 인증 메일이 발송되었습니다.","성공적으로 런업툴 회원가입을 위해 이메일 인증이 필요합니다.", "링크를 클릭하세요.");
      return true;
   }
   
   
   @ApiOperation(value = "학생 - 회원 정보 수정", notes = "회원 정보를 수정한다.")
   @RequestMapping(value = "/updateStudentInfo/{s_no}", method = RequestMethod.PUT)
   public void updateStudentInfo(HttpServletRequest request, @RequestBody StudentDTO student) throws Exception {
      System.out.println("학생 회원정보 수정");
      
      
      Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary("jwtpassword"))
            .parseClaimsJws(request.getHeader("jwt").substring(7)).getBody();

      student.setS_no((int)claims.get("user_no"));
      
      studentService.updateStudent(student);
   }

   @ApiOperation(value = "학생 - 회원 탈퇴", notes = "학생 회원 탈퇴를 한다.")
   @RequestMapping(value = "/deleteStudent/{s_no}", method = RequestMethod.DELETE)
   public void deleteStudent(HttpServletRequest request) throws Exception {
      System.out.println("학생 회원 탈퇴");
      
      Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary("jwtpassword"))
            .parseClaimsJws(request.getHeader("jwt").substring(7)).getBody();

      int s_no = (int)claims.get("user_no");

      studentService.deleteStudent(s_no);
   }

   
   @ApiOperation(value = "학생 - 아이디 찾기", notes = "학생 아이디를 찾는다.")
   @RequestMapping(value = "/searchStudentID", method = RequestMethod.GET)
   public String searchStudentID(@RequestParam String s_name, @RequestParam String s_email) throws Exception {
      System.out.println("학생 아이디 찾기");
      
      String s_id = studentService.searchStudentID(s_name, s_email);

      if (s_id != null) {
         System.out.println("학생 회원정보 있음 :"+ s_id);
         return s_id;
         
      } else {
         System.out.println("학생 회원정보 없음");
         return null;
      }

   }

   @ApiOperation(value = "학생 - 비밀번호 찾기", notes = "학생 비밀번호를 찾는다.")
   @RequestMapping(value = "/searchStudentPW", method = RequestMethod.GET)
   public void searchStudentPW(@RequestParam String s_name, @RequestParam String s_id, @RequestParam String s_email) throws Exception {
      System.out.println("학생 비밀번호 찾기");
      
      StudentDTO studentDTO = studentService.searchStudentPW(s_name, s_id, s_email);

      if (studentDTO != null) {
         System.out.println("학생 회원정보 있음");
         System.out.println("이메일 전송!");
         emailUtil.sendEmail(s_email+"님께 인증 메일이 발송되었습니다.","런업툴 비밀번호 재설정을 위해 이메일 인증이 필요합니다.", "링크를 클릭하세요.");
         
      } else {
         System.out.println("학생 회원정보 없음");
      }

   }
   
   @ApiOperation(value = "학생 - 비밀번호 재설정", notes = "학생 비밀번호를 재설정한다.")
   @RequestMapping(value = "/updateStudentPW/{s_no}", method = RequestMethod.PUT)
   public void updateStudentPW(@PathVariable int s_no, @PathVariable String s_password) throws Exception {
      System.out.println("학생 비밀번호 재설정");
      
      studentService.updateStudentPW(s_password);
   }
}
