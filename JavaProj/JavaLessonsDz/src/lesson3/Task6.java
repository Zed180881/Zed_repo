package lesson3;

//������� ����� � 4 ���������� ����� ����� � ������ [10; 99], ������� 
//���� �� ����� � �����. ��������� � ������� �� ����� ����������� ��� ��, 
//�� � ����� ������ ��������� �����������. 

public class Task6 {

	public static void main(String[] args) {

		int[] arr = createRndArray(4, 10, 99);
		arrayPrintRow(arr);
		if (arrayCheckGrowUp(arr))
			System.out.println("����� � ������ ���������� �����������");
		else
			System.out.println("����� �� � ������ ���������� �����������");
	}

	private static boolean arrayCheckGrowUp(int[] array) {

		for (int i = 1; i < array.length; i++)
			if (array[i] < array[i - 1])
				return false;
		return true;
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