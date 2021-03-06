package lesson05Dz;

public class Wheel {

	private Position wheelPosition;
	private int wheelDiameter = 19; // inches
	private String tyreType = "demiseasons";

	public Wheel(Position wheelPosition) {
	}

	public Wheel(Position wheelPosition, int wheelDiameter, String tyreType) {
		this.wheelPosition = wheelPosition;
		this.wheelDiameter = wheelDiameter;
		this.tyreType = tyreType;
	}

	public Position getWheelPosition() {
		return wheelPosition;
	}

	public void setWheelPosition(Position wheelPosition) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((tyreType == null) ? 0 : tyreType.hashCode());
		result = prime * result + wheelDiameter;
		result = prime * result
				+ ((wheelPosition == null) ? 0 : wheelPosition.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wheel other = (Wheel) obj;
		if (tyreType == null) {
			if (other.tyreType != null)
				return false;
		} else if (!tyreType.equals(other.tyreType))
			return false;
		if (wheelDiameter != other.wheelDiameter)
			return false;
		if (wheelPosition != other.wheelPosition)
			return false;
		return true;
	}
	
	public static enum Position {
		FRONT_LEFT, FRONT_RIGHT, BACK_LEFT, BACK_RIGHT, SPARE_WHEEL
	}
}
