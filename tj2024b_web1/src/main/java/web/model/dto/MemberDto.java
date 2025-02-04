package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
public class MemberDto {
    private int mno;           	// 회원번호
    private String mid;       	// 아이디 
    private String mpwd;      	// 비밀번호
    private String mname;     	// 이름
    private String mphone;    	// 연락처 
    private String mdate;     	// 가입일 
    private String mimg;		// 프로필
    private String mpoint;		// 현재 포인트
    
//  @NoArgsConstructor
//  public memberDto(){};  
    
//  @AllArgsConstructor
//  public memberDto(int mno, String mid, String mpwd, String mname, String mphone, String mdate) {
//    	super();
//    	this.mno = mno;
//    	this.mid = mid;
//    	this.mpwd = mpwd;
//    	this.mname = mname;
//    	this.mphone = mphone;
//    	this.mdate = mdate;
//  }
    
//	@Getter @Setter
    
//	public int getMno() {
//		return mno;
//	}
//	public void setMno(int mno) {
//		this.mno = mno;
//	}
//	public String getMid() {
//		return mid;
//	}
//	public void setMid(String mid) {
//		this.mid = mid;
//	}
//	public String getMpwd() {
//		return mpwd;
//	}
//	public void setMpwd(String mpwd) {
//		this.mpwd = mpwd;
//	}
//	public String getMname() {
//		return mname;
//	}
//	public void setMname(String mname) {
//		this.mname = mname;
//	}
//	public String getMphone() {
//		return mphone;
//	}
//	public void setMphone(String mphone) {
//		this.mphone = mphone;
//	}
//	public String getMdate() {
//		return mdate;
//	}
//	public void setMdate(String mdate) {
//		this.mdate = mdate;
//	}
    
//  @ToString
    
//	@Override
//	public String toString() {
//		return "memberDto [mno=" + mno + ", mid=" + mid + ", mpwd=" + mpwd + ", mname=" + mname + ", mphone=" + mphone
//				+ ", mdate=" + mdate + "]";
//	}
    
    
}
