package servlet.member;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import service.MemberServiceImpl;
import vo.Member;

@WebServlet("/signin")
public class Signin extends HttpServlet{
	private MemberService service = new MemberServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/member/signin.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		System.out.println(id + " :::: " + pwd);
		
		if(service.login(id, pwd)) {
			// 로그인 성공 (세션 생성)
			HttpSession session = req.getSession();
			session.setAttribute("member", service.findBy(id)); 
			resp.sendRedirect(req.getContextPath() + "/index");		
		} else {
			// 로그인 실패
			resp.sendRedirect("login?msg=fail");
		}
		
	}
}
