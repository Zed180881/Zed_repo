package lesson3;

//������� ����� � ��� �������� ����� �� 1 �� 99, ������� ���� �� ����� � 
//�����, � ���� ��� �� ����� ������� �� ����� ��� � �����, ��� � ���������� 
//������� (99 97 95 93 ... 7 5 3 1).

public class Task2 {

	public static void main(String[] args) {

		int[] array = createArray(1, 999);
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

	private static int[] createArray(int begin, int end) {

		int[] array = new int[(end-begin)/2+1];
		for (int i = 0; i < array.length; i++) {
			array[i] = 2*i+begin;
		}
		return array;
	}
}
