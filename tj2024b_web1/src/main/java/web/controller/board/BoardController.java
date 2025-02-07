package web.controller.board;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.model.dao.BoardDao;
import web.model.dto.BoardDto;

@WebServlet("/board")
public class BoardController extends HttpServlet{

//	1. 게시물 작성
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> BOARD POST RUN");
		ObjectMapper mapper = new ObjectMapper();
		BoardDto boardDto = mapper.readValue( req.getReader() , BoardDto.class );
		
		HttpSession session = req.getSession();
		Object object = session.getAttribute("logInMno");
		int logInMno = 0;
		if( object != null ) { 
			logInMno = (Integer)object; 
			System.out.println(logInMno);
			boardDto.setMno(logInMno);
		} // if end
		
		boolean result = BoardDao.getInstance().write( boardDto );
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	} // f end
	
//	2. 전체 게시물 조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> BOARD GET RUN");
		// 요청 매개변수
		int cno = Integer.parseInt( req.getParameter("cno") );
		ArrayList<BoardDto> result = BoardDao.getInstance().findAll(cno);
			ObjectMapper mapper = new ObjectMapper();
			String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
	} // f end
	
//	3. 게시물 수정
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> BOARD PUT RUN");
		ObjectMapper mapper = new ObjectMapper();
		BoardDto boardDto = mapper.readValue( req.getReader() , BoardDto.class );
		boolean result = BoardDao.getInstance().update(boardDto);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	} // f end
	
//	4. 게시물 삭제
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> BOARD DELETE RUN");
		int bno = Integer.parseInt(req.getParameter("bno"));
		boolean result = BoardDao.getInstance().delete(bno);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	} // f end
	
}
