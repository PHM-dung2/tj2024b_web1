<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>USER</title>
<style>
a{ 
text-decoration : none;
color : white;}
button {
	margin: 5px;
	padding: 5px 10px;
	background-color: #4CAF50;
	color: white;
	border: none;
	cursor: pointer;
}

.carLoInput {
	margin-bottom: 20px;
}

input {
	width: 250px;
	height: 30px;
	margin-bottom: 10px;
}
</style>
</head>
<body>

	<div>
		<h2>
			주차장시스템(사용자)
			<button class="headerBtn"><a href ="/tj2024b_web1/clone/admin.jsp">관리자</a></button>
		</h2>
	</div>
	차량번호 : <input class="carNumInput"/><br/>
	주차위치 : <input class="carLoInput"/><br/>
	<button onclick="inCar()">입차</button>
	<button onclick="updateOutCar()">조회</button>

	<div class="carValue">

	</div>

	<script src="user.js"></script>
</body>
</html>