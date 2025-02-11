package web.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import web.model.dto.BoardDto;
import web.model.dto.ReplyDto;

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
	
//	2-2 게시물의 전체 개수 조회 
	public int getTotalSize( int cno ) {
		try {
			String sql = "select count(*) from board where cno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, cno);
			ResultSet rs  = ps.executeQuery();
			if( rs.next() ) { return rs.getInt( 1 ); }
		}catch( SQLException e ) { System.out.println(e); }
		return 0;
	} // f end
	
	
//	2. 전체 게시물 조회
	public ArrayList<BoardDto> findAll( int cno , int startRow , int display ){
		ArrayList<BoardDto> result = new ArrayList<BoardDto>();
		
		try {
			String sql = "select b.* , m.mid from board b inner join member m on b.mno = m.mno "
					+ "where cno=? order by b.bno desc limit ? , ?";
			PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, cno);
				ps.setInt(2, startRow);
				ps.setInt(3, display);
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBno(rs.getInt("bno"));
				boardDto.setBtitle(rs.getString("btitle"));
				boardDto.setBcontent(rs.getString("bcontent"));
				boardDto.setBdate(rs.getString("bdate"));
				boardDto.setBview(rs.getInt("bview"));
				boardDto.setMid(rs.getString("mid"));
				result.add(boardDto);
			}
		}catch( SQLException e ) { System.out.println(e); }
		return result;
	} // f end
	
//	3. 개별 게시물 조회
	public BoardDto findByBno( int bno ) {
		BoardDto result = new BoardDto();
		ArrayList<ReplyDto> arr = new ArrayList<>();
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
			
			String sql2 = "select r.*, m.mid from reply r "
					+ "inner join member m on r.mno = m.mno "
					+ "where bno=?";
			PreparedStatement ps2 = conn.prepareStatement(sql2);
				ps2.setInt(1, bno);
			ResultSet rs2 = ps2.executeQuery();
			while( rs2.next() ) {
				ReplyDto replyDto = new ReplyDto();
				replyDto.setRno(rs2.getInt("rno"));
				replyDto.setRcontent(rs2.getString("rcontent"));
				replyDto.setRdate(rs2.getString("rdate"));
				replyDto.setMid(rs2.getString("mid"));
				replyDto.setBno(rs2.getInt("bno"));
				arr.add(replyDto);
			}
		}catch( SQLException e ) { System.out.println(e); }
		result.setArr(arr);
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
	public boolean replyWrite( HashMap<String, String> map ) {
		try {
			String sql = "insert into reply(rcontent, mno, bno) value( ?,?,? )";
			PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, map.get("rcontent"));
				ps.setString(2, map.get("mno"));
				ps.setString(3, map.get("bno"));
			int count = ps.executeUpdate();
			if( count == 1 ) { return true; }
		}catch( SQLException e ) { System.out.println(e); }
		return false;
	} // f end
	
//	7. 특정 게시물의 댓글 전체 조회
	public List< Map<String, String> > replyFindAll( int bno ){
		List< Map<String, String> > result = new ArrayList<>();
		try {
			String sql = "select * from reply r "
					+ "inner join member m on r.mno = m.mno "
					+ "where r.bno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, bno);
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				Map<String, String> map = new HashMap<String, String>();
				map.put( "rno" , rs.getString("rno") );
				map.put( "rcontent" , rs.getString("rcontent") );
				map.put( "rdate" , rs.getString("rdate") );
				map.put( "mid" , rs.getString("mid") );
				map.put( "mno" , rs.getString("mno") );
				map.put( "mimg" , rs.getString("mimg") );
				result.add( map );
			}
		}catch( SQLException e ) { System.out.println(e); }
		return result;
	} // f end
	
	
}
