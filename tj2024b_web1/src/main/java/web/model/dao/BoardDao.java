package web.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import web.model.dto.BoardDto;

@NoArgsConstructor( access = lombok.AccessLevel.PRIVATE )
public class BoardDao extends Dao{
//	+ 싱글톤
	@Getter // 싱글톤을 반환하는 함수 자동 생성 , getInstance() 자동 생성
	private static BoardDao instance = new BoardDao();
	
//	1. 게시물 작성
	public boolean write( BoardDto boardDto ) {
		try {
			String sql = "insert into board(btitle, bcontent, mno ,cno) value( ?,?,?,? )";
			PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, boardDto.getBtitle());
				ps.setString(2, boardDto.getBcontent());
				ps.setInt(3, boardDto.getMno());
				ps.setInt(4, boardDto.getCno());
			int count = ps.executeUpdate();
			if( count == 1 ) { return true; }
		}catch( SQLException e ) { System.out.println(e); }
		return false;
	} // f end
	
//	2. 전체 게시물 조회
	public ArrayList<BoardDto> findAll(){
		ArrayList<BoardDto> result = new ArrayList<BoardDto>();
		
		try {
			String sql = "select b.* , m.mid , c.cname from board b inner join member m on b.mno = m.mno "
					+ "inner join category c on c.cno = b.cno order by b.bno desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBno(rs.getInt("bno"));
				boardDto.setBtitle(rs.getString("btitle"));
				boardDto.setBcontent(rs.getString("bcontent"));
				boardDto.setBdate(rs.getString("bdate"));
				boardDto.setBview(rs.getInt("bview"));
				boardDto.setMid(rs.getString("mid"));
				boardDto.setCname(rs.getString("cname"));
				result.add(boardDto);
			}
		}catch( SQLException e ) { System.out.println(e); }
		return result;
	} // f end
	
//	3. 개별 게시물 조회
	public BoardDto findPersnal( int bno ) {
		BoardDto result = new BoardDto();
		try {
			String sql = "select b.* , m.mid , c.cname from board b "
					+ "inner join member m on b.mno = m.mno "
					+ "inner join category c on c.cno = b.cno "
					+ "where bno = ? order by b.bno desc";
			PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, bno);
			ResultSet rs = ps.executeQuery();
			if( rs.next() ) {
				result.setBno(rs.getInt("bno"));
				result.setBtitle(rs.getString("btitle"));
				result.setBcontent(rs.getString("bcontent"));
				result.setBdate(rs.getString("bdate"));
				result.setBview(rs.getInt("bview"));
				result.setMid(rs.getString("mid"));
				result.setCname(rs.getString("cname"));
			} // if end
		}catch( SQLException e ) { System.out.println(e); }
		return result;
	} // f end
	
//	4. 게시물 수정
	public boolean update( BoardDto boardDto ){
		try {
			String sql = "update board set btitle=?, bcontent=?, cno=? where bno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, boardDto.getBtitle());
				ps.setString(2, boardDto.getBcontent());
				ps.setInt(3, boardDto.getCno());
				ps.setInt(4, boardDto.getBno());
			int count = ps.executeUpdate();
			if( count == 1 ) { return true; }
		}catch( SQLException e ) { System.out.println(e); }
		return false;
	} // f end
	
//	5. 게시물 삭제
	public boolean delete( int bno ) {
		try {
			String sql = "delete from board where bno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, bno);
			int count = ps.executeUpdate();
			if( count == 1 ) { return true; }
		}catch( SQLException e ) { System.out.println(e); }
		return false;
	} // f end
	
//	6. 댓글 작성
	public boolean replyWrite() {
		try {
			String sql = "insert into value( ? )";
			PreparedStatement ps = conn.prepareStatement(sql);
				
			int count = ps.executeUpdate();
			if( count == 1 ) { return true; }
		}catch( SQLException e ) { System.out.println(e); }
		return false;
	} // f end
	
}
