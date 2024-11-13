package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.Criteria;
import mapper.AttachMapper;
import mapper.PostMapper;
import utils.MybatisInit;
import vo.Post;

public class PostServiceImpl implements PostService {
	
	@Override
	public int write(Post post) {
		try(SqlSession session = MybatisInit.getInstance().sqSessionFactory().openSession(true)) {
			PostMapper mapper = session.getMapper(PostMapper.class);
			AttachMapper attachMapper = session.getMapper(AttachMapper.class);
			mapper.insert(post);
			
			post.getAttachs().forEach(a -> {
				a.setPno(post.getPno());
				attachMapper.insert(a);
			});
			return 0;
		}
	}

	@Override
	public int modify(Post post) {
		try(SqlSession session = MybatisInit.getInstance().sqSessionFactory().openSession(true)) {
			PostMapper mapper = session.getMapper(PostMapper.class);
			return mapper.update(post);
		}
	}

	@Override
	public int remove(Long pno) {
		try(SqlSession session = MybatisInit.getInstance().sqSessionFactory().openSession(true)) {
			PostMapper mapper = session.getMapper(PostMapper.class);
			AttachMapper attachMapper = session.getMapper(AttachMapper.class);
			attachMapper.delete(pno);
			return mapper.delete(pno);
		}
	}

	@Override
	public Post findBy(Long pno) {
		try(SqlSession session = MybatisInit.getInstance().sqSessionFactory().openSession(true)) {
			PostMapper mapper = session.getMapper(PostMapper.class);
			return mapper.selectOne(pno);
		}
	}

	@Override
	public List<Post> list(Criteria cri) {
		try(SqlSession session = MybatisInit.getInstance().sqSessionFactory().openSession(true)) {
			PostMapper mapper = session.getMapper(PostMapper.class);
			return mapper.selectList(cri);
		}
	}

	@Override
	public Post view(Long pno) {
		try(SqlSession session = MybatisInit.getInstance().sqSessionFactory().openSession(true)) {
			PostMapper mapper = session.getMapper(PostMapper.class);
			AttachMapper attachMapper = session.getMapper(AttachMapper.class);
			Post post = mapper.selectOne(pno);
			post.setAttachs(attachMapper.selectList(pno));
			mapper.increaseViewCount(pno);
			return post;
		}
	}

	@Override
	public int count(Criteria cri) {
		try(SqlSession session = MybatisInit.getInstance().sqSessionFactory().openSession(true)) {
			PostMapper mapper = session.getMapper(PostMapper.class);
			return mapper.getCount(cri);
		}
	}
	
	
}
