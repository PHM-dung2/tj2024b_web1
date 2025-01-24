package day06;

public class ParkingDto {
//	1. 멤버변수
	private int pno;
	private int lno;
	private String car;
	private String time;
	private int state;
	private int price;
//	2. 생성자
	ParkingDto(){}
	public ParkingDto(int pno, int lno, String car, String time, int state, int price) {
		super();
		this.pno = pno;
		this.lno = lno;
		this.car = car;
		this.time = time;
		this.state = state;
		this.price = price;
	}
//	3. 메소드
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getLno() {
		return lno;
	}
	public void setLno(int lno) {
		this.lno = lno;
	}
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ParkDto [pno=" + pno + ", lno=" + lno + ", car=" + car + ", time=" + time + ", state=" + state
				+ ", price=" + price + "]";
	}
	
}
