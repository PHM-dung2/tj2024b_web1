package day02.task2;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day02/waiting")
public class WaitingController extends HttpServlet {
	
//	1. 대기번호 등록
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String phone = req.getParameter("phone");
		int count = Integer.parseInt(req.getParameter("count")); 
		
		boolean result = WaitingDao.getInstance().write( phone , count );
	} // f end
	
//	2. 대기번호 삭제
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int wno = Integer.parseInt(req.getParameter("wno"));
		
		boolean result = WaitingDao.getInstance().delete( wno );
	} // f end
	
}
