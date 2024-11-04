package servlet.member;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Member;

@WebServlet("/signup")
public class Signup extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/member/signup.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String roadAddr = req.getParameter("roadAddr");
		String detailAddr = req.getParameter("detailAddr");
		
		Member member = Member.builder()
						.id(id)
						.pw(pwd)
						.name(name)
						.email(email)
						.roadAddr(roadAddr)
						.detailAddr(detailAddr)
						.build();
		System.out.println(member);
	}
}
