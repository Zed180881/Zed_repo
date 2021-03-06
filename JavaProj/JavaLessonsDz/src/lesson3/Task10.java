package lesson3;

//������� ����� � 11 ���������� ����� ����� � ������ [-1; 1], ������� 
//����� �� ����� � �����. �������� ���� ������� ����������� � ����� ��������� 
//� ������� ��� �� ����������� �� �����. ���� ��� ������� �������� ������������ 
//�������� ������� ����, �� �� �������� ������. 

public class Task10 {

	public static void main(String[] args) {

		int[] arr = createRndArray(11, -1, 1);
		arrayPrintRow(arr);
		if (arrayCountElement(-1, arr) > arrayCountElement(0, arr)
				&& arrayCountElement(-1, arr) > arrayCountElement(1, arr))
			System.out.println("��������� ����������� ������� -1");
		if (arrayCountElement(0, arr) > arrayCountElement(-1, arr)
				&& arrayCountElement(0, arr) > arrayCountElement(1, arr))
			System.out.println("��������� ����������� ������� 0");
		if (arrayCountElement(1, arr) > arrayCountElement(-1, arr)
				&& arrayCountElement(1, arr) > arrayCountElement(0, arr))
			System.out.println("��������� ����������� ������� 1");
	}

	private static int arrayCountElement(int element, int[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++)
			if (array[i] == element)
				count++;
		return count;
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