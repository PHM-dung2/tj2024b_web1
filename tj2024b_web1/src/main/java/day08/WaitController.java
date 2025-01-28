package day08;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/day08/wait")
public class WaitController extends HttpServlet{
	
	private ArrayList<HashMap<String, String>> list = new ArrayList<>();
	int count = 1;
	boolean result = false;
	
//	1. 대기명단 등록
//	{ "phone" : "010-1111-1111", "count" : "2" }
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> WaitController에 대기명단등록(POST)으로 통신 요청");
		ObjectMapper mapper = new ObjectMapper();
		@SuppressWarnings("unchecked")
		HashMap<String, String> map = mapper.readValue( req.getReader() , HashMap.class );
		if( !map.isEmpty() ) { 
//			대기번호 추가
			map.put("wno", count+"");
			System.out.println(map);
//			대기명단 등록
			list.add(map);	result = true;	count++;
		} // if end
		
//		세션에 dto 저장
		HttpSession session = req.getSession();
		session.setAttribute("dto", list);
//		http body에 출력
		resp.setContentType("application/json");
		resp.getWriter().print(result);
//		return 초기화
		result = false;
	} // f end
	
//	2. 대기명단 전체 출력
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> WaitController에 대기명단 전체 출력(GET)으로 통신 요청");
//		session 불러오기
		HttpSession session = req.getSession();
//		dto로 변환
		ObjectMapper mapper = new ObjectMapper();
		Object object = session.getAttribute("dto");
		String jsonResult = mapper.writeValueAsString(object);
//		http body에 출력
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
	} // f end
	
//	3. 특정 대기명단 삭제
	@SuppressWarnings("unchecked")
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> WaitController에 대기명단 삭제(DELETE)으로 통신 요청");
//		파라미터 가져오기
		String wno = req.getParameter("wno");
		String phone = req.getParameter("phone");
//		session 불러오기
		HttpSession session = req.getSession();
		Object object = session.getAttribute("dto");
		list = (ArrayList<HashMap<String, String>>)object;
//		대기명단 제거
		if( wno != null && phone != null ) {
			list.forEach( map -> {
				if( map.containsValue(wno) && map.containsValue(phone) ) {
					list.remove(map);	result = true;
					session.setAttribute("dto", list);
				} // if end
			}); // for end
		} // if end
//		http body 출력
		resp.setContentType("application/json");
		resp.getWriter().print(result);
//		return 초기화
		result = false;
	} // f end
	
//	4. 특정 대기명단 (인원수) 수정
//	{ "wno" : "1" , "phone" : "010-1111-1111" , "count" : "14" }
	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> WaitController에 대기명단 인원수 수정(PUT)으로 통신 요청");
//		http body json => dto 변환
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = mapper.readValue( req.getReader() , HashMap.class );
		String wno = map.get("wno");	
		String phone = map.get("phone");
		String count = map.get("count");
//		session에서 list 가져오기
		HttpSession session = req.getSession();
		Object object = session.getAttribute("dto");
		list = (ArrayList<HashMap<String,String>>)object;
//		대기명단 인원수 수정
		if( !map.isEmpty() ) {
			list.forEach( value -> {
				if( value.containsValue(wno) && value.containsValue(phone) ) {
					value.put("count", count );	result = true;
				} // if end
			}); // for end
		} // if end
//		http body 출력
		resp.setContentType("application/json");
		resp.getWriter().print(result);
//		return 초기화
		result = false;
	} // f end
	
	
}
