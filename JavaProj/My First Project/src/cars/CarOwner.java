package cars;

public class CarOwner {

	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.start();
		System.out.println("����������� " + myCar.drive(10) + " ����");
		myCar.stop();
		JamesBondCar ferrari = new JamesBondCar();
		ferrari.start();
		System.out.println("���������� " + ferrari.drive(15) + " ����");
		ferrari.stop();
	}

}
