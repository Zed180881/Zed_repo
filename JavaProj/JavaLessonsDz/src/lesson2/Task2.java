package lesson2;

//�������� ��������, �� �������� �� ����� ��������� �� 10 � ���� �����, 
//��������� � ���� m � n. ���������, ����� ����� 8,5 � 11,45 ��������� �� ������ 11,45.

public class Task2 {

	public static void main(String[] args) {
		double m = 8.5;
		double n = 11.45;
		nearestTen(m, n);
	}

	static void nearestTen(double m, double n) {
		System.out.print("� ���� ����� " + m + " �� " + n
				+ " ��������� �� 10 ����� ");
		if (Math.abs(m - 10) > Math.abs(n - 10))
			System.out.println(n);
		else
			System.out.println(m);
	}

}
