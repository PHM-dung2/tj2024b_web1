package day08;

import java.io.IOException;
import java.net.Inet4Address;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidNullException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/day08/waiting")
public class WaitingController extends HttpServlet{
	
	private ArrayList<HashMap<String, String>> list = new ArrayList<>();
	int count = 1;
	boolean result = false;
	
//	1. 대기명단 등록
//	{ "phone" : "010-1111-1111", "count" : 2 }
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		1. http 요청에 따른 JSON 타입을 DTO 변환
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String , String> map = mapper.readValue( req.getReader() , HashMap.class );
		map.put("wno", count+"");
		System.out.println( map );
//		2. DB처리
		if( map != null ) { 
			result = true;	list.add(map); 
			count++; 
		}
//		3. http 응답처리
		resp.setContentType("application/json");
		resp.getWriter().print( result );
	} // f end
	
//	2. 대기명단 전체 출력
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(list);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
	}
	
//	3. 특정 대기명단 삭제
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int wno = Integer.parseInt( req.getParameter("wno") );
		String phone = req.getParameter("phone");
		System.out.println(wno);
		System.out.println(phone);
//		번호가 일치하는 index 삭제
		list.forEach( map -> {
			if( map.containsValue(wno) && map.containsValue(phone) ) {
				list.remove(map);
				result = true;
			}
		}); // for end
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	
//	4. 특정 대기명단 (인원수) 수정
//	{ "wno" : 1 , "phone" : "010-1111-1111" }
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = mapper.readValue( req.getReader() , HashMap.class );
		System.out.println(map);
//		인원수 수정
		list.forEach( value -> {
			if( value.get("wno") != null && value.containsValue(map.get("wno"))) {
				value.put("count", map.get("count"));
				result = true;
			} // if end
		});
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	} // f end
	
}
