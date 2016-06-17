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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bodyColor == null) ? 0 : bodyColor.hashCode());
		result = prime * result
				+ ((bodyType == null) ? 0 : bodyType.hashCode());
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
		Body other = (Body) obj;
		if (bodyColor == null) {
			if (other.bodyColor != null)
				return false;
		} else if (!bodyColor.equals(other.bodyColor))
			return false;
		if (bodyType == null) {
			if (other.bodyType != null)
				return false;
		} else if (!bodyType.equals(other.bodyType))
			return false;
		return true;
	}	
	
	

}
