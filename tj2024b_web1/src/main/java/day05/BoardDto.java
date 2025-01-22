package day05;

public class BoardDto {
//	1. 멤버변수
	private int bno;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private int bview;
	private String bpwd;
	private String bdate;
//	2. 생성자
	public BoardDto() {}
	public BoardDto(int bno, String btitle, String bcontent, String bwriter, int bview, String bpwd, String bdate) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bwriter = bwriter;
		this.bview = bview;
		this.bpwd = bpwd;
		this.bdate = bdate;
	}

	//	3. 메소드
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public String getBpwd() {
		return bpwd;
	}
	public int getBview() {
		return bview;
	}
	public void setBview(int bview) {
		this.bview = bview;
	}
	public void setBpwd(String bpwd) {
		this.bpwd = bpwd;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bwriter=" + bwriter
				+ ", bview=" + bview + ", bpwd=" + bpwd + ", bdate=" + bdate + "]";
	}
	
}
