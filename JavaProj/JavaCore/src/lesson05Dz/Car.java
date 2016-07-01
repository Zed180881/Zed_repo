package lesson05Dz;

public class Car {

	private String model = "BMW";
	public Body body;
	public SteeringWheel steeringWheel;
	public Wheels wheels;

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
		return "Модель: "
				+ this.model
				+ ", тип кузова - "
				+ getBodyType()
				+ ", колір - "
				+ getColor()
				+ ", діаметер коліс - "
				+ getWheelsDiameter()
				+ ", тип резини - "
				+ getTyreType()
				+ ", діаметер керма - "
				+ getSteeringWheelDiameter()
				+ (isSteeringWheelHasButtons() ? ", кермо з кнопками."
						: ", кермо без кнопок.");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result
				+ ((steeringWheel == null) ? 0 : steeringWheel.hashCode());
		result = prime * result + ((wheels == null) ? 0 : wheels.hashCode());
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
		Car other = (Car) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (steeringWheel == null) {
			if (other.steeringWheel != null)
				return false;
		} else if (!steeringWheel.equals(other.steeringWheel))
			return false;
		if (wheels == null) {
			if (other.wheels != null)
				return false;
		} else if (!wheels.equals(other.wheels))
			return false;
		return true;
	}

}
