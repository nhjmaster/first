package first.member.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

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
	
	@RequestMapping(value="login.do")
    public ModelAndView login(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/member/login"); 
    	return mv;
    }
	
	// 로그인 처리
	@RequestMapping("loginCheck.do")
	public ModelAndView loginCheck(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		// 두가지 방법으로 가져올 수 있음.
		String userId = (String) commandMap.get("userId");
		String userPw = (String) commandMap.getMap().get("userPw");
		System.out.println("ID: " + userId +  "      userPw: " +  userPw);
		
		Map<String, Object> result = memberService.loginCheck(commandMap.getMap());
		
		if(result != null){
			mv.setViewName("/sample/boardList");
			mv.addObject("msg", "success");
		}else{
			mv.setViewName("/member/login");
			mv.addObject("msg", "fail");
		}
		
    	return mv;
		
	}
	
}
