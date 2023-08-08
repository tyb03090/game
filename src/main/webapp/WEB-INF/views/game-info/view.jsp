<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp" />
</head>
<body>
	<h3>게시물 상세화면</h3>
	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">번호</th>
					<td id="giNum">${param.giNum }</td>
				</tr>
				<tr>
					<th scope="col">이름</th>
					<td id="giName"></td>
				</tr>
				<tr>
					<th scope="col">내용</th>
					<td id="giDesc"></td>
				</tr>
				<tr>
					<th scope="col">장르</th>
					<td id="giGenre"></td>
				</tr>
				<tr>
					<th scope="col">작성일</th>
					<td id="credat"></td>
				</tr>
					<tr>
						<th colspan="2">
							<button type="button"
								onclick="goPage('/game-info/update?giNum=${game.giNum}')">수정</button>
							<button>삭제</button>
						</th>
					</tr>
			</thead>
		</table>
		<script>
			function goPage(url) {
				location.href = url;
			}
			function loadFunc(){
				const xhr = new XMLHttpRequest();
				xhr.open('GET', '/json/one?giNum=${param.giNum}');
				xhr.onreadystatechange = function(){
					if(xhr.readyState === 4){
						if(xhr.status === 200){
							console.log(xhr.responseText);
							const game = JSON.parse(xhr.responseText);
							console.log(game);
							for(let key in game){
								console.log(key);
								if(document.querySelector('#' + key)){
									document.querySelector('#' + key).innerText = game[key];
								}
							}
						}
					}
				}
				xhr.send();
			}
			window.addEventListener('load', loadFunc);
		</script>
	</div>
</body>
</html>