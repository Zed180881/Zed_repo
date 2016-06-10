package lesson1;

public class Car {

	String brand;
	double fuel;
	int maxSpeed;

	public Car() {
	}

	public Car(String brand, double fuel, int maxSpeed) {
		this.brand = brand;
		this.fuel = fuel;
		this.maxSpeed = maxSpeed;
	}

	public void drive(int km) {
		if ("BMW".equals(this.brand))
			this.fuel = this.fuel - km / 100 * 12;
		else if ("MAN".equals(this.brand))
			this.fuel = this.fuel - km / 100 * 12;
		if (this.fuel < 0) {
			System.out.println(this.brand + ": no brum-brum");
			System.out.println(this.brand + " " + this.fuel);
		} else {
			System.out.println(this.brand + ": brum-brum");
			System.out.println(this.brand + " " + this.fuel);
		}

	}

	public String toString() {
		return "����� ������: "+ this.brand + " ��� ������: " + this.fuel + " ����������� ��������: " + this.maxSpeed;
	}
}