<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3> DAY03 TASK2 화면구현 </h3>
	<hr/>
	
	<div>
		<fieldset style="width: 270px; text-align:center;">
			<legend> <h3> 대기 명단 등록 </h3> </legend>
			<table>
				<tr>
					<th> 전화번호 </th> 
					<th> <input type="tel" placeholder="010-0000-0000" class="phoneInput" /> </th> 
				</tr>
				
				<tr>
					<th> 인원수 </th> 
					<th> <input class="phoneInput" /> </th> 
				</tr>
			</table>
			<button onclick="waitWrite" type="button"> 등록 </button>
		</fieldset>
	</div>
	
	<div> 
		<fieldset style="width: 270px; text-align:center;">
			<legend> <h3> 대기 명단 </h3> </legend>
			<table border="1">
				<thead>
					<tr>
						<th> 번호 </th>
						<th> 인원수 </th>
						<th> 전화번호 </th>
						<th> 비고 </th>
					</tr>
				</thead>
				<tbody>
				
				</tbody>
			</table>
		</fieldset>
	</div>
	

	<script src="task2.js"></script>
</body>
</html>