package lesson3;

//������� 2 ������ � 5 ���������� ����� ����� � ������ [0; 5] �����, 
//������� ������ �� ����� � ���� ������� ������. ��������� ������� ����������� 
//�������� ������� ������ � ��������, ��� ����� � ������ �� �������� ��������� 
//����� (��� ��������, �� �� ������� ����������� ����).

public class Task5 {

	public static void main(String[] args) {

		int[] arr1 = createRndArray(5, 0, 5);
		int[] arr2 = createRndArray(5, 0, 5);
		arrayPrintRow(arr1);
		arrayPrintRow(arr2);
		System.out.println(arrayMiddle(arr1));
		System.out.println(arrayMiddle(arr2));
		if (arrayMiddle(arr1) > arrayMiddle(arr2))
			System.out.println("������� ����������� ������� ������ �����");
		else if (arrayMiddle(arr1) < arrayMiddle(arr2))
			System.out.println("������� ����������� ������� ������ �����");
		else
			System.out.println("������� ����������� ���� ������ ����");
	}

	private static double arrayMiddle(int[] array) {
		double n = 0;
		for (int i = 0; i < array.length; i++)
			n = n + array[i];
		n = n / array.length;
		return n;
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