package servlet.post;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PostService;
import service.PostServiceImpl;
import utils.Commons;
import vo.Member;

@WebServlet("/post/remove")
public class PostRemove extends HttpServlet {
	private PostService service = new PostServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pnoStr = req.getParameter("pno");
		Object memberObj = req.getSession().getAttribute("member");
		
		if(pnoStr == null || memberObj == null) {
			Commons.printMsg("비정상적인 접근입니다", "list", resp);
			return;
		}
		
		Long pno = Long.valueOf(pnoStr);
		Member m = (Member) memberObj; // 세션에 저장된 아이디와 글 작성자가 다르면 삭제 불가
		if(!m.getId().equals(service.findBy(pno).getWriter())) {
			Commons.printMsg("본인이 작성한 글만 삭제할 수 있습니다", "list", resp);
			return;
		}
		
		service.remove(pno);
		
		resp.sendRedirect("list");
	}
}