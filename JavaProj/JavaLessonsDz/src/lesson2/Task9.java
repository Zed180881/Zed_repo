package lesson2;

//Виведіть на екран всі двозначні члени послідовності 2a+200, де a1 = -166.

public class Task9 {

	public static void main(String[] args) {

		int a = -166;
		int n = 2 * a + 200;
		do {
			if (n > -100 && (n < -9 || n > 9))
				System.out.println(n);
			a = a + 1;
			n = 2 * a + 200;
		} while (n < 100);

	}

}
