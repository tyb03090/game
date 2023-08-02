<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="/user-info/update">
	<input type="hidden" name="uiNum" value="${user.uiNum}">	
	<input type="text" name="uiId" placeholder="아이디" value="${user.uiId}"><br>
	<input type="text" name="uiName" placeholder="이름" value="${user.uiName}"><br>
	<input type="password" name="uiPwd" placeholder="비밀번호" ><br>
	<textarea name="uiDesc" placeholder="소개">${user.uiDesc}</textarea><br>
	<input type="date" name="uiBirth" placeholder="생년월일" value="${user.uiBirth}"><br>
	<button>수정</button>
	<button type="reset">취소</button>
</body>
</html>