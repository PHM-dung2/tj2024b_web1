<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- 부트스트랩 CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<!-- 내가 만든 CSS -->
	<link href="/tj2024b_web1/web/css/index.css" rel="stylesheet" />
</head>
<body>

	<nav class="navbar navbar-expand-lg">
		<!-- bg-body-tertiary : 배경색 -->
		<div class="container">
			<!-- container : 반응형(크기) 구역/박스 -->
			<a class="navbar-brand" href="/tj2024b_web1/web/index.jsp"> <!-- 로고 -->
				<img class="header_logo" src="/tj2024b_web1/web/img/Logo.jpg" />
			</a>
			<!-- 이미지 안올라갈시 서버 clean 후 metadata 이미지 올라왔는지 확인  -->

			<!-- 반응형 토큰(버튼) -->
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<!-- 메뉴박스 -->
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<!-- 왼쪽 메뉴 목록 -->
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<!-- 메뉴항목 -->
					<li class="nav-item"><a class="nav-link" href="/tj2024b_web1/web/board/board.jsp?cno=1">뉴스</a></li>
					<li class="nav-item"><a class="nav-link" href="/tj2024b_web1/web/board/board.jsp?cno=2">이벤트</a></li>
					<li class="nav-item"><a class="nav-link" href="/tj2024b_web1/web/board/board.jsp?cno=3">FAQ</a></li>
					<li class="nav-item"><a class="nav-link" href="/tj2024b_web1/web/board/board.jsp?cno=4">튜토리얼</a></li>
					<li class="nav-item"><a class="nav-link" href="/tj2024b_web1/web/board/board.jsp?cno=5">사용자리뷰</a></li>
					
					<!-- 드롭다운 -->
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> 제품 </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Action</a></li>
							<li><a class="dropdown-item" href="#">Another action</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Something else
									here</a></li>
						</ul></li>
				</ul>
				
				<!-- 오른쪽 메뉴 목록 -->
				<ul class="navbar-nav me-end mb-2 mb-lg-0 LogInMenu"> <!-- me-end : 오른쪽 정렬 --> 
				
				</ul>
			</div>
		</div>
	</nav>

	<!-- 부트스트랩 js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	<script src="/tj2024b_web1/web/js/header.js"></script>
	
</body>
</html>