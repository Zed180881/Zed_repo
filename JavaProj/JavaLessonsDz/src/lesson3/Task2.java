package lesson3;

//������� ����� � ��� �������� ����� �� 1 �� 99, ������� ���� �� ����� � 
//�����, � ���� ��� �� ����� ������� �� ����� ��� � �����, ��� � ���������� 
//������� (99 97 95 93 ... 7 5 3 1).

public class Task2 {

	public static void main(String[] args) {

		int[] array = createArray();
		arrayPrintRow(array);
		arrayPrintBackward(array);

	}

	private static void arrayPrintRow(int[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println("");
	}

	private static void arrayPrintBackward(int[] array) {
		for (int i = array.length - 1; i >= 0; i--) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}

	private static int[] createArray() {

		int[] array = new int[50];
		int n = 1;
		for (int i = 0; i < 50; i++) {
			array[i] = n;
			n = n + 2;
		}
		return array;
	}
}