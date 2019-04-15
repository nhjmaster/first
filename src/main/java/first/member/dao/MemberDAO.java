package first.member.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import first.common.dao.AbstractDAO;

@Repository("memberDAO")
public class MemberDAO extends AbstractDAO{

	@SuppressWarnings("unchecked")
	public Map<String, Object> loginCheck(Map<String, Object> map) throws Exception{
		return (Map<String, Object>) selectOne("member.loginCheck", map);
	}
	
}

