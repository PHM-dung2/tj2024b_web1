package day08;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day08/wait")
public class WaitController extends HttpServlet{
	
	private ArrayList<HashMap<String, String>> list = new ArrayList<>();
	
//	1. 대기명단 등록
//	{ "phone" : "010-1111-1111", "count" : 2 }
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

	} // f end
	
//	2. 대기명단 전체 출력
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	} // f end
	
//	3. 특정 대기명단 삭제
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	} // f end
	
//	4. 특정 대기명단 (인원수) 수정
//	{ "wno" : 1 , "phone" : "010-1111-1111" }
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	} // f end
	
	
}
