package lesson5Dz;

public class Car {

	private String model = "BMW";
	private Body body;
	private SteeringWheel steeringWheel;
	private Wheels wheels;

	public Car() {
		body = new Body();
		steeringWheel = new SteeringWheel();
		wheels = new Wheels();
	}

	public Car(String model, String color, String bodyType, int wheelsDiameter,
			String tyreType, int steeringWheelDiameter,
			boolean steeringWheelHasButtons) {
		this.model = model;
		this.body = new Body(color, bodyType);
		this.wheels = new Wheels(wheelsDiameter, tyreType);
		this.steeringWheel = new SteeringWheel(steeringWheelDiameter,
				steeringWheelHasButtons);
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return this.body.getBodyColor();
	}

	public void setColor(String color) {
		this.body.setBodyColor(color);
	}

	public String getBodyType() {
		return this.body.getBodyType();
	}

	public void setBodyType(String bodyType) {
		this.body.setBodyType(bodyType);
	}

	public int getWheelsDiameter() {
		return this.wheels.getWheelsDiameter();
	}

	public void setWheelsDiameter(int wheelsDiameter) {
		this.wheels.setWheelsDiameter(wheelsDiameter);
	}

	public String getTyreType() {
		return this.wheels.getTyreType();
	}

	public void setTyreType(String tyreType) {
		this.wheels.setTyreType(tyreType);
	}

	public int getSteeringWheelDiameter() {
		return this.steeringWheel.getDiameter();
	}

	public void setSteeringWheelDiameter(int steeringWheelDiameter) {
		this.steeringWheel.setDiameter(steeringWheelDiameter);
	}

	public boolean isSteeringWheelHasButtons() {
		return this.steeringWheel.isHasButtons();
	}

	public void setSteeringWheelHasButtons(boolean hasButtons) {
		this.steeringWheel.setHasButtons(hasButtons);
	}

	@Override
	public String toString() {
		return "������: "
				+ this.model
				+ ", ��� ������ - "
				+ getBodyType()
				+ ", ���� - "
				+ getColor()
				+ ", ������� ���� - "
				+ getWheelsDiameter()
				+ ", ��� ������ - "
				+ getTyreType()
				+ ", ������� ����� - "
				+ getSteeringWheelDiameter()
				+ (isSteeringWheelHasButtons() ? ", ����� � ��������."
						: ", ����� ��� ������.");
	}
}