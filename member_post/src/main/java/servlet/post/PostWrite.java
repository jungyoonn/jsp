package servlet.post;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Criteria;
import service.PostService;
import service.PostServiceImpl;
import vo.Attach;
import vo.Post;

@WebServlet("/post/write")
public class PostWrite extends HttpServlet {
	private PostService service = new PostServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Criteria cri = new Criteria(req);
		
		if(req.getSession().getAttribute("member") == null) {
			String cp = req.getContextPath();
			resp.sendRedirect(cp + "/signin?url=" + 
						URLEncoder.encode(cp + "/post/write?" + cri.getQs2(), "utf-8"));
			return;
		}
			
		req.setAttribute("cri", cri);
		req.getRequestDispatcher("/WEB-INF/jsp/post/write.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Criteria cri = new Criteria(req);
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		
		List<Attach> attachs = new ArrayList<Attach>();
		
		// 첨부파일 정보 수집
		String[] uuids = req.getParameterValues("uuid");
		String[] origins = req.getParameterValues("origin");
		String[] images = req.getParameterValues("image");
		String[] paths = req.getParameterValues("path");
		
		if(uuids != null ) {
			for(int i = 0; i < uuids.length; i++) {
				attachs.add(Attach.builder()
						.uuid(uuids[i])
						.origin(origins[i])
						.image(images[i].equals("true"))
						.path(paths[i])
						.build());
			}
		}
		
		Post post = Post.builder()
				.title(title)
				.writer(writer)
				.content(content)
				.cno(cri.getCategory())
				.attachs(attachs)
				.build();
		service.write(post);
		
		resp.sendRedirect("list?" + cri.getQs2());
	}

}
