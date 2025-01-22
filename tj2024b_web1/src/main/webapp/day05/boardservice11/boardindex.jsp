<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="/day05/boardservice11/bsheader.jsp"></jsp:include>
	
	<div> 
		<fieldset style="width: 400px; text-align: center;">
			<legend style="font-weight: bold" > 전체 게시물 목록 </legend>
			<table border="1">
				<thead>
					<tr>
						<th> 번호 </th>
						<th> 제목 </th>
						<th> 작성자 </th>
						<th> 조회수 </th>
						<th> 작성날짜 </th>
					</tr>
				</thead>
				<tbody class="tbody">
				
				</tbody>
			</table>
			<hr/>
			<button onclick="location='boardwrite.jsp';" type="button"> 게시물 등록 </button>
		</fieldset>
	</div>

	<jsp:include page="/day05/boardservice11/bsfooter.jsp"></jsp:include>

	<script src="boardservice.js"></script>
</body>
</html>