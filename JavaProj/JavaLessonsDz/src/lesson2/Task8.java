package lesson2;

//������� �� ����� �� ����� � ����������� 2a-1, �� a1 = 2, �� ����� 10000.

public class Task8 {

	public static void main(String[] args) {
		int a = 2;
		int x = 2 * a - 1;
		do {
			System.out.println(x);
			a = a + 1;
			x = 2 * a - 1;
		} while (x < 10000);

	}

}
