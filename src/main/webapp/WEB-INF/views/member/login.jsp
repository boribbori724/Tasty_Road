<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<link href="/resources/css/style.css" rel="stylesheet"/>

</head>
<body>
<div class="main">
<!-- 	<header> -->
<!-- 		<div class="logo"> -->
<!-- 		<a href="https://www.naver.com/" target="_blank" title="네이버 홈페이지"><img src="image/NAVER_LOGO.png" class="image"></a> -->
<!-- 		</div> -->
<!-- 	</header> -->
<form action="login.do" method="post">
<section class="login-wrap">
	<div class="form-group login-id-wrap">
		<input placeholder="아이디" type="text" class="input-id" name="id" id="id" style="background:#fff;" autocomplete="off" />
	</div>
	<div class="form-group login-pw-wrap">
		<input placeholder="비밀번호" type="password" class="input-pw" name="pw" id="pw" style="background:#fff;" autocomplete="off"></input>
	</div>
	<div class="login-btn-wrap">
		<button class="login-btn">로그인</button>
	</div>
	</section>
</form>
<section class="find-signup-wrap">

			<span class="find-id">
				<a href="findIdForm.do">아이디 찾기</a>
			</span>

			<span class="find-pw">
				<a href="findPwForm.do">비밀번호 찾기</a>
			</span>

			<span class="sign-up">
				<a href="joinForm.do">회원가입</a>
			</span>

		</section>
</div>
</body>
</html>