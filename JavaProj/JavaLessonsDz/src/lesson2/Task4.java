package lesson2;

//Створіть програму, що виводить на екран всі чотиризначні числа послідовності 
//1000 1003 1006 1009 1012 1015.

public class Task4 {

	public static void main(String[] args) {

		int i = 1000;
		while (i < 10000) {
			System.out.println(i);
			i = i + 3;
		}

	}

}
