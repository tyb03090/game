<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="/user-info/delete">
	<h2>유저 상세화면</h2>
		<input type="hidden" name="uiNum" value="${user.uiNum}">
		이름 : ${user.uiName}<br>
		생년월일 : ${user.uiBirth}<br>
		소개 : ${user.uiDesc}<br>
		가입일 : ${user.credat}<br>
	<button type="button" onclick="location.href='/user-info/update?uiNum=${user.uiNum}'">수정</button>
	<button>삭제</button>
</form>
</body>
</html>