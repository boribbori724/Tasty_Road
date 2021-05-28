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
<form action="shopDelete.do" method="post">
<section class="login-wrap">
	<div class="form-group login-id-wrap">
		<input placeholder="아이디" type="text" class="input-id" name="id" id="id" style="background:#fff;" value="${vo.id }" readonly/>
	</div>
	<div class="login-btn-wrap">
		<button class="login-btn">기업 삭제</button>
	</div>
	</section>
</form>
</div>
</body>
</html>