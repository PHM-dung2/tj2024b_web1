package web.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.Getter;
import lombok.NoArgsConstructor;
import web.model.dto.MemberDto;

//	@Getter // 클래스 내 모든 멤버변수에  getter 적용
@NoArgsConstructor( access = lombok.AccessLevel.PRIVATE ) // 클래스 내 디폴트생성자를 private 적용
public class MemberDao extends Dao{

//	+ 싱글톤
//		[1] 멤버변수에 static 인스턴스를 만든다.
//		[2] 디폴트 생성자를 private 한다.
	@Getter // 지정한 멤버변수에 getter 적용
	private static MemberDao instance = new MemberDao();
//	private MemberDao() {}
	
//	[1] 회원가입 등록
	public boolean signUp( MemberDto memberDto ) {
		try {
//			[1] SQL 작성한다
			String sql = "insert into member( mid , mpwd , mname , mphone , mimg )	"
					+ "values( ? , ? , ? , ? , ? )";
//			[2] DB와 연동된 곳에 SQL 기재한다.	
			PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, memberDto.getMid());
				ps.setString(2, memberDto.getMpwd());
				ps.setString(3, memberDto.getMname());
				ps.setString(4, memberDto.getMphone());
				ps.setString(5, memberDto.getMimg());
//			[3] 기재된 SQL실행하고 결과를 받는다. 
			int count = ps.executeUpdate();
//			[4] 결과에 따른 처리 및 반환을 한다.
			if( count == 1 ) { return true; }
		}catch( SQLException e ) { System.out.println( e ); }
		return false;
	} // f end
	
//	[2] 로그인
	public int logIn( MemberDto memberDto ) {
//		int : SQL로 조회된 회원번호를 반환하기 위해서
		try {
			String sql = "select mno from member where mid = ? and mpwd = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, memberDto.getMid());
				ps.setString(2, memberDto.getMpwd());
			ResultSet rs = ps.executeQuery();
			if( rs.next() ) {
				int mno = rs.getInt("mno");
				return mno; 
			} // if end
		}catch( SQLException e ) { System.out.println( e ); }
		return 0;
	} // f end
	
//	[3] 내(로그인된) 정보 조회
	public MemberDto myInfo( int logInMno ) {
		try {
			String sql = "select * from member where mno = ?";
			PreparedStatement ps = 	conn.prepareStatement(sql);
				ps.setInt(1, logInMno);
			ResultSet rs = ps.executeQuery();
			if( rs.next() ) {
				MemberDto result = new MemberDto();
				result.setMno( rs.getInt("mno") );
				result.setMid( rs.getString("mid") );
				result.setMname( rs.getString("mname") );
				result.setMphone( rs.getString("mphone") );
				result.setMdate( rs.getString("mdate") );
				result.setMimg( rs.getString("mimg"));
				return result;
			}
		}catch( SQLException e ) { System.out.println( e ); }
		return null; // 조회된 정보가 없을때, null 반환
	} // f end
	
//	[4] 회원탈퇴 SQL 처리 메소드
	public boolean delete( int logInMno ) {
		try {
			String sql = "delete from member where mno = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1 , logInMno);
			int count = ps.executeUpdate();
			if( count == 1 ) { return true; }
		}catch( SQLException e ) { System.out.println( e ); }
		return false;
	} // f end
	
	
//	[5] 회원수정
	public boolean update( MemberDto memberDto ) {
		try {
			String sql = "update member set mpwd = ? , mname = ? , mphone = ? where mno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1 , memberDto.getMpwd());
				ps.setString(2 , memberDto.getMname());
				ps.setString(3 , memberDto.getMphone());
				ps.setInt(4 , memberDto.getMno());
			int count = ps.executeUpdate();
			if( count == 1 ) { return true; }
		}catch(SQLException e) { System.out.println( e ); }
		return false;
	} // f end
	
	
}
