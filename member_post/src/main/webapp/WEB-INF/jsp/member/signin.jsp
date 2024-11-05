<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="../common/head.jsp" />
        <style>
            form {
                box-shadow: -3px -3px 4px #aaa;
            }
        </style>
        <script>
            $(function() {
            	
            });
        </script>
    </head>
    <body>
        <div class="wrap">
            <jsp:include page="../common/header.jsp" />
            <main class="container">
                <form name="form" method="post" class="mx-auto col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4 col xxl-3 card p-3 mt-5">
                    <h4 class="text-center mt-2">로그인</h4>
                    <input type="text" class="form-control my-2" id="id" placeholder="아이디" name="id">
                    <input type="password" class="form-control my-2" id="pwd" placeholder="비밀번호" name="pwd">
                    <div class="form-check form-switch my-3">
                        <input class="form-check-input" type="checkbox" id="mySwitch" name="remember-id" value="yes">
                        <label class="form-check-label" for="mySwitch">로그인 정보 저장하기</label>
                    </div>
                    <button class="btn btn-dark">로그인</button>
                </form>
            </main>
            <jsp:include page="../common/footer.jsp" />
        </div>
    </body>
</html>