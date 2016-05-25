package lesson2;

//Виведіть на екран всі числа в послідовності 2a-1, де a1 = 2, які менше 10000.

public class Task8 {

	public static void main(String[] args) {
		int a = 2;
		int x = 2 * a - 1;
		do {
			System.out.println(x);
			a = a + 1;
			x = 2 * a - 1;
		} while (x < 10000);

	}

}
