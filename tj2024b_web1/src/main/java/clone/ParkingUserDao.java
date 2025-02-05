package clone;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ParkingUserDao {
	private Connection conn;
	
	// 싱글톤
	private static ParkingUserDao instance = new ParkingUserDao();
	private ParkingUserDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb0123","root","1234");
		}catch(Exception e) {System.out.println(e);}
	}
	public static ParkingUserDao getInstance() {return instance;}

	
	// 입차
	public boolean inCar(ParkingDto parkingDto) {
		try {
			String sql = "insert into parking(carNum,carLo,outCar) values(?,?,null); ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, parkingDto.getCarNum());
			ps.setInt(2, parkingDto.getCarLo());
			int c = ps.executeUpdate();
			if(c == 1) {return true;}
		}catch(SQLException e) {System.out.println(e);}
		return false;
	}
	
	
	// 조회
	public ParkingDto printByid(int carNum) {
		try {
			String sql = "select * from parking where carNum = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, carNum);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ParkingDto parkingDto = new ParkingDto();
				parkingDto.setCno(rs.getInt("cno"));
				parkingDto.setCarNum(rs.getString("carNum"));
				parkingDto.setCarLo(rs.getInt("carLo"));
				parkingDto.setInCar(rs.getString("inCar"));
				parkingDto.setOutCar(rs.getString("outCar"));
				return parkingDto;
			}
		}catch(SQLException e) {System.out.println(e);}
		return null;
	}
	
	// 조회 / 출차시간 표시
	public boolean serchCar(ParkingDto parkingDto) {
		try {
			 LocalDateTime now = LocalDateTime.now();
		     Timestamp timestamp = Timestamp.valueOf(now);
			String sql = "update parking set outCar = ? where carNum = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, timestamp);
			ps.setString(2, parkingDto.getCarNum());
			int c = ps.executeUpdate();
			if(c == 1) {return true;}
		}catch(SQLException e) {System.out.println(e);}
		return false;
	}
	
	
	
	// 결제/출차
	public boolean outCar(String carNum) {
		try {
			String sql = "update parking set state = false where carNum = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, carNum);
			int c = ps.executeUpdate();
			if(c == 1) {return true;}
		}catch(SQLException e) {System.out.println(e);}
		return false;
	}
	
	
	
}



