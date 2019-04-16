package first.home;

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
public class HomeController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="memberService")
	private MemberService memberService;
	
	// 로그인 처리
	@RequestMapping(value="/home/home.do")
	public ModelAndView home(HttpServletRequest request,HttpServletResponse response, CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		// 두가지 방법으로 가져올 수 있음
		String userId = (String) commandMap.get("userId");
		String userPw = (String) commandMap.getMap().get("userPw");
		System.out.println("ID: " + userId +  "      userPw:  " +  userPw);
		
		Map<String, Object> result = memberService.loginCheck(commandMap.getMap());
		
		HttpSession session = request.getSession();
		
		if(result != null){
			
			// 세션 셋팅
			session.removeAttribute("Session");
			session.setAttribute("userId", userId);      
			session.setAttribute("userPw", userPw);      
			session.setAttribute("Session", commandMap); 
			session.setMaxInactiveInterval(600);	     // 세션 600초 설정
			
			mv.setViewName("/home");
			mv.addObject("msg", "success");			
		}else{			
			session.removeAttribute("Session");
			mv.setViewName("/member/login");
			mv.addObject("msg", "fail");
		}
    	return mv;
	}
	
	
}
