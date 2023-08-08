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
	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">이름</th>
					<th scope="col">아이디</th>
					<th scope="col">생년월일</th>
					<th scope="col">가입날짜</th>
				</tr>
			</thead>
			<tbody id="tBody"></tbody>
			<tr>
				<br>
				<a href="/user-info/insert">등록</a>
			</tr>
		</table>
	</div>
	<script>
	function goPage(url){
		location.href = url;
	}
	const loadFunc = function(){
		const xhr = new XMLHttpRequest();
		
		xhr.open('GET', '/user-info/list');
		xhr.onreadystatechange = function(){
			if(xhr.readyState === 4){
				if(xhr.status === 200){
					console.log(xhr.responseText);
					const list = JSON.parse(xhr.responseText);
					let html = '';
					for(const user of list){
						html += '<tr>';
						html += '<td>' + user.uiNum + '</td>';
						html += '<td><a href="/views/user-info/view?uiNum=' + user.uiNum + '">' + user.uiName + '</td>';
						html += '<td>' + user.uiId + '</td>';
						html += '<td>' + user.uiBirth + '</td>';
						html += '<td>' + user.credat + '</td>';
						html += '</tr>';
					}
					document.querySelector('#tBody').innerHTML = html;
				}
			}
		}
		xhr.send();
	}
	window.addEventListener('load', loadFunc);
	</script>
</body>
</html>