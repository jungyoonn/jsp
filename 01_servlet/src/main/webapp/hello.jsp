<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
		<h1>hello world</h1>
		<%=LocalDateTime.now() %>
		<%
			int num = 10;
		
			for(int i = 2; i < 10; i++) {
				for(int j = 1; j < 10; j++) {
					out.println(String.format("<p>%d * %d = %d</p>", i, j, i*j));
				}
			}
		%>
	</body>
</html>