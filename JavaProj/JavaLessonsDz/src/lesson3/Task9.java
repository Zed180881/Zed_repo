package lesson3;

//Створіть два масиви з 10 цілих випадкових чисел з відрізка [1; 9] і 
//третій масив з 10 дійсних чисел. Кожен елемент з i-им індексом третього 
//масиву повинен дорівнювати відношенню елементу з першого масиву з i-им 
//індексом до елементу з другого масиву з i-им індексом. Вивести всі три 
//масиву на екран (кожен на окремому рядку), потім вивести кількість цілих 
//елементів в третьому масиві. 

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
		System.out.println("Кількість цілих елементів в третьому масиві: "
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