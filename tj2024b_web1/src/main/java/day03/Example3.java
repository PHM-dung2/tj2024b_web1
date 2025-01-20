package day03;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/example3")
public class Example3 extends HttpServlet{
	
	@Override
//	HTTP POST BODY : http://localhost:8080/day03/example3
//	content type : application/json , body : { "data1" : 유재석 , "data2" : 40 }
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		* JSON자료의 문자열타입을 DTO로 변환해보기. ( JSON은 JS언어에서 사용하는 타입 , JAVA는 DTO 사용한다. )
		System.out.println( "[HTTP *POST 방식으로 요청이 왔습니다.]" );
		System.out.println( req.getReader().readLine().charAt(0) ); // 단순한 문자열 읽어왔다.
//		문자열 : { "data1" : 유재석 , "data2" : 40 } --> DTO 변환
//		JSON 모양의 문자열타입 자료를 DTO로 변환 라이브러리 : json 변환 라이브러리 필요하다.
		
		
	} // f end
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println( "[HTTP *PUT 방식으로 요청이 왔습니다.]" );
		System.out.println( req.getReader().readLine() );
	} // f end
	
}
