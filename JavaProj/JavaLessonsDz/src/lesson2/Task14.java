package lesson2;

//��� ���������� � ����� n ������������ ����� ��������� ���� ��� ���� ���� 
//(���������� �� ����� ������ ���� ���� � ����).

public class Task14 {

	public static void main(String[] args) {
		int n = 16569874;
		int sum = 0;
		while (n != 0) {
			sum = sum + (n % 10);
			n = n / 10;
		}
		System.out.println(sum);
	}
}
