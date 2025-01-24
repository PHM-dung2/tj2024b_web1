package day06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ParkingDao {
	private Connection conn;
	
//	싱글톤
	private ParkingDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/parkingservice" , "root" , "1234" );
		}catch( Exception e ) { System.out.println(e); }
	}
	private static ParkingDao instance = new ParkingDao();
	public static ParkingDao getInstance() { return instance; }
	
//	주차자리 화면 구현
	public ArrayList<ParkingDto> parkingView() {
		ArrayList<ParkingDto> result = new ArrayList<>();
		try {
			String sql = "select * from parking";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				ParkingDto parkingDto = new ParkingDto();
				parkingDto.setPno(rs.getInt("pno"));
				parkingDto.setCar(rs.getString("car"));
				parkingDto.setTime(rs.getString("time"));
				result.add(parkingDto);
			} // w end
		}catch( SQLException e ) { System.out.println(e); }
		return result;
	} // f end
	
}
