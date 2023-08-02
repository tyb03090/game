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
	<h2>사용자 목록</h2>
	<c:forEach items="${userInfoList}" var="user">
		${user.uiNum}, ${user.uiName}, <a href="/user-info/view?uiNum=${user.uiNum}">${user.uiId}</a><br>
	</c:forEach>
	<br><a href="/user-info/insert">등록</a>
</body>
</html>