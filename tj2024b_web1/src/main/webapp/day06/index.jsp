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
		</div>
	
		<div id="index">
			<form class="parkform">
				
			</form>
		</div>
	</div>
	
	<script src="./js/index.js"></script>
	<script> parkingPrint() </script>
	
</body>
</html>