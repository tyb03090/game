<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"/>
</head>
<body>
	<h2>게시판 목록</h2>
	<form action="/board/list" method="GET">
	<select name="searchType">
		<option value="1">제목</option>
		<option value="2">작성자</option>
		<option value="3">내용</option>
		<option value="4">제목 + 내용</option>
		<option value="5">작성자 + 내용</option>
		<option value="6">제목 + 작성자</option>
		<option value="7">제목 + 작성자 + 내용</option>
	</select>
	<input type="text" name="searchStr" placeholder="검색어">
	<button>검색</button>
	</form>
	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">제목</th>
					<th scope="col">작성자</th>
					<th scope="col">작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boardList}" var="board">
				<tr>
					<td>${board.biNum}</td>
					<td><a href="/board/view?biNum=${board.biNum}">${board.biTitle}</a></td>
					<td>${board.uiName}</td>
					<td>${board.credat}</td>
				</tr>
				</c:forEach>
				<tr>
					<td colspan="4" align="right">
						<button type="button" class="btn btn-primary" onclick="goPage('/board/insert')">등록</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>