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
		<fieldset style="width: 310px; text-align: center;">
			<legend style="font-weight: bold" > 개별 게시물 목록 </legend>
			<table border="1" class="table">
				<tr>
					<th> 제목 </th>
					<td> <input class="btitleInput" style="border:none" disabled/> </td>
				</tr>
				<tr>
					<th> 작성자 / 조회수 </th>
					<td> <input class="bwriterInput" style="border:none" disabled /> </td>
				</tr>
				<tr>
					<th> 작성날짜 </th>
					<td> <input class="bdateInput" style="border:none" disabled /> </td>
				</tr>
				<tr>
					<th> 내용 </th>
					<td> <input class="bcontentInput" style="border:none" disabled /> </td>
				</tr>
			</table>
			
			<button onclick="hrefPage( 'update' )" type="button" > 수정 </button>
			<button onclick="boardDelete()" type="button" > 삭제 </button>
		</fieldset>
	</div>
	
	<jsp:include page="/day05/boardservice11/bsfooter.jsp"></jsp:include>
	
	<script src="boardview.js"></script>
</body>
</html>