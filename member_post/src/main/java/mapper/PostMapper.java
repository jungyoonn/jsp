package mapper;

import java.util.List;

import dto.Criteria;
import vo.Post;

public interface PostMapper {
	int insert(Post post);

	Post selectOne(Long pno);

	List<Post> selectList(Criteria cri);
	
	int getCount(Criteria cri);
	
	int update(Post post);
	
	int increaseViewCount(Long pno);
	
	int delete(Long pno);
}
