package day03.task2;

public class WaitingDto {
	private String phone;
	private int count;
	public WaitingDto() {}
	public WaitingDto(String phone, int count) {
		super();
		this.phone = phone;
		this.count = count;
	}
	@Override
	public String toString() {
		return "WaitingDto [phone=" + phone + ", count=" + count + "]";
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
