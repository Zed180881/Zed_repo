package lesson3;

//������� ����� � 8 ���������� ����� ����� � ������ [1; 10]. 
//������� ����� �� ����� � �����. ������ ����� ������� � �������� 
//�������� �� ����. ����� �������� ����� �� ����� �� �������� �����. 

public class Task4 {

	public static void main(String[] args) {

		int[] arr = createRndArray(8, 1, 10);
		arrayPrintRow(arr);
		arrayReplaceOddElements(arr);
		arrayPrintRow(arr);
	}

	private static void arrayReplaceOddElements(int[] array) {
		for (int i = 1; i < array.length; i += 2)
			array[i] = 0;
	}

	private static int[] createRndArray(int size, int from, int to) {

		int[] array = new int[size];
		for (int i = 0; i < array.length; i++)
			array[i] = (int) Math.round(Math.random() * (to - from) + from);
		return array;
	}

	private static void arrayPrintRow(int[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println("");
	}
}
