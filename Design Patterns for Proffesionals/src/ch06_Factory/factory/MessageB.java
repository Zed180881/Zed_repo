package ch06_Factory.factory;

import javax.enterprise.inject.Alternative;

@Alternative
public class MessageB {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}