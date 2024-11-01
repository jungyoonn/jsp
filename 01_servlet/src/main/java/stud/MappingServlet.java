package stud;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MappingServlet  extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("mapping");
	}

}

//	web.xml 파일의 </welcome-file-list> 밑에다가
//	
//	/*
//	<servlet>
//	    <servlet-name>test</servlet-name>
//	    <servlet-class>stud.MappingServlet</servlet-class>
//	</servlet>
//	<servlet-mapping>
//	    <servlet-name>test</servlet-name>
//	    <url-pattern>/1234</url-pattern>
//	</servlet-mapping>
//	*/
//	
//	<servlet></servlet>과 <servlet-mapping></servlet-mapping>은 한 쌍이다
//	위 작업 후 서버를 구동하면 로컬호스트/프로젝트이름/1234 라는 url로 웹이 켜진다
//	이것을 "서블릿이 url에 맵핑되었다"라고 한다
//	
//	이 귀찮은 작업을 하지 않으려면 자바 클래스에다가 @WebServlet("/1234")를 쓰면 된다