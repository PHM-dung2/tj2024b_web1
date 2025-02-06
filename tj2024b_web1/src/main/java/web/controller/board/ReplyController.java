package web.controller.board;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.model.dao.BoardDao;
import web.model.dto.ReplyDto;

@WebServlet("/reply")
public class ReplyController extends HttpServlet{
	
//	1. 댓글 쓰기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> REPLY POST RUN");
		ObjectMapper mapper = new ObjectMapper();
		ReplyDto replyDto = mapper.readValue( req.getReader() , ReplyDto.class );
//		게시물 번호
		int bno = Integer.parseInt(req.getParameter("bno"));
		replyDto.setBno(bno);
//		회원번호
		HttpSession session = req.getSession();
		Object object = session.getAttribute("logInMno");
		int logInMno = 0;
		if( object != null ) { 
			logInMno = (Integer)object; 
			System.out.println(logInMno);
			replyDto.setMno(logInMno);
		} // if end
		
		boolean result = BoardDao.getInstance().replyWrite(replyDto);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	} // f end
	
}
