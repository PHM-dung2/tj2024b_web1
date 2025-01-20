package day03.task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WaitingDao {
	
	private Connection conn;
	
	private WaitingDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/waitingDB" , "root" , "1234");
			
		}catch( Exception e ) { System.out.println( e ); }
	}
	private static WaitingDao instance = new WaitingDao();
	public static WaitingDao getInstance() { return instance; }
	
//	1. 대기번호 등록
	public boolean write( WaitingDto waitingDto ) {
		try {
			String sql = "insert into waiting(phone,count) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, waitingDto.getPhone());
				ps.setInt(2, waitingDto.getCount());
			int count1 = ps.executeUpdate();
			if( count1 == 1 ) { return true; }
		}catch( SQLException e ) { System.err.println( e ); }
		return false;
	} // f end
	
	
//	4. 대기번호 삭제
	public boolean delete( int wno ) {
		try {
			String sql = "delete from waiting where wno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, wno);
			int count1 = ps.executeUpdate();
			if( count1 == 1 ) { return true; }
		}catch( SQLException e ) { System.err.println( e ); }
		return false;
	} // f end

}
