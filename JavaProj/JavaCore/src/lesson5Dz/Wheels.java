package lesson5Dz;

public class Wheels {

	private Wheel wheelFrontLeft;
	private Wheel wheelFrontRight;
	private Wheel wheelBackLeft;
	private Wheel wheelBackRight;
	private Wheel spareWheel;

	public Wheels() {
		wheelFrontLeft = new Wheel(WheelPosition.FRONT_LEFT);
		wheelFrontRight = new Wheel(WheelPosition.FRONT_RIGHT);
		wheelBackLeft = new Wheel(WheelPosition.BACK_LEFT);
		wheelBackRight = new Wheel(WheelPosition.BACK_RIGHT);
		spareWheel = new Wheel(WheelPosition.SPARE_WHEEL);
	}

	public Wheels(int wheelsDiameter, String tyreType) {
		wheelFrontLeft = new Wheel(WheelPosition.FRONT_LEFT, wheelsDiameter,
				tyreType);
		wheelFrontRight = new Wheel(WheelPosition.FRONT_RIGHT, wheelsDiameter,
				tyreType);
		wheelBackLeft = new Wheel(WheelPosition.BACK_LEFT, wheelsDiameter,
				tyreType);
		wheelBackRight = new Wheel(WheelPosition.BACK_RIGHT, wheelsDiameter,
				tyreType);
		spareWheel = new Wheel(WheelPosition.SPARE_WHEEL, wheelsDiameter,
				tyreType);
	}

	public int getWheelsDiameter() {
		return wheelFrontLeft.getWheelDiameter();
	}

	public void setWheelsDiameter(int wheelDiameter) {
		this.wheelFrontLeft.setWheelDiameter(wheelDiameter);
		this.wheelFrontRight.setWheelDiameter(wheelDiameter);
		this.wheelBackLeft.setWheelDiameter(wheelDiameter);
		this.wheelBackRight.setWheelDiameter(wheelDiameter);
		this.spareWheel.setWheelDiameter(wheelDiameter);
	}

	public String getTyreType() {
		return wheelFrontLeft.getTyreType();
	}

	public void setTyreType(String tyreType) {
		this.wheelFrontLeft.setTyreType(tyreType);
		this.wheelFrontRight.setTyreType(tyreType);
		this.wheelBackLeft.setTyreType(tyreType);
		this.wheelBackRight.setTyreType(tyreType);
		this.spareWheel.setTyreType(tyreType);
	}

	@Override
	public String toString() {
		return "������ [ĳ������: " + this.getWheelsDiameter()
				+ ", ��� ������: " + this.getTyreType() + "]";
	}

}