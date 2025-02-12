<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:include page="/web/header.jsp"></jsp:include>
	<div class="container"> <!-- container -->
		<button onclick="location.href='write.jsp'" type="button"> 글쓰기 </button>
		<table class="table boardlist">
			<thead>
				<tr>
					<th> 번호 </th>
					<th> 제목 </th>
					<th> 작성자 </th>
					<th> 작성일 </th>
					<th> 조회수 </th>
				</tr>
			</thead>
			
			<tbody>
			
			</tbody>
		</table>

		<nav aria-label="Page navigation example">
			<ul class="pagination pagebtnbox justify-content-center">
				
			</ul>
		</nav>

	</div>

	<jsp:include page="/web/footer.jsp"></jsp:include>

	<script src="/tj2024b_web1/web/js/board/board.js"></script>

</body>
</html>