package first.member.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import first.common.common.CommandMap;
import first.member.service.MemberService;


@Controller
@RequestMapping("/member/*")
public class MemberController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="memberService")
	private MemberService memberService;
	
	@RequestMapping(value="home.do")
    public ModelAndView home(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/member/home");
    	return mv;
    }
	
	@RequestMapping(value="login.do")
    public ModelAndView login(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/member/login"); 
    	return mv;
    }
	
	@RequestMapping(value="signUp.do")
    public ModelAndView signUp(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/member/signUp"); 
    	return mv;
    }
	
	// 게시판 이동
	@RequestMapping(value="boardList.do")
    public ModelAndView boardList(HttpServletRequest request, HttpServletResponse response, HttpSession session, CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/sample/boardList");    	
    	
    	String sessionId = (String) session.getAttribute("userId");
    	String sessionPw = (String) session.getAttribute("userPw");
    	
    	System.out.println("Session ID: " + sessionId);
    	System.out.println("Session PW: " + sessionPw);
    	
    	return mv;
    }
	
	// 로그아웃
	@RequestMapping(value="logout.do")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, HttpSession session, CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/member/login"); 
    	
    	// 세션 정보 제거
    	session.removeAttribute("userId");
    	session.removeAttribute("userPw");
    	System.out.println("session" + session);
    	
    	return mv;
    }
	
}
