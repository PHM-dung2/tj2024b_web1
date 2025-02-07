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
	
	<div class="container">
		<div> 
			<span class="midbox"> 작성자 구역 </span>
			<span class="viewbox"> 조회수 구역 </span>
			<span class="datebox"> 작성일 구역 </span>
		</div>
		<div class="titlebox"> 제목이 들어갈 구역 </div>
		<div class="contentbox"> 본문이 들어갈 구역 </div>
	</div>
	
	<jsp:include page="/web/footer.jsp"></jsp:include>
	
	<script src="/tj2024b_web1/web/js/board/view.js"></script>

</body>
</html>