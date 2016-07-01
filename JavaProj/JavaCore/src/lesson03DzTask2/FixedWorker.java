package lesson03DzTask2;

public class FixedWorker extends Worker {

	private int wageRate; // �����

	public FixedWorker(String name, int workHours, int wageRate) {
		super(name, workHours);
		this.wageRate = wageRate;
	}

	@Override
	public double getSalary() {
		return ((int)(1.0* this.wageRate * this.getWorkHours() / TOTAL_WORK_HOURS_IN_MONTH)*100)/100;
	}

	@Override
	public void printDetails() {
		System.out.println("���������: " + this.getName());
		System.out.println("����� ������: ���������. ������: " + this.wageRate
				+ " $ � �����.");
		System.out.println("����������� � ����� �����: " + this.getWorkHours()
				+ " �����");
		System.out.println("������� �� �����: " + this.getSalary() + " $");
	}

}
