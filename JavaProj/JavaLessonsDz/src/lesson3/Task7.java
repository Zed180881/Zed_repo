package lesson3;

//������� ����� � 20-�� ������ ����� Գ������� � ������� ���� �� �����. 
//��������, �� ������ � ������ ����� ����������� ���� ��������, � ����� 
//��������� - ����� ���� ����������.

public class Task7 {

	public static void main(String[] args) {

		int[] arr = createFibonachiArray(20);
		arrayPrintRow(arr);
	}

	private static int[] createFibonachiArray(int size) {

		int[] array = new int[size];
		array[0] = 1;
		array[1] = 1;
		for (int i = 2; i < array.length; i++)
			array[i] = array[i - 2] + array[i - 1];
		return array;
	}

	private static void arrayPrintRow(int[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println("");
	}
}