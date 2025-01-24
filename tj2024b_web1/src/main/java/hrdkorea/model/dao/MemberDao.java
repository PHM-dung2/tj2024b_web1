package hrdkorea.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hrdkorea.model.dto.MemberDto;

public class MemberDao extends Dao{
//	싱글톤
	private MemberDao() {}
	private static MemberDao instance = new MemberDao();
	public static MemberDao getinstance() { return instance; }
	
//	1. 회원 등록
	public boolean memberWrite( MemberDto memberDto ) {
		try {
			String sql = "insert into MEMBER_TBL_02 value( ? ,? , ? , ? , ? , ? , ? )";
			PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, memberDto.getCustno());
				ps.setString(2, memberDto.getCustname());
				ps.setString(3, memberDto.getPhone());
				ps.setString(4, memberDto.getAddress());
				ps.setString(5, memberDto.getJoindate());
				ps.setString(6, memberDto.getGrade());
				ps.setString(7, memberDto.getCity());
			int count = ps.executeUpdate();
			if( count == 1 ) { return true; }
		}catch( SQLException e ) { System.out.println(e); }
		return false;
	} // f end
	
//	2. 회원 조회
	public ArrayList<MemberDto> memberFindAll(){
		ArrayList<MemberDto> result = new ArrayList<>();
		try {
			String sql = "select * from MEMBER_TBL_02";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				MemberDto memberDto = new MemberDto();
				memberDto.setCustno(rs.getInt("custno"));
				memberDto.setCustname(rs.getString("custname"));
				memberDto.setPhone(rs.getString("phone"));
				memberDto.setAddress(rs.getString("address"));
				memberDto.setJoindate(rs.getString("joindate"));
				memberDto.setGrade(rs.getString("grade"));
				memberDto.setCity(rs.getString("city"));
				result.add(memberDto);
;			} // w end
		}catch( SQLException e ) { System.out.println(e); }
		return result;
	} // f end
	
//	3. 회원 수정
	public boolean memberUpdate( MemberDto memberDto ) {
		try {
			String sql = "update MEMBER_TBL_02 set custname=? , "
					+ "phone=? , address=? , joindate=? , grade=? , city=? "
					+ "where custno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, memberDto.getCustname());
				ps.setString(2, memberDto.getPhone());
				ps.setString(3, memberDto.getAddress());
				ps.setString(4, memberDto.getJoindate());
				ps.setString(5, memberDto.getGrade());
				ps.setString(6, memberDto.getCity());
				ps.setInt(7, memberDto.getCustno());
			int count = ps.executeUpdate();
			if( count == 1 ) { return true; }
		}catch( SQLException e ) { System.out.println(e); }
		return false;
	} // f end
	
//	4. 회원 삭제
	public boolean memberDelete( int custno ) {
		try {
			String sql = "delete from MEMBER_TBL_02 where custno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, custno);
			int count = ps.executeUpdate();
			if( count == 1 ) { return true; }
		}catch( SQLException e ) { System.out.println(e); }
		return false;
	} // f end
	
}
