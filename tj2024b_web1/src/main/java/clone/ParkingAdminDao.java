package clone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ParkingAdminDao {
	private Connection conn;
	private ParkingAdminDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb0123", "root", "1234");
		}catch(Exception e) {System.out.println(e);}
	}
	private static ParkingAdminDao instance = new ParkingAdminDao();
	public static ParkingAdminDao getInstance() {
		return instance;
	}
	
	public ArrayList<ParkingDto> findAll(){
	ArrayList<ParkingDto> list = new ArrayList<ParkingDto>();
	try {
		String sql = "select * from parking";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			ParkingDto parkingDto = new ParkingDto();
			parkingDto.setCno(rs.getInt("cno"));
			parkingDto.setCarNum(rs.getString("carNum"));
			parkingDto.setCarLo(rs.getInt("carLo"));
			parkingDto.setInCar(rs.getString("inCar"));
			parkingDto.setOutCar(rs.getString("outCar"));
			parkingDto.setState(rs.getBoolean("state"));
			list.add(parkingDto);
		}
	}catch(Exception e) {System.out.println(e);}
	return list;
	
	}

	public boolean delete(int cno) {
		try {
			String sql = "delete from parking where cno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cno);
			int count  = ps.executeUpdate();
			if(count == 1)return true;
		}catch(Exception e) {System.out.println(e);}
		return false;
	}
}