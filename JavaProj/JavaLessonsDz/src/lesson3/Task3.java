package lesson3;

//������� ����� � 15 ���������� ����� ����� � ������ [0; 9]. 
//������� ����� �� �����. ϳ�������� ������ � ����� ������ �������� � 
//�������� �� ������� �� ����� �� �������� �����. 

public class Task3 {

	public static void main(String[] args) {

		int[] arr = createRndArray(15, 0, 9);
		arrayPrintRow(arr);
		System.out.println(arrayEvenCount(arr));
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

	private static int arrayEvenCount(int[] array) {
		int evenCount = 0;
		for (int i = 0; i < array.length; i++)
			if (array[i] % 2 == 0)
				evenCount++;
		return evenCount;
	}

}
