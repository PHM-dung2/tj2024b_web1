<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='index.css' />
<title>Insert title here</title>
</head>
<body>
	
	<div id="wrap">
		
		<div id="header"> 
			<h1> 기계식 주차장 시스템 </h1>
			<div class="inputBox">
				<div> 주차위치 : </div> 
				<input type="text" class="locationInput" />
				<div> 차량번호 : </div> 
				<input type="text" class="carINput" />
			</div>
			<div class="btnBox">
				<button onclick="" type="button"> 입차 </button>
				<button onclick="" type="button"> 출차 </button>
			</div>
		</div>
	
		<div id="index">
			<form class="parkform">
				
			</form>
		</div>
		
		<div id="footer"> 
			<button onclick="location.href='admin.jsp'" type="button"> 관리자 모드 </button>
		</div>
	</div>
	
	<script src="./js/index.js"></script>
	<script> parkingPrint() </script>
	
</body>
</html>