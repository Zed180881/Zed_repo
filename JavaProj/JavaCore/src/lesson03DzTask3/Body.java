package lesson03DzTask3;

public class Body {
	
	public Body(String color) {
		super();
		this.isOK = true;
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void damage() {
		this.isOK = false;
	}

	public void run() {		
		if (isOK)
			System.out.println(this.color + " ����� �������� �� �����");
		else
			System.out.println("����� ����������. ������ �� �������. ����� �����������.");
	}
	
	private boolean isOK;	
	private String color;
	
	
}
