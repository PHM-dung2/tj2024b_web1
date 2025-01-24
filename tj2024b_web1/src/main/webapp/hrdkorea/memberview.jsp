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
			<h2> 회원목록조회/수정 </h2>
			<div>
				<table>
					<thead border="1">
						<tr>
							<th> 회원번호 </th>
							<th> 회원성명 </th>
							<th> 전화번호 </th>
							<th> 주소 </th>
							<th> 가입일자 </th>
							<th> 고객등급 </th>
							<th> 거주지역 </th>
						</tr>
					</thead>
					
					<tbody>	
						
					</tbody>
				</table>
			</div>
		</div>
		
		<jsp:include page="/hrdkorea/footer.jsp"></jsp:include>
	</div>
	
</body>
</html>