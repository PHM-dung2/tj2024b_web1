package web.controller.member;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.model.dao.MemberDao;
import web.model.dto.MemberDto;
import web.model.dto.PointDto;

@WebServlet("/member/login")
public class LogInController extends HttpServlet{
	
//	[ 로그인 ]
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		1. [HTTP 요청의 header body 자료(JSON)를 자바 (DTO)로 받는다.]
		ObjectMapper mapper = new ObjectMapper();
		MemberDto memberDto = mapper.readValue( req.getReader() , MemberDto.class );
//		2. [ 데이터 유효성검사 ]
//		3. [ DAO에게 데이터 전달하고 응답받기 ]
		int logInMno = MemberDao.getInstance().logIn(memberDto);
//			======= 만약에 로그인 성공했다면 세션 처리 =======
			if( logInMno > 0 ) {
//				세션 : 톰캣 서버의 저장소/메모리
				HttpSession session = req.getSession(); 
//				(1) 현재 로그인 성공한 회원번호를 세션 속성에 등록
//				(2) 추후에 로그인 인증에서 사용될 예정
//				(3) 세션의 확성화 유지 시간 설정
				session.setAttribute( "logInMno", logInMno );
				session.setMaxInactiveInterval(60*10); // 초 : 60초 * 10 -> 10분
//				하루에 한번 포인트 지급
				HttpSession point = req.getSession();
				if( point.getAttribute( logInMno+"" ) == null ) {
					point.setAttribute( logInMno+"" , 1 );
					point.setMaxInactiveInterval(60*60*24); // 하루동안
					
					PointDto pointDto = new PointDto();
					pointDto.setPcontent("로그인");
					pointDto.setPcount( 1 );
					pointDto.setMno(logInMno);
					MemberDao.getInstance().pointPost(pointDto);
				} // if end
				
			} // if end
//		4. [ 자료(DTO/자바)타입을 JS(JSON)타입으로 변환한다.
//		5. [ HTTP 응답에 header body로 application/json으로 응답/반환하기 ]
		resp.setContentType("application/json");
		resp.getWriter().print(logInMno);
		
	} // f end
	
//	[ 로그아웃 ]
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		1. [HTTP 요청의 header body 자료(JSON)를 자바 (DTO)로 받는다.]
//		2. [ 데이터 유효성검사 ]
//		3. [ DAO에게 데이터 전달하고 응답받기 ]
		HttpSession session = req.getSession(); // - (1) 세션 객체 불러오기
		Object object = session.getAttribute("logInMno"); // - (2) 세션의 속성 값을 불러오기
		boolean logOut = false;
		if( object != null ) { // - (3) 속성값이 존재하면 속성값 제거한다 -> 로그아웃
			session.removeAttribute("logInMno");
			logOut = true;
		}
//		4. [ 자료(DTO/자바)타입을 JS(JSON)타입으로 변환한다.
//		5. [ HTTP 응답에 header body로 application/json으로 응답/반환하기 ]
		resp.setContentType("application/json");
		resp.getWriter().print(logOut);
	} // f end
	
}
