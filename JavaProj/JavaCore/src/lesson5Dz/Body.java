package lesson5Dz;

public class Body {

	private String bodyColor = "black";
	private String bodyType = "sedan";

	public Body() {
	}

	public Body(String bodyColor, String bodyType) {
		this.bodyColor = bodyColor;
		this.bodyType = bodyType;
	}

	public String getBodyColor() {
		return bodyColor;
	}

	public void setBodyColor(String bodyColor) {
		this.bodyColor = bodyColor;
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

	@Override
	public String toString() {
		return "Кузов [Колір: " + bodyColor + ", Тип: " + bodyType + "]";
	}

}
