package day03.task4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
//	2. 대기번호 전체 조회
	public ArrayList<WaitingDto> findAll(){
		ArrayList<WaitingDto> result = new ArrayList<>();
		try {
			String sql = "select * from waiting";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				WaitingDto waitingDto = new WaitingDto();
				waitingDto.setNum(rs.getInt("num"));
				waitingDto.setPhone(rs.getString("phone"));
				waitingDto.setCount(rs.getInt("count"));
				result.add(waitingDto);
			} // w end
		}catch( SQLException e ) { System.out.println(e);}
		return result;
	} // f end
	
//	3. 대기번호 수정
	public boolean update( WaitingDto waitingDto ) {
		try{
			String sql = "update waiting set phone = ? , count = ? "
					+ "where num = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, waitingDto.getPhone());
				ps.setInt(2, waitingDto.getCount());
				ps.setInt(3, waitingDto.getNum());
			int count = ps.executeUpdate();
			if( count == 1 ) { return true; }
		}catch( SQLException e ) { System.out.println(e); }
		return false;
	} // f end
	
//	4. 대기번호 삭제
	public boolean delete( int num ) {
		try {
			String sql = "delete from waiting where num = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, num);
			int count1 = ps.executeUpdate();
			if( count1 == 1 ) { return true; }
		}catch( SQLException e ) { System.err.println( e ); }
		return false;
	} // f end

}
