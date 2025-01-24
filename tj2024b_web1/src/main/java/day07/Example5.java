package day07;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day07/example5")
public class Example5 extends HttpServlet {
       
//	-- 요청 JSON객체들을 여러개 저장하기 위해서 :  ArrayList();
//	-- JSON객체가 아닌 DTO 혹은 HashMap를 리스트에 저장 : ArrayList<DTO> vs ArrayList<HashMap<String, String>>
//		--> DTO 사용하지 않는 상황 : 일회성 이동객체 ,
	private ArrayList<HashMap<String, String>> list = new ArrayList<>();
       
   	@Override
   	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   		System.out.println("/day07/example5 POST OK ");
//   	1. http 요청에 따른 JSON  타입을 DTO 변환한다.
   		ObjectMapper mapper = new ObjectMapper();
   		HashMap<String, String> map = mapper.readValue( req.getReader() , HashMap.class );
   		System.out.println( map );
//   	2. DB처리
   		list.add(map);
//   	3. http 응답처리
   		resp.setContentType("application/json");
   		resp.getWriter().print( true );
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println("/day07/example5 GET OK ");
//	   	1. 요청 매개변수가 없다
//	   	2. DB처리
//	   	3. HTTP응답처리
   		ObjectMapper mapper = new ObjectMapper();
   		String josnResult = mapper.writeValueAsString(list); // List Map를 JSON 문자열 변환
   		resp.setContentType("application/json");
   		resp.getWriter().print(josnResult);
    }
       
} // c end

