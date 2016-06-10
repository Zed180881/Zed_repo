package lesson3DzTask2;

public class PerHourWorker extends Worker {

	public PerHourWorker(String name, int workHours) {
		super(name, workHours);
	}

	@Override
	public double getSalary() {
		return this.getWorkHours() * PAID_PER_HOUR;
	}

	@Override
	public void printDetails() {
		System.out.println("���������: " + this.getName());
		System.out.println("����� ������: ���������. ������: " + PAID_PER_HOUR
				+ " $ �� ������.");
		System.out.println("����������� � ����� �����: " + this.getWorkHours()
				+ " �����");
		System.out.println("������� �� �����: " + this.getSalary() + " $");
	}
}
