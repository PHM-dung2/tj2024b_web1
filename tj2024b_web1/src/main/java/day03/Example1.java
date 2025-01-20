package day03;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//	1단계 : 임의의 클래스의 extends HttpServlet
//	2단계 : (web.xml 자동처리) 선언된 클래스 위에 @WebServlet("/주소정의")
//	3단계 : HTTP METHOD 매핑 메소드들을 재정의(오버라이딩)

@WebServlet("/day03/example1")
public class Example1 extends HttpServlet{

//	1. doPost
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[HTTP *POST 방식으로 요청이 왔습니다]");
		String data1 = req.getParameter( "data1" );							System.out.println("data1 : " + data1 );
		int data2 = Integer.parseInt( req.getParameter( "data2" ) );		System.out.println("data2 : " + data2 );
	} // f end
	
//	2. doget
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[HTTP *GET 방식으로 요청이 왔습니다]");
		String data1 = req.getParameter( "data1" );							System.out.println("data1 : " + data1 );
		int data2 = Integer.parseInt( req.getParameter( "data2" ) );		System.out.println("data2 : " + data2 );
	} // f end
	
//	3. doput
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[HTTP *PUT 방식으로 요청이 왔습니다]");
		String data1 = req.getParameter( "data1" );							System.out.println("data1 : " + data1 );
		int data2 = Integer.parseInt( req.getParameter( "data2" ) );		System.out.println("data2 : " + data2 );
	} // f end
	
//	4. dodelete
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[HTTP *DELETE 방식으로 요청이 왔습니다]");
		String data1 = req.getParameter( "data1" );							System.out.println("data1 : " + data1 );
		int data2 = Integer.parseInt( req.getParameter( "data2" ) );		System.out.println("data2 : " + data2 );
	} // f end
	
}
