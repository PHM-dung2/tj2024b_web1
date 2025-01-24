package hrdkorea.model.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import hrdkorea.model.dao.MemberDao;
import hrdkorea.model.dto.MemberDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hrdkorea/member")
public class MemberController extends HttpServlet{
	
//	1. 회원 등록
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		MemberDto memberDto = mapper.readValue( req.getReader() , MemberDto.class );
		boolean result = MemberDao.getinstance().memberWrite( memberDto );
		resp.setContentType( "application/json" );
		resp.getWriter().print( result );
	} // f end
	
//	2. 회원목록 조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<MemberDto> result = MemberDao.getinstance().memberFindAll();
			ObjectMapper mapper = new ObjectMapper();
			String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType( "application/json" );
		resp.getWriter().print( jsonResult );
	} // f end
	
//	3. 회원 수정
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		MemberDto memberDto = mapper.readValue( req.getReader() , MemberDto.class );
		boolean result = MemberDao.getinstance().memberUpdate(memberDto);
		resp.setContentType( "application/json" );
		resp.getWriter().print( result );
	} // f end
	
//	4. 회원 삭제
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int custno = Integer.parseInt( req.getParameter("custno") );
		boolean result = MemberDao.getinstance().memberDelete( custno );
		resp.setContentType( "application/json" );
		resp.getWriter().print( result );
	} // f end
}
