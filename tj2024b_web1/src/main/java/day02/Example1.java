package day02;

import java.io.IOException;

import jakarta.servlet.ServletException;

//	자바의 클래스를 서블릿 클래스로 만들기
//	1. 클래스명 extends httpServlet
//	2. 클래스 성언부 위에 @WebServlet("http 주소체계 정의 ") : 
//		주의할점 : 주소는 아무거나 하되 프로젝트내 중복 불가능
//		@WebServlet("http://localhost:8080/tj2024b_web1/day02/example1") 	: 절대경로
//		@WebServlet("(프로젝트명 이하 생략)/day02/example1") 						: 상대경로
//	3. 요청 받은 방법(함수==기능==메소드==행위) 정의
//		1. doGet , 2. doPsot , 3. doPut , 4. doDelete ===> 4종 구현 Rest(휴식)

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day02/example1")
public class Example1 extends HttpServlet{ 
//	이클립스는 코드가 변경/수정 자동으로 서버에 빌드 / 배포 : 메뉴 -> 상단[project] -> build automatically
//		1. 서블릿 안에 코드 변경할 경우 자동으로 리로드된다. ctrl + f11 다시 안해도 된다.
//		2. [서버 재실행] 새로운 서블릿은 새로운 매핑 HTTP 주소가 서버에 등록(web.xml)
	
//	Restful 구축 : 1. POST 2. GET 3. PUT 4. DELETE
	
//	1. POST : dopost + 자동완성
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 System.out.println(" 1] HTTP 프로토콜 통신이 POST 방법으로 쵸엉이 왔습니다.");
	}
	
//	2. GET : doget + 자동완성
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" 2] HTTP 프로토콜 통신이 GET 방법으로 요청이 왔습니다. 코드수정");
	}
	
//	3. PUT : doput + 자동완성
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" 3] HTTP 프로토콜 통신이 PUT 방법으로 요청이 왔습니다.");
	}
	
//	4. DELETE : dodelete + 자동완성
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" 4] HTTP 프로토콜 통신이 DELETE 방법으로 요청이 왔습니다.");
	}
	
}