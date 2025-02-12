package web.controller.chatting;


import java.util.List;
import java.util.Vector;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

//	서블릿 클래스가 아닌 웹소켓 클래스로 사용할 예정
//	- @WebServlet HTTP vs - @ServerEndpoint WS

@ServerEndpoint("/chatsocket")
public class ServerSoket {

//	[*] 접속된 세션(접속성공한 클라리언트 소켓정보), list 컬렉션으로 여러개 Session을 저장하기
//	* 세션이란? 네트워크상의 정보를 저장하는 공간, HTTP 세션 vs WS 세션
//	* static이란? 프로젝트 내 하나의 변수를 만들 떄 사용되는 키워드, [전역변수]
	private static List< Session > 접속명단 = new Vector<>();
	
//	[1] 클라이언트 소켓이 서버소켓에 접속을 했을 때, onOpen
	@OnOpen
	public void onOpen( Session session ) {
//		Session : [import] jakarta.websocket.Session
		System.out.println("클라이언트가 서버에 접속 성공");
		System.out.println( session );
//		* onOpen( 클라이언트가 정상적으로 서버와 접속 성공했을때 )
		접속명단.add( session ); // list 컬렉션에 접속 성공한 session 정보를 저장한다.
		System.out.println( 접속명단 );
	} // f end
	
//	[2] 클라이언트 소켓이 서버소켓으로부터 메세지를 보냈을 때, onMessage
	@OnMessage
	public void onMessage( Session session, String message ) {
		System.out.println("클라이언트 소켓으로부터 메시지 왔다.");
		System.out.println( message );
		
//		* 서버가 클라이언트에게 메시지 전송
//		try {
//			session.getBasicRemote().sendText("클라이언트 소켓 안녕!");
//		}catch( Exception e ) { System.out.println(e); }
		
//		(1) 받은 메시지를 모든 접속된 세션(클라이언트 소켓)들에게 메시지 보내기
//			1. 받은 메시지 = 매개변수의 message
//			2. 접속 명단 : private static List< Session > 접속명단 = new Vector<>();
//			3. 반복문 이용한 접속 명단 순회
		for( int i = 0 ; i < 접속명단.size() ; i++ ) {
//			4.접속된 명단의 index번째 세션(접속정보) 가져오기 
			Session clientSocket = 접속명단.get(i);
//			5. index번째 세션에 (서버가 받은) 메시지를 보내기
			try { clientSocket.getBasicRemote().sendText(message);
			}catch( Exception e ) { System.out.println(e); }
		} // for end
		
	} // f end
	
//	[3] 클라이언트 소켓과 연결이 닫혔을 때( 클라이언트소켓(객체)의 포한됨 JS가 새로고침(객체가 지워졌을때) ) 실행되는 함수
	@OnClose
	public void onClose( Session session ) {
//		클라이언트 소켓과 연결이 닫혔을 때 명단에서 제외
		접속명단.remove( session ); // 접속이 닫힌 클라이언트 소켓을 리스트에서 제외
	} // f end
	
	
	
}
