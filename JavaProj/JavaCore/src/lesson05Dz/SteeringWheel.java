package lesson05Dz;

public class SteeringWheel {

	private int diameter = 15; // inches
	private boolean hasButtons = false;

	public SteeringWheel() {
	}

	public SteeringWheel(int diameter, boolean hasButtons) {
		this.diameter = diameter;
		this.hasButtons = hasButtons;
	}
	
	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	public boolean isHasButtons() {
		return hasButtons;
	}

	public void setHasButtons(boolean hasButtons) {
		this.hasButtons = hasButtons;
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + diameter;
		result = prime * result + (hasButtons ? 1231 : 1237);
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
		SteeringWheel other = (SteeringWheel) obj;
		if (diameter != other.diameter)
			return false;
		if (hasButtons != other.hasButtons)
			return false;
		return true;
	}
	
	

}
