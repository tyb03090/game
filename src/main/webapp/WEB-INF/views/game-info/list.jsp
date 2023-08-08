<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게임 목록</h2>
	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">이름</th>
					<th scope="col">장르</th>
				</tr>
			</thead>
			<tbody id="tBody"></tbody>
		</table>
	</div>
	<script>
		function goPage(url){
			location.href = url;
		}
		const loadFunc = function(){
			const xhr = new XMLHttpRequest();
			
			xhr.open('GET', '/game-info/list');
			xhr.onreadystatechange = function(){
				if(xhr.readyState === 4){
					if(xhr.status === 200){
						console.log(xhr.responseText);
						const list = JSON.parse(xhr.responseText);
						let html = '';
						for(const game of list){
							html += '<tr>';
							html += '<td>' + game.giNum + '</td>';
							html += '<td><a href="/views/game-info/view?giNUm=' + game.giNum + '">' + game.giName + '</td>';
							html += '<td>' + game.giGenre + '</td>';
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