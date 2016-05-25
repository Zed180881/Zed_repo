package lesson3;

//������� ��� ������ � 10 ����� ���������� ����� � ������ [1; 9] � 
//����� ����� � 10 ������ �����. ����� ������� � i-�� �������� �������� 
//������ ������� ���������� ��������� �������� � ������� ������ � i-�� 
//�������� �� �������� � ������� ������ � i-�� ��������. ������� �� ��� 
//������ �� ����� (����� �� �������� �����), ���� ������� ������� ����� 
//�������� � �������� �����. 

public class Task9 {

	public static void main(String[] args) {

		int[] arr1 = createRndArray(10, 1, 9);
		arrayPrintRow(arr1);
		int[] arr2 = createRndArray(10, 1, 9);
		arrayPrintRow(arr2);
		double[] arr3 = arrayDiv(arr1, arr2);
		arrayPrintRow(arr3);
		arrayPrintIntCount(arr3);

	}

	private static void arrayPrintIntCount(double[] array) {
		int intCount = 0;
		for (int i = 0; i < array.length; i++)
			if (array[i] == Math.round(array[i]))
				intCount++;
		System.out.println("ʳ������ ����� �������� � �������� �����: "
				+ intCount);
	}

	private static double[] arrayDiv(int[] array1, int[] array2) {
		double[] array3 = new double[array2.length];
		for (int i = 0; i < array2.length; i++)
			array3[i] = (double) array1[i] / array2[i];
		return array3;
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

	private static void arrayPrintRow(double[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println("");
	}

}