<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
        <meta charset='utf-8'>
        <meta http-equiv='X-UA-Compatible' content='IE=edge'>
        <title>Page Title</title>
        <meta name='viewport' content='width=device-width, initial-scale=1'>
        <link rel="icon" href="imgs/favicon.ico">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bxslider@4.2.17/dist/jquery.bxslider.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/css/bootstrap.min.css" integrity="sha512-jnSuA4Ss2PkkikSOLtYs8BlYIeeIK1h99ty4YfvRPAlzr377vr3CXDb7sb7eEEBYjDtcYj+AjBH3FLv5uSJuXg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <style>
            form {
                box-shadow: -3px -3px 4px #aaa;
            }
        </style>
        <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bxslider@4.2.17/dist/jquery.bxslider.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.bundle.min.js" integrity="sha512-7Pi/otdlbbCR+LnW+F7PwFcSDJOuUJB3OxtEHbg4vSMvzvJjde4Po1v4BR9Gdc9aXNUNFVUY+SK51wWT8WF0Gg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script>
            $(function() {
            	
            });
        </script>
    </head>
    <body>
        <div class="wrap">
            <header class="container-fluid bg-light">
                <div class="container clearfix p-2">
                    <a href="index.html" class="float-start"><img src="imgs/logo.png" alt="로고" class="img-fluid" width="250"></a>
                    <h1 class="text-center fw-bold p-3">게시판 레이아웃</h1>
                </div>
            </header>
            
            <nav class="navbar bg-dark navbar-expand-sm">
                <ul class="navbar-nav container justify-content-start">
                    <li class="nav-item mx-4"><a class="text-white nav-link" href="index.html">메인 페이지</a></li>
                    <li class="nav-item mx-4"><a class="text-white nav-link" href="mypage.html">마이 페이지</a></li>
                    <li class="nav-item mx-4"><a class="text-white nav-link" href="board.html?category=1">공지사항</a></li>
                    <li class="nav-item dropdown mx-4">
                        <a class="text-white nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">게시판</a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="board.html?category=2">자유게시판</a></li>
                            <li><a class="dropdown-item" href="board.html?category=3">자료실</a></li>
                            <li><a class="dropdown-item" href="gallery.html">갤러리</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>

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
            <footer class="bg-secondary text-center p-4 mt-5">
                <address>서울특별시 구로구 디지털로 306 대륭포스트 타워 2차 2층 더조은 아카데미 204호</address>
                <p>All rights resereved &copy; copyright.</p>
            </footer>
        </div>
    </body>
</html>