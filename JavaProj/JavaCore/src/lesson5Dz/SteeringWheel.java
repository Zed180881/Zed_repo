package lesson5Dz;

public class SteeringWheel {

	private int diameter = 15; // inches
	private boolean hasButtons = false;

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

	public SteeringWheel() {
	}

	public SteeringWheel(int diameter, boolean hasButtons) {
		this.diameter = diameter;
		this.hasButtons = hasButtons;
	}

	@Override
	public String toString() {
		String buttons = (hasButtons) ? "� ��������" : "��� ������";
		return "����� [ĳ������: " + diameter + ", " + buttons + "]";
	}

}