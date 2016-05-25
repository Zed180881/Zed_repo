package lesson3;

//Створіть масив з 4 випадкових цілих чисел з відрізка [10; 99], виведіть 
//його на екран у рядок. Визначити і вивести на екран повідомлення про те, 
//чи є масив строго зростаючої послідовністю. 

public class Task6 {

	public static void main(String[] args) {

		int[] arr = createRndArray(4, 10, 99);
		arrayPrintRow(arr);
		if (arrayCheckGrowUp(arr))
			System.out.println("Масив є строго зростаючою послідовністю");
		else
			System.out.println("Масив не є строго зростаючою послідовністю");
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