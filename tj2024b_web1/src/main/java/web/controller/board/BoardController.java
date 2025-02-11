package web.controller.board;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.jdt.internal.compiler.parser.ParserBasicInformation;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.model.dao.BoardDao;
import web.model.dto.BoardDto;
import web.model.dto.PageDto;

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
	
//	2. 전체 게시물 조회( 02/07 +추가 : 카테고리별 , 2/11 +추가 : 페이징 )
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> BOARD GET RUN");
		// 요청 매개변수
		int cno = Integer.parseInt( req.getParameter("cno") );
		int page = Integer.parseInt( req.getParameter("page") );
		
//			* 페이징 처리에 필요한 자료를 준비
//			1. 1페이지당 출력할 게시물 수
			int display = 5; // 페이지 1개당 게시물 5개 출력 예정
//			2. 페이지당 조회할 게시물의 시작 번호
			int startRow = (page-1) * display;
//				게시물이 10개 존재한다고 가정 : 0번 1번 2번 3번 4번 5번 6번 7번 8번 9번
//				1페이지에 시작번호 : 0번 , 2페이지 시작번호 : 4번
//			3. 특정 카테고리 게시물의 게시물의 전체 페이지 수 구하기
			int totalSize = BoardDao.getInstance().getTotalSize( cno );
//			4. 전체 페이지
			int totalPage = 0;
			if( totalSize % display == 0 ) {
				// 전체 게시물 수 나누기 페이지당 게시물 수 했을 떄 나머지가 없으면
				totalPage = totalSize / display;
			}else { totalPage = totalSize / display + 1; } // 몫 + 1
//			5. 페이지당 버튼 수
			int btnSize = 5;
//			6. 시작버튼 번호 구하기
			int startBtn = ( (page-1) / btnSize ) * btnSize+1;
//			7. 끝버튼 번호 구하기
			int endBtn = startBtn + ( btnSize - 1 );
//			* 만약에 끝번호가 전체 페이지수보다 커지면 안되므로 끝번호가 전체 페이지수보다 커지면 전체페이지수로 고정
			if( endBtn > totalPage ) { endBtn = totalPage; }
			
		ArrayList<BoardDto> result = BoardDao.getInstance().findAll(cno , startRow , display );
		
			// 8. PageDto 객체 만들기
			PageDto pageDto = new PageDto();
			pageDto.setTotalcount(totalSize); // 조회된 전체 게시물 수
			pageDto.setPage(page); // 현재 페이지
			pageDto.setTotalpage(totalPage); // 전체 페이지수
			pageDto.setStartbtn(startBtn); // 페이징 버튼 시작 번호
			pageDto.setEndbtn(endBtn); // 페이징 버튼 끝 번호
			pageDto.setData(result);
		
			ObjectMapper mapper = new ObjectMapper();
			String jsonResult = mapper.writeValueAsString(pageDto); // 9. pageDto를 json으로 변환
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
