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
					<td id="biNum">${param.biNum }</td>
				</tr>
				<tr>
					<th scope="col">제목</th>
					<td id="biTitle"></td>
				</tr>
				<tr>
					<th scope="col">내용</th>
					<td id="biContent"></td>
				</tr>
				<tr>
					<th scope="col">작성자</th>
					<td id="uiNum"></td>
				</tr>
				<tr>
					<th scope="col">작성일</th>
					<td id="credat"></td>
				</tr>
					<tr>
						<th colspan="2">
							<button type="button"
								onclick="goPage('/board/update?biNum=${board.biNum}')">수정</button>
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
				xhr.open('GET', '/json/one?biNum=${param.biNum}');
				xhr.onreadystatechange = function(){
					if(xhr.readyState === 4){
						if(xhr.status === 200){
							console.log(xhr.responseText);
							const board = JSON.parse(xhr.responseText);
							console.log(board);
							for(let key in board){
								console.log(key);
								if(document.querySelector('#' + key)){
									document.querySelector('#' + key).innerText = board[key];
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