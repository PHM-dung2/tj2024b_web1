<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3> DAY05 게시판 화면구현 </h3>
	<hr/>
	
	<div>
		<fieldset style="width: 350px; text-align: center;">
			<legend style="font-weight: bold" > 개별 게시물 목록 </legend>
			<table>
				<tr>
					<th style="width: 150px"> 제목 </th> 
					<td> <input style="width: 200px" type="text" placeholder="제목" maxlength="30" class="btitleInput" /> </td> 
				</tr>
				
				<tr>
					<th> 내용 </th> 
					<td> <textarea style="width: 200px; height: 100px;" placeholder="내용" class="bcontentInput" ></textarea> </td> 
				</tr>
				
				<tr>
					<th style="width: 150px"> 작성자 </th> 
					<td> <input style="width: 200px" type="text" placeholder="작성자" maxlength="30" class="bwriterInput" /> </td> 
				</tr>
				
				<tr>
					<th style="width: 150px"> 비밀번호 </th> 
					<td> <input style="width: 200px" type="password" placeholder="4~30자리로 입력해주세요." maxlength="30" class="bpwdInput" /> </td> 
				</tr>
			</table>
			<button onclick="boardUpdate()" type="button"> 수정 </button>
		</fieldset>
	</div>
	
	<script src="board.js"></script>
</body>
</html>