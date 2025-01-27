package day06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ParkingInoutDao {
	private Connection conn;
	
//	싱글톤
	private ParkingInoutDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/parkingservice" , "root" , "1234" );
		}catch( Exception e ) { System.out.println(e); }
	}
	private static ParkingInoutDao instance = new ParkingInoutDao();
	public static ParkingInoutDao getInstance() { return instance; }
	
	// 입출차 모든 내역 조회 
	public ArrayList<ParkingPrintDto> getParkingInoutAllList() {
		ArrayList<ParkingPrintDto> result = new ArrayList<>();
		try {
			String sql = "select * from inout_log";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				ParkingPrintDto parkingDto = new ParkingPrintDto();				
				parkingDto.setCar(rs.getString("car"));
				parkingDto.setState(rs.getInt("state"));
				parkingDto.setTime(rs.getString("time"));
				parkingDto.setPrice(rs.getInt("price"));
				result.add(parkingDto);
			} // w end
		}catch( SQLException e ) { System.out.println(e); }
		return result;
	} // f end
	
	// 입출차 구분 내역 조회 
	public ArrayList<ParkingPrintDto> getParkingInoutList(int state) {
		ArrayList<ParkingPrintDto> result = new ArrayList<>();
		try {
			String sql = "select * from inout_log where state=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, state);
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				ParkingPrintDto parkingDto = new ParkingPrintDto();				
				parkingDto.setCar(rs.getString("car"));
				parkingDto.setState(rs.getInt("state"));
				parkingDto.setTime(rs.getString("time"));
				parkingDto.setPrice(rs.getInt("price"));
				result.add(parkingDto);
			} // w end
		}catch( SQLException e ) { System.out.println(e); }
		return result;
	} // f end
	
}
