package lesson5Dz;

public class Wheel {

	private WheelPosition wheelPosition;
	private int wheelDiameter = 19; // inches
	private String tyreType = "demiseasons";

	public Wheel(WheelPosition wheelPosition) {
	}

	public Wheel(WheelPosition wheelPosition, int wheelDiameter, String tyreType) {
		this.wheelPosition = wheelPosition;
		this.wheelDiameter = wheelDiameter;
		this.tyreType = tyreType;
	}

	public WheelPosition getWheelPosition() {
		return wheelPosition;
	}

	public void setWheelPosition(WheelPosition wheelPosition) {
		this.wheelPosition = wheelPosition;
	}

	public int getWheelDiameter() {
		return wheelDiameter;
	}

	public void setWheelDiameter(int wheelDiameter) {
		this.wheelDiameter = wheelDiameter;
	}

	public String getTyreType() {
		return tyreType;
	}

	public void setTyreType(String tyreType) {
		this.tyreType = tyreType;
	}

}
