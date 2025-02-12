package web.controller.chatting;

import java.util.List;
import java.util.Vector;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/alarmsocket")
public class AlarmSocket {
	
	private static List< Session > arr = new Vector<>();
	
//	[1] 소켓 접속
	@OnOpen
	public void onOpen( Session session ) {
		System.out.println("클라이언트가 서버에 접속 성공");
		System.out.println( session );
		
		arr.add( session );
		System.out.println(arr);
	} // f end
	
//	[2] 메시지 전송
	@OnMessage
	public void onMessage( Session session, String message ) {
		System.out.println("메시지 전송하기");
		
		for( int i = 0 ; i < arr.size() ; i++ ) {
			Session Socket = arr.get(i);
			try { Socket.getBasicRemote().sendText(message);		
			}catch( Exception e ) { System.out.println(e); }
		} // for end
	} // f end
	
//	[3] 연결 종료
	@OnClose
	public void onClose( Session session ) {
		arr.remove( session );
	} // f end
	
	
}
