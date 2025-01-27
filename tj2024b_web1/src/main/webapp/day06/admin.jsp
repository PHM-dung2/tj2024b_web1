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
				<h3> 관리자 - 입/출차 내역 </h3>
			</div>
			<div class="btnBox">
				<button onclick="parkingInoutAllList()" type="button"> 입/출차내역 </button>
				<button onclick="parkingInoutList(0)" type="button"> 입차내역 </button>
				<button onclick="parkingInoutList(1)" type="button"> 출차내역 </button>
			</div>
		</div>
	
		<div id="index">
			<form class="parkform">
				<table border="1">
					<thead>
						<tr>
							<th>번호</th>							
							<th>차량번호</th>
							<th>상태</th>
							<th>입차/출차시간</th>
							<th>금액</th>
						</tr>
					</thead>
					<tbody>
						<!-- 자바스크립트에서 자동 생성 -->
					</tbody>
				</table>	
			</form>			
		</div>
		
		<div id="footer"> 
			<button onclick="location.href='index.jsp'" type="button"> 입/출차 등록 </button>
		</div>
	</div>
	
	<script src="./js/admin.js"></script>
	<script>parkingInoutAllList()</script>
	
</body>
</html>