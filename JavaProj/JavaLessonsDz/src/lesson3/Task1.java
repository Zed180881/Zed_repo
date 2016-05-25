package lesson3;

//������� ����� � ��� ������ ����� �� 2 �� 20 � ������� �������� ������ 
//�� ����� �������� � �����, ������������ ���� ������� �� ������ ����������, 
//� ���� � �������� (������������ ���� ������� �� ������ �������� ������ �����). 
//����� ���������� ������ ���������, ����� �� ���� ������.

public class Task1 {

	public static void main(String[] args) {

		int[] array = createArray();
		arrayPrintRow(array);
		arrayPrintColumn(array);

	}

	private static void arrayPrintColumn(int[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.println(array[i] + " ");
	}

	private static void arrayPrintRow(int[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println("");
	}

	private static int[] createArray() {

		int[] array = new int[10];
		int n = 2;
		for (int i = 0; i < 10; i++) {
			array[i] = n;
			n = n + 2;
		}
		return array;
	}
}
