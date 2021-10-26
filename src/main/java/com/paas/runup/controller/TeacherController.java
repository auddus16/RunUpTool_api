package com.paas.runup.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.paas.runup.dto.TeacherDTO;
import com.paas.runup.email.EmailUtil;
import com.paas.runup.service.TeacherService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value="/teacher")
public class TeacherController {
   
   @Autowired
   private TeacherService teacherService;
   
   @Autowired
   private EmailUtil emailUtil;
   
   @ResponseBody
   
   @ApiOperation("선생님 - 마이페이지 조회")
   @ApiImplicitParam(name="t_no", value="선생님 번호", example = "1")
   @RequestMapping(value= "/getTeacher", method=RequestMethod.GET)
   public TeacherDTO getTeacher(@PathVariable int t_no) throws Exception{
      System.out.println("선생님테이블 전체 검색 메소드-START");
      
      return teacherService.selectTeacher(t_no);
   }
   
   @ApiOperation("선생님 - 회원가입")
   @RequestMapping(value= "/signupTeacher", method=RequestMethod.POST)
   public void signupTeacher(@RequestBody TeacherDTO t) throws Exception{
      System.out.println("선생님테이블 삽입 메소드-START");
      teacherService.insertTeacher(t);
   }
   
   @ApiOperation(value= "선생님 - 회원가입 이메일 인증", notes="선생님 회원가입을 위해 이메일을 인증한다.")
   @RequestMapping(value= "/TeacherEmail", method = RequestMethod.POST)
   public boolean saveLocation(HttpServletRequest request, @PathVariable String email) {
      System.out.println("선생님 이메일 인증 시작");

      emailUtil.sendEmail(email+"님께 인증 메일이 발송되었습니다.","성공적으로 런업툴 회원가입을 위해 이메일 인증이 필요합니다.", "링크를 클릭하세요.");
      return true;
   }
   
   
   @ApiOperation("선생님 - 회원정보 수정")
   @RequestMapping(value= "/updateTeacher", method=RequestMethod.PUT)
   public void updateTeacher(HttpServletRequest request, @RequestBody TeacherDTO t) throws Exception{
      System.out.println("선생님테이블 갱신 메소드-START");
      Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary("jwtpassword"))
            .parseClaimsJws(request.getHeader("jwt").substring(7)).getBody();

      t.setT_no((int)claims.get("user_no"));
      teacherService.updateTeacher(t);
   }
   

   @ApiOperation("선생님 - 회원정보 탈퇴")
   @RequestMapping(value= "/deleteTeacher", method=RequestMethod.DELETE)
   public void deleteTeacher(HttpServletRequest request) throws Exception{
      System.out.println("선생님테이블 삭제 메소드-START");
      Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary("jwtpassword"))
            .parseClaimsJws(request.getHeader("jwt").substring(7)).getBody();

      int t_no = (int)claims.get("user_no");
      teacherService.deleteTeacher(t_no);
   }
   
   
    @ApiOperation(value = "선생님 - 아이디찾기")
    @RequestMapping(value = "/searchTeacherID", method= RequestMethod.GET)
    public String searchTeacherID(@PathVariable String t_name, @PathVariable String t_email ) throws Exception {
      System.out.println("선생님아이디찾기 메소드-START");
      String t_id = teacherService.searchTeacherID(t_name, t_email);
      
      
      if (t_id != null) {
         System.out.println("선생님 회원정보 있음");
         return t_id;
      }
      else {
         System.out.println("선생님 회원정보 없음");
         return null;
      }
         
   }
    

    @ApiOperation(value = "선생님 - 비밀번호찾기")
    @RequestMapping(value = "/searchTeacherPW", method= RequestMethod.GET)
    public void searchTeacherPW(@PathVariable String t_name, @PathVariable String t_id, @PathVariable String t_email ) throws Exception {
      System.out.println("선생님비밀번호찾기 메소드-START");
      TeacherDTO teacherDTO = teacherService.searchTeacherPW(t_name, t_id, t_email);
      
      if (teacherDTO != null) {
         System.out.println("선생님 회원정보 있음");
         System.out.println("이메일 전송!");
         emailUtil.sendEmail(t_email+"님께 인증 메일이 발송되었습니다.","런업툴 비밀번호 재설정을 위해 이메일 인증이 필요합니다.", "링크를 클릭하세요.");
      }
      else {
         System.out.println("선생님 회원정보 없음");
      }
         
   }

    
    @ApiOperation(value="선생님 - 비밀번호재설정")
   @RequestMapping(value="/updateSTeacherPW", method=RequestMethod.PUT)
   public void uupdateSTeacherPW(@PathVariable int t_no, @PathVariable String t_password) throws Exception{
       System.out.println("선생님비밀번호재설정 메소드-START");
       teacherService.updateTeacherPW(t_password);
   }
   
}