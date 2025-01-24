<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='index.css'>
<title>Insert title here</title>
</head>
<body>
	
	<div id="wrap">
		<jsp:include page="/hrdkorea/header.jsp"></jsp:include>
		<jsp:include page="/hrdkorea/menu.jsp"></jsp:include>
		
		<div id="index">
			<h2> 홈쇼핑 회원 등록 </h2>
			<div>
				<table border="1">
					<tr>
						<th> 회원번호(자동발생) </th>
						<td width="400px"> <input maxlength="6" /> </td>
					</tr>
					<tr>
						<th> 회원성명 </th>
						<td> <input type="text" maxlength="20" /> </td>
					</tr>
					<tr>
						<th> 회원전화 </th>
						<td> <input width="150px" type="tel" maxlength="13" /> </td>
					</tr>
					<tr>
						<th> 회원주소 </th>
						<td> <input width="200px" type="text" maxlength="60" /> </td>
					</tr>
					<tr>
						<th> 가입일자 </th>
						<td> <input type="text" /> </td>
					</tr>
					<tr>
						<th> 고객등급 [ A:VIP, B:일반, C:직원 ] </th>
						<td> <input type="text" maxlength="1" /> </td>
					</tr>
					<tr>
						<th> 도시코드 </th>
						<td> <input maxlength="2" /> </td>
					</tr>
					<tr>
						<td class="btn" colspan="2">
							<button onclick="" type="button" > 등록 </button>
							<button onclick="location.href='memberview.jsp'" type="button" > 조회 </button>
						</td>
					</tr>
				</table>
			</div>
		</div>
		
		<jsp:include page="/hrdkorea/footer.jsp"></jsp:include>
	</div> 
	
	<script src="member.js"></script>
	
</body>
</html>