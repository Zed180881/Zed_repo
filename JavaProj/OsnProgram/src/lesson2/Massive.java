package lesson2;

public class Massive {

	public static void main(String[] args) {

		int[] array = new int[10];
		fillArray(array);
		printArray(array);
	}

	static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	static void fillArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = array.length - 1 - i;
		}
	}

}
