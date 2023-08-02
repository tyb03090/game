<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${user != null}">
		<h3>${user.uiName}님안녕하세요.</h3>
		<ul>
			<li><a href="/user-info/my">내정보</a></li>
			<li><a href="/board/list">게시판</a></li>
			<li><a href="/user-info/logout">로그아웃</a></li>
		</ul>
	</c:if>
	<c:if test="${user == null}">
		<button onclick="location.href='/user-info/login'">로그인</button>
	</c:if>
</body>
</html>