<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="../common/head.jsp" />
    </head>
    <body>
        <div class="wrap">
            <jsp:include page="../common/header.jsp" />
            <main class="container">
            <div class="clearfix py-4">
            	<h2 class="float-start">Post View</h2>
           	</div>
                <div class="col md-9 mx-auto">
                    <label for="title" class="form-label mt-3"><i class="fa-solid fa-pen"></i> <b>제목:</b></label>
                    <input type="text" class="form-control" id="title" placeholder="글 제목을 입력해 주세요" name="title" value="${post.title}" disabled>

                    <label for="content" class="form-label mt-3"><i class="fa-regular fa-clipboard"></i> <b>내용:</b></label>
                    <textarea class="form-control" id="content" placeholder="내용을 입력해 주세요" name="content" rows="15" disabled>${post.content}</textarea>

                    <label for="writer" class="form-label mt-3"><i class="fa-solid fa-user-pen"></i> <b>작성자:</b></label>
                    <input type="text" class="form-control" id="writer" name="writer" value="${post.writer}" disabled>
                    
                    <label for="regdate" class="form-label mt-3"><i class="fa-regular fa-calendar"></i> <b>작성일:</b></label>
                    <input type="text" class="form-control" id="regdate" name="regdate" value="${post.regdate}" disabled>

                    <label for="updatedate" class="form-label mt-3"><i class="fa-regular fa-calendar-plus"></i> <b>수정일:</b></label>
                    <input type="text" class="form-control float-end" id="updatedate" name="updatedate" value="${post.updatedate}" disabled>

                    <div class="text-center my-5">
	                    <c:if test="${post.writer == member.id}">
	                        <a href="modify?pno=${post.pno}" class="btn btn-outline-dark">수정</a>
	                        <a href="remove?pno=${post.pno}" class="btn btn-secondary" onclick="return confirm('삭제하시겠습니까?')">삭제</a>
	                    </c:if>
                        <a href="list" class="btn btn-dark">목록</a>
                    </div>
                </div>
            </main>
            <jsp:include page="../common/footer.jsp" />
        </div>
    </body>
</html>