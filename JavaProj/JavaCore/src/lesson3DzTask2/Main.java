package lesson3DzTask2;

//�������� interface ��������, � ����� ����������� ����� ��������(). �������� ����
//��������� � ���������� ���������, �� ��������� � ���������� ������� ��������� .
//������� ���������� �������� ���������� � ��������. ������� �� ����� ������ ����������
//������ � ������ ����������.

public class Main {

	public static void main(String[] args) {

		FixedWorker worker1 = new FixedWorker("Vasya", 140, 3000);
		PerHourWorker worker2 = new PerHourWorker("Kuzya", 120);

		worker1.printDetails();
		worker2.printDetails();

	}

}
