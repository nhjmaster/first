package first.member.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import first.member.dao.MemberDAO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="memberDAO")
	private MemberDAO memberDAO;

	@Override
	public Map<String, Object> loginCheck(Map<String, Object> map) throws Exception {		
		Map<String, Object> resultMap = memberDAO.loginCheck(map);
		return resultMap;
	}

	
}
