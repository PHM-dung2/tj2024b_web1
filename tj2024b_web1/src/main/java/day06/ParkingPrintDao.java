package day06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ParkingPrintDao {
	private Connection conn;
	
//	싱글톤
	private ParkingPrintDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/parkingservice" , "root" , "1234" );
		}catch( Exception e ) { System.out.println(e); }
	}
	private static ParkingPrintDao instance = new ParkingPrintDao();
	public static ParkingPrintDao getInstance() { return instance; }
	
//	주차자리 화면 구현
	public ArrayList<ParkingPrintDto> parkingView() {
		ArrayList<ParkingPrintDto> result = new ArrayList<>();
		try {
			String sql = "select * from parking";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				ParkingPrintDto parkingDto = new ParkingPrintDto();
				parkingDto.setPno(rs.getInt("pno"));
				parkingDto.setCar(rs.getString("car"));
				parkingDto.setTime(rs.getString("time"));
				result.add(parkingDto);
			} // w end
		}catch( SQLException e ) { System.out.println(e); }
		return result;
	} // f end
	
}
