package lesson05Dz;

public class Wheels {

	public Wheel wheelFrontLeft;
	public Wheel wheelFrontRight;
	public Wheel wheelBackLeft;
	public Wheel wheelBackRight;
	public Wheel spareWheel;

	public Wheels() {
		wheelFrontLeft = new Wheel(Wheel.Position.FRONT_LEFT);
		wheelFrontRight = new Wheel(Wheel.Position.FRONT_RIGHT);
		wheelBackLeft = new Wheel(Wheel.Position.BACK_LEFT);
		wheelBackRight = new Wheel(Wheel.Position.BACK_RIGHT);
		spareWheel = new Wheel(Wheel.Position.SPARE_WHEEL);
	}

	public Wheels(int wheelsDiameter, String tyreType) {
		wheelFrontLeft = new Wheel(Wheel.Position.FRONT_LEFT, wheelsDiameter,
				tyreType);
		wheelFrontRight = new Wheel(Wheel.Position.FRONT_RIGHT, wheelsDiameter,
				tyreType);
		wheelBackLeft = new Wheel(Wheel.Position.BACK_LEFT, wheelsDiameter,
				tyreType);
		wheelBackRight = new Wheel(Wheel.Position.BACK_RIGHT, wheelsDiameter,
				tyreType);
		spareWheel = new Wheel(Wheel.Position.SPARE_WHEEL, wheelsDiameter,
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((spareWheel == null) ? 0 : spareWheel.hashCode());
		result = prime * result
				+ ((wheelBackLeft == null) ? 0 : wheelBackLeft.hashCode());
		result = prime * result
				+ ((wheelBackRight == null) ? 0 : wheelBackRight.hashCode());
		result = prime * result
				+ ((wheelFrontLeft == null) ? 0 : wheelFrontLeft.hashCode());
		result = prime * result
				+ ((wheelFrontRight == null) ? 0 : wheelFrontRight.hashCode());
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
		Wheels other = (Wheels) obj;
		if (spareWheel == null) {
			if (other.spareWheel != null)
				return false;
		} else if (!spareWheel.equals(other.spareWheel))
			return false;
		if (wheelBackLeft == null) {
			if (other.wheelBackLeft != null)
				return false;
		} else if (!wheelBackLeft.equals(other.wheelBackLeft))
			return false;
		if (wheelBackRight == null) {
			if (other.wheelBackRight != null)
				return false;
		} else if (!wheelBackRight.equals(other.wheelBackRight))
			return false;
		if (wheelFrontLeft == null) {
			if (other.wheelFrontLeft != null)
				return false;
		} else if (!wheelFrontLeft.equals(other.wheelFrontLeft))
			return false;
		if (wheelFrontRight == null) {
			if (other.wheelFrontRight != null)
				return false;
		} else if (!wheelFrontRight.equals(other.wheelFrontRight))
			return false;
		return true;
	}

}


