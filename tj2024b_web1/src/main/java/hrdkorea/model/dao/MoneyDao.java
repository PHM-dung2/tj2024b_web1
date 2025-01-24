package hrdkorea.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hrdkorea.model.dto.MoneyDto;

public class MoneyDao extends Dao{
//	싱글톤	
	private MoneyDao() {}
	private static MoneyDao instance = new MoneyDao();
	public static MoneyDao getinstance() { return instance; }
	
//	2. 회원 조회
	public ArrayList<MoneyDto> moneyFindAll(){
		ArrayList<MoneyDto> result = new ArrayList<>();
		try {
			String sql = "select * from MONEY_TBL_02";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				MoneyDto moneyDto = new MoneyDto();
				moneyDto.setCustno(rs.getInt("custno"));
				moneyDto.setSalenol(rs.getInt("salenol"));
				moneyDto.setPcost(rs.getInt("pcost"));
				moneyDto.setAmount(rs.getInt("amount"));
				moneyDto.setPrice(rs.getInt("price"));
				moneyDto.setPcode(rs.getString("pcode"));
				moneyDto.setSdate(rs.getString("sdate"));
				result.add(moneyDto);
;			} // w end
		}catch( SQLException e ) { System.out.println(e); }
		return result;
	} // f end
	
}
