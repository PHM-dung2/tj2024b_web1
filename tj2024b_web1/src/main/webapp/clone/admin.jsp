<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN</title>
<style>
a {
	text-decoration: none;
	color: white;
}

.headerBtn {
	margin-left: 468px;
}

button {
	margin: 5px;
	padding: 5px 10px;
	background-color: #4CAF50;
	color: white;
	border: none;
	cursor: pointer;
}

table {
	width: 800px;
	border-collapse: collapse; /* 테두리가 겹쳐 보이지 않게 */
	margin-top: 20px;
	border-collapse: collapse;
}

th, td {
	padding: 12px 15px; /* 셀 안쪽 여백 */
	text-align: center; /* 텍스트 중앙 정렬 */
	font-size: 14px; /* 글자 크기 */
}

th {
	background-color: #f4f4f4; /* 헤더 배경색 */
	color: #333; /* 글자색 */
	font-weight: bold; /* 글자 굵게 */
}

td {
	border-bottom: 1px solid #ddd; /* 각 셀 아래에 경계선 추가 */
}

table, th, td {
	border: 1px solid #ddd; /* 표 테두리 색상 */
}
</style>
</head>
<body>
	<h2>
		주차장시스템(관리자)
		<button class="headerBtn">
			<a href="/tj2024b_web1/clone/user.jsp"> 사용자 전환</a>
		</button>
	</h2>

	<table border="1">
		<thead>
			<tr>
				<th>순번</th>
				<th>차량번호</th>
				<th>주차위치</th>
				<th>입차시간</th>
				<th>출차시간</th>
				<th>주차상태</th>
				<th>기타</th>
			</tr>
		</thead>
		<tbody>
			
		</tbody>
	</table>
	<script src ="admin.js"></script>
	
</body>
</html>