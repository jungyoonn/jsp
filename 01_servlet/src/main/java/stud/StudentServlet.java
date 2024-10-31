package stud;

import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/student") // 도메인 설정
public class StudentServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8"); // 읽어오는 타입 설정, 주석으로 해 놓고 실행하면 물음표로 뜬다
		PrintWriter pw = resp.getWriter();
		pw.println("<body>");
		pw.println("<h1>안녕 세상</h1>");
		pw.println("</body>");
		
		ByteArrayInputStream bais = new ByteArrayInputStream(new byte[] {10, 20, 30});
		CharArrayReader car = new CharArrayReader(new char[] {'가', '나'});
		StringReader sr = new StringReader("가나다라");
		
		System.out.println((char)sr.read());
	}
	
}
