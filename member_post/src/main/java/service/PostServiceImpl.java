package service;

import java.util.List;

import dao.PostDao;
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
	public List<Post> list() {
		return postDao.selectList();
	}

}
