package clone;

public class ParkingDto {
	
	private int cno;
	private String carNum;
	private int carLo;
	private String inCar;
	private String outCar;
	private boolean state;
	
	public ParkingDto() {} 
	public ParkingDto(int cno, String carNum, int carLo, String inCar, String outCar, boolean state) {
		super();
		this.cno = cno;
		this.carNum = carNum;
		this.carLo = carLo;
		this.inCar = inCar;
		this.outCar = outCar;
		this.state = state;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public int getCarLo() {
		return carLo;
	}
	public void setCarLo(int carLo) {
		this.carLo = carLo;
	}
	public String getInCar() {
		return inCar;
	}
	public void setInCar(String inCar) {
		this.inCar = inCar;
	}
	public String getOutCar() {
		return outCar;
	}
	public void setOutCar(String outCar) {
		this.outCar = outCar;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "ParkingDto [cno=" + cno + ", carNum=" + carNum + ", carLo=" + carLo + ", inCar=" + inCar + ", outCar="
				+ outCar + ", state=" + state + "]";
	}
	
	
	

}
