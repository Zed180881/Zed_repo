package cars;

public class Car {
	
	public void start() {
		System.out.println("��������! ��������!");		
	}
	public void stop() {
		System.out.println("���������! ������ �����!");
	}
	public int drive(int howLong) {
		int distance = howLong*60;
		return distance;
	}
}
