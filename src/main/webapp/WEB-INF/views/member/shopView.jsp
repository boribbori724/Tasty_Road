<%@page import="com.tasty.member.vo.LoginVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가게 정보 보기</title>

</head>
<body>
<div class="container">
<h1>가게 정보 보기(관리자)</h1>
<table class="table">
	<tbody>
		<tr>
			<th>가게명</th>
			<td class="id">${vo.shopName }</td>
		</tr>
		<tr>
			<th>사업자 등록 번호</th>
			<td class="id">${vo.shopNo}</td>
		</tr>
		<tr>
			<th>주소</th>
			<td class="id">${vo.address }</td>
		</tr>
		<tr>
			<th>가게 정보</th>
			<td class="id">${vo.content}</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td class="id">${vo.tel}</td>
		</tr>
		<tr>
			<th>가게 소개</th>
			<td class="id">${vo.content}</td>
		</tr>
		<tr>
			<th>대표 이미지</th>
			<td class="id"><img src="${vo.image }" /></td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="2">
				<a href="../member/masterShopUpdate.do?id=${vo.id }" class="btn btn-default">가게 정보 수정</a>
				<c:if test="${login.gradeNo == 9 }">
		<!-- 관리자 메뉴 -->
		<a href="../member/memberList.do" class="btn btn-default">회원리스트</a>
	</c:if>
			</td>
		</tr>
	</tfoot>
</table>
</div>
</body>
</html>