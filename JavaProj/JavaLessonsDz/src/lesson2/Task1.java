package lesson2;

//�������� ��������, �� �������� � ��������� �� �����, �� � ���� ����� �������� 
//� ����� n, ������ ��� ��������.

public class Task1 {

	public static void main(String[] args) {

		int n = 10;
		checkNumber(n);

	}

	static void checkNumber(int n) {
		if (n % 2 == 1)
			System.out.println(n + " - ������� �����!");
		else
			System.out.println(n + " - ����� �����!");

	}

}
