<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="head.jsp" />
    </head>
    <body>
        <div class="wrap">
        	<jsp:include page="header.jsp" />
            <main class="container">
                <div class="row">
                    <div class="col-md-9">
                        <div class="p-3">
                            <h1>index</h1>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class=" d-grid gap-2 p-3">
                        <%
                        	Object o = session.getAttribute("member");
                        	if(o == null) {
                        %>
                            <a href="signin" class="btn btn-dark btn-block">로그인</a>
                            <div class="small clearfix">
                                <a href="signup" class="small float-start text-dark text-decoration-none">회원가입</a>
                                <a href="signup.html" class="small float-end text-dark text-decoration-none">아이디/비밀번호 찾기</a>
                            </div>
                            
                        <%
                        	} else {
                        		Member m = (Member) o;
                        %>
                            <p><a href="mypage.html" class="text-dark text-decoration-none"><strong><%= m.getName() %></strong></a>님 환영합니다</p>
                            <div class="small clearfix">
                                <a href="logout.html" class="btn btn-dark btn-sm float-start text-white text-decoration-none">로그아웃</a>
                                <a href="mypage.html" class="btn btn-dark btn-sm small float-end text-white text-decoration-none">마이페이지</a>
                            </div>
                        <%
                        	}
                        %>
                        </div>
                    </div>
                </div>
            </main>
            <jsp:include page="footer.jsp" />
        </div>
    </body>
</html>