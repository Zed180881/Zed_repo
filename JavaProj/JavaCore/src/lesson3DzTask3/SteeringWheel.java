package lesson3DzTask3;

public class SteeringWheel {

	private boolean isOK;

	public SteeringWheel() {
		this.isOK = true;
	}
	
	public void damage() {
		this.isOK = false;
	}
	
	public void run() {		
		if (isOK)
			System.out.println("���� �����:)");
		else
			System.out.println("���� ���������. ������ �� �������. ����� �����������.");
	}

}