package lesson2;

//������� ��������, �� �������� �� ����� 12 ������ �������� ����������� � 
//������ 2an-2, �� a1 = 3 � a2 = 2.

public class Task12 {

	public static void main(String[] args) {

		int a = 3;
		int n = 0;
		for (int i = 1; i <= 12; i++) {
			n = 2 * a * i - 2;
			System.out.println(n);
			a = a - 1;
		}

	}

}
