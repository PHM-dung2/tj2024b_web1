package web.controller.member;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.model.dao.MemberDao;
import web.model.dto.PointDto;

@SuppressWarnings("serial")
@WebServlet("/web/point")
public class PointController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" /point get ok ");
		
//		[1] '포인트 로그 내역 전체 조회'와 '현재 남은 포인트 조회'를 쿼리스트링 이용하여 서비스 구분
//			type : 조회서비스 방법 식별 , all : '포인트 로그 내역 전체 조회' , 2 : current : '현재 남은 포인트 조회'
//			'포인트 로그 내역 전체 조회' : 192.168.40.64:8080/tj2024b_web1/web/point?type=all
//			'포인트 로그 현재 남은 포인트 조회' : 192.168.40.64:8080/tj2024b_web1/web/point?type=current
//		[1] 서비스 타입 정보를 쿼리스트링으로 가져오기
		String type = req.getParameter("type");
//		[2] 타입 정보에 따라 구분
		int logInMno = 0;
		HttpSession session = req.getSession();
		Object object = session.getAttribute("logInMno");
		if( object != null ) { logInMno = (Integer)object; }
		System.out.println( logInMno );
		
		ObjectMapper mapper = new ObjectMapper();
		if( type != null ) {
			if( type.equals("all") ) {
				// 전체 조회 dao 호출
				ArrayList<PointDto> result = MemberDao.getInstance().pointFindAll(logInMno);
				String jsonResult = mapper.writeValueAsString(result);
				resp.setContentType("application/json");
				resp.getWriter().print(jsonResult);
			}else if( type.equals("current") ) {
				// 남은 포인트 조회 dao 호출
				int result = MemberDao.getInstance().currentPoint(logInMno);
				System.out.println( result );
				resp.setContentType("text/plain");
				resp.getWriter().print(result);
			} // if end
		} // if end
		
		
	} // f end
	
}
