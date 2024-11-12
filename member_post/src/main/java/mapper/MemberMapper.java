package mapper;

import java.util.List;

import vo.Member;

public interface MemberMapper {
	int insert (Member member);
	
	Member selectOne(String id);
	
	List<Member> selectList();
	
	int delete(String id);
}
