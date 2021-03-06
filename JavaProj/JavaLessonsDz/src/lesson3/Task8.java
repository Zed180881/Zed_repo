package lesson3;

//������� ����� � 12 ���������� ����� ����� � ������ [-15; 15]. 
//�������� ���� ������� � � ����� ����� ������������ � �������� ������ 
//���� ���������� ��������� � �����.

public class Task8 {

	public static void main(String[] args) {

		int[] arr = createRndArray(12, -15, 15);
		arrayPrintRow(arr);
		System.out.println("������������ ������� � ����� ������� "
				+ arrayGetMax(arr));
		System.out
				.println("������ ���������� ��������� ������������� �������� � �����: "
						+ arrayGetLastMaxIndex(arr));
	}

	private static int arrayGetLastMaxIndex(int[] array) {
		int lastMaxIndex = 0;
		int max = array[0];
		for (int i = 1; i < array.length; i++)
			if (array[i] >= max) {
				max = array[i];
				lastMaxIndex = i;
			}
		return lastMaxIndex;
	}

	private static int arrayGetMax(int[] array) {
		int max = array[0];
		for (int i = 1; i < array.length; i++)
			if (array[i] > max)
				max = array[i];
		return max;
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