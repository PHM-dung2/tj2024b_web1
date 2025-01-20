package day03.task2;

import java.io.IOException;
import java.lang.runtime.ObjectMethods;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/waiting")
public class WaitingController extends HttpServlet {
	
//	1. 대기번호 등록
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		WaitingDto waitingDto =  mapper.readValue( req.getReader() , WaitingDto.class );		
		System.out.println( waitingDto );
				
		boolean result = WaitingDao.getInstance().write( waitingDto );
	} // f end
	
//	2. 대기번호 삭제
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int wno = Integer.parseInt(req.getParameter("wno"));
		
		boolean result = WaitingDao.getInstance().delete( wno );
	} // f end
	
}
