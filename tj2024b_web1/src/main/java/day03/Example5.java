package day03;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/example5")
public class Example5 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean result = true;							// 1. 응답할 자료 준비
		resp.setContentType( "application/json" );		// 2. HTTP를 이용한 응답 해더 정보 추가 , content-type( )
		resp.getWriter().print( result );				// 3. HTTP를 이용한 요청에 따른 응답자료 보내기
	} // f end
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String result = "java";
		resp.setContentType( "text/plain" );	// 문자열 1개는 application/json으로 타입변환 불가능.	text/plain	
		// text/html도 되지만 스프링이 plain을 씀
		resp.getWriter().print( result );
	} // f end
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int result = 30;
		resp.setContentType( "application/json" );
		resp.getWriter().print( result );
	} // f end
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DataDto result = new DataDto("유재석", 40);
		
		// DTO --> JSON으로 변환
//		1. ObjectMapper 인스턴스 생성
		ObjectMapper mapper = new ObjectMapper();
//		2. .writeValueAsString( 변환할객체 ) : 지정한 객체를 JSON형식으로 반환 함수
		String jsonResult = mapper.writeValueAsString( result ); 
		
		resp.setContentType( "application/json" );	// 오류 : DTO를 JSON으로 타입변환 불가능
		resp.getWriter().print( jsonResult );
	}
	
}
