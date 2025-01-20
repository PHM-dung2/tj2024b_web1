package day03.task3;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/visit2")
public class VisitController extends HttpServlet{

//	1. 방문록 등록			: POST 
//	매개변수 : BODY		 		, 매개변수 예) { "content" : "안녕" , "age" : "30" }
//	반환타입 : application/json	, 매개변수 예) true
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		1. HTTP로부터 요청(request)받은 HTTP HEADER BODY(본문)을 DTO 파싱(변환) 가져오기
		ObjectMapper mapper = new ObjectMapper();
		VisitDto visitDto = mapper.readValue( req.getReader() , VisitDto.class );
		
//		2. DAO 처리
		boolean result = VisitDao.getInstance().write(visitDto);
//		3. DAO 결과를 HTTP HEADER BODY(본문)으로 응답(response) 보내기
		resp.setContentType( "application/json" );	// (1) 응답할 자료의 타입 명
		resp.getWriter().print(result);				// (2) 응답 자료 보내기
		
	} // f end
		
//	2. 방문록 전체 조회		: GET		
//	매개변수 : X					
//	반환타입 : application/json 	, 매개변수 예) [ { "num" : 1 , "content" : "안녕1" , "age" = 30 } , { "num" : 2 , "content" : "안녕2" , "age" = 30 }
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		1. X
//		2. DAO처리
		ArrayList<VisitDto> result = VisitDao.getInstance().findAll();
//		3. DAO 결과를 HTTP HEADER BODY(본문) 응답(response) 보내기
//			자바객체(DTO) --> JSON 형식의 문자열 타입변환
			ObjectMapper mapper = new ObjectMapper();
			String jsonResult = mapper.writeValueAsString( result );
		resp.setContentType( "application/json" );
		resp.getWriter().print( jsonResult );
	} // f end
		
//	3. 방문록 수정			: PUT		
//	매개변수 : BODY				, 매개변수 예) { "num" : 3 , "content": "수정안녕" , "get" : 40 }
//	반환타입 : application/json	, 매개변수 예) true
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		VisitDto visitDto = mapper.readValue( req.getReader() , VisitDto.class );
		
		boolean result = VisitDao.getInstance().update(visitDto);
		resp.setContentType( "application/json" );
		resp.getWriter().print(result);
		
	} // f end
	
//	4. 방문록 삭제			: DELETE	
//	매개변수 : queryString 		, 매개변수 예) ?num=1
//	반환타입 : application/json	, 매개변수 예) true
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		1. HTTP로부터 요청(request) 받은 HTTP queryString의 매개변수 가져오기
		int num = Integer.parseInt( req.getParameter("num"));
//		2. DAO 처리
		boolean result = VisitDao.getInstance().delete(num);
		resp.setContentType( "application/json" );
		resp.getWriter().print( result );
	} //  f end
	
	
}
