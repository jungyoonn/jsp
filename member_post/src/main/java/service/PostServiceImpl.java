package service;

import java.util.List;

import dao.PostDao;
import dto.Criteria;
import vo.Post;

public class PostServiceImpl implements PostService {
	private PostDao postDao = new PostDao();
	
	@Override
	public int write(Post post) {
		return postDao.insert(post);
	}

	@Override
	public int modify(Post post) {
		return postDao.update(post);
	}

	@Override
	public int remove(Long pno) {
		return postDao.delete(pno);
	}

	@Override
	public Post findBy(Long pno) {
		Post p = postDao.selectOne(pno);
//		return p != null ? postDao.selectOne(pno) : null;
		return p;
	}

	@Override
	public List<Post> list(Criteria cri) {
		return postDao.selectList(cri);
	}

	@Override
	public Post view(Long pno) {
		postDao.increaseViewCount(pno);
		return findBy(pno);
	}

	@Override
	public int count(Criteria cri) {
		return postDao.getCount(cri);
	}
	
	
}
