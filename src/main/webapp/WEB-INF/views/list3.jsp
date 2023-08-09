<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>나이</th>
			<th>주소</th>
		</tr>
		<tbody id="tBody"></tbody>
	</table>
	<script>
		function starve(){
			const xhr = new XMLHttpRequest();
			xhr.open('GET', '/list3');
			xhr.onreadystatechange = function(){
				if(xhr.readyState === 4){
					if(xhr.status === 200){
						const list = JSON.parse(xhr.responseText);
						let html = '';
						
						for(const shit of list){
							html += '<tr>';
							html += '<td>' + shit.num + '</td>';
							html += '<td>' + shit.name + '</td>';
							html += '<td>' + shit.age + '</td>';
							html += '<td>' + shit.address + '</td>';
							html += '</tr>';
						}
						document.querySelector('#tBody').innerHTML = html;
						console.log(html);
					}
				}
			}
			xhr.send();
		}
		window.addEventListener('load', starve); 
	</script>
</body>
</html>