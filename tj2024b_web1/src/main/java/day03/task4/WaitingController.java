package day03.task4;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/waiting2")
public class WaitingController extends HttpServlet {
	
//	1. 대기번호 등록
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		WaitingDto waitingDto =  mapper.readValue( req.getReader() , WaitingDto.class );		
				
		boolean result = WaitingDao.getInstance().write( waitingDto );
		resp.setContentType( "application/json" );
		resp.getWriter().print(result);
	} // f end
	
//	2. 대기번호 전체 조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<WaitingDto> result = WaitingDao.getInstance().findAll();
			
			ObjectMapper mapper = new ObjectMapper();
			String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType( "application/json" );
		resp.getWriter().print( jsonResult );
	} // f end
	
//	3. 대기번호 수정
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		WaitingDto waitingDto = mapper.readValue( req.getReader() , WaitingDto.class );
		boolean result = WaitingDao.getInstance().update( waitingDto );  
		resp.setContentType( "application/json" );
		resp.getWriter().print( result );
	} // f end
	
	
//	4. 대기번호 삭제
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("num"));
		
		boolean result = WaitingDao.getInstance().delete( num );
		resp.setContentType( "application/json" );
		resp.getWriter().print(result);
	} // f end
	
}
