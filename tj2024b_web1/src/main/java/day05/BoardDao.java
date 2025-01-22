package day05;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDao{

	private Connection conn;
	
	private BoardDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/boardservice11" , "root" , "1234");
		}catch( Exception e ) { System.out.println(e); }
	}
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() { return instance;	}
	
//	1. 게시물 등록
	public boolean boardWrite( BoardDto boardDto ) {
		try {
			String sql = "insert into board( btitle , bcontent , bwriter , bpwd )"
					+ " value( ? , ? , ? , ? )";
			PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, boardDto.getBtitle() );
				ps.setString(2, boardDto.getBcontent() );
				ps.setString(3, boardDto.getBwriter() );
				ps.setString(4, boardDto.getBpwd() );
			int count = ps.executeUpdate();
			if( count == 1 ) { return true; }
		}catch( SQLException e ) { System.out.println(e); }
		return false;
	} // f end
	
//	2. 게시물 전체 조회
	public ArrayList<BoardDto> boardFindAll(){
		ArrayList<BoardDto> result = new ArrayList<>();
		
		try {
			String sql = "select * from board";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBno(rs.getInt("bno"));
				boardDto.setBtitle(rs.getString("btitle"));
				boardDto.setBcontent(rs.getString("bcontent"));
				boardDto.setBwriter(rs.getString("bwriter"));
				boardDto.setBview(rs.getInt("bview"));
				boardDto.setBpwd(rs.getString("bpwd"));
				boardDto.setBdate(rs.getString("bdate"));
				result.add(boardDto);
			} // w end
		}catch( SQLException e ) { System.out.println(e); }
		return result;
	} // f end
	
//	3. 게시물 수정
	public boolean boardUpdate( BoardDto boardDto ){
		try {
			String sql = "update board set btitle = ? , bcontent = ? "
					+ "where bno = ? and bpwd = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, boardDto.getBtitle());
				ps.setString(2, boardDto.getBcontent());
				ps.setInt(3, boardDto.getBno());
				ps.setString(4, boardDto.getBpwd());
			int count = ps.executeUpdate();
			if( count == 1 ) { return true; }
		}catch( SQLException e ) { System.out.println(e); }
		return false;
	} // f end
	
	
//	4. 게시물 삭제
	public boolean boardDelete( int bno ){
		try {
			String sql = "delete from board where bno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, bno);
			int count = ps.executeUpdate();
			if( count == 1 ) { return true; }
		}catch( SQLException e ) { System.out.println(e); }
		return false;
	} // f end
}
