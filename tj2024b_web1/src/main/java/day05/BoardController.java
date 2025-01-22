package day05;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day05/board2")
public class BoardController extends HttpServlet{
	
//	1. 게시물 등록
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		BoardDto boardDto = mapper.readValue( req.getReader() , BoardDto.class );
		
		boolean result = BoardDao.getInstance().boardWrite(boardDto);
		resp.setContentType( "application/json" );
		resp.getWriter().print(result);
	} // f end
	
//	2. 게시물 전체 조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<BoardDto> result = BoardDao.getInstance().boardFindAll();
			ObjectMapper mapper = new ObjectMapper();
			String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType( "application/json" );
		resp.getWriter().print( jsonResult );
	} // f end
	
//	3. 게시물 수정
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		BoardDto boardDto = mapper.readValue( req.getReader() , BoardDto.class );
		boolean result = BoardDao.getInstance().boardUpdate( boardDto );
		resp.setContentType( "application/json" );
		resp.getWriter().print(result);
	} // f end
	
//	4. 게시물 삭제
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bno = Integer.parseInt( req.getParameter("bno") );
		boolean result = BoardDao.getInstance().boardDelete(bno);
		resp.setContentType( "application/json" );
		resp.getWriter().print(result);
	} // f end
	
}
