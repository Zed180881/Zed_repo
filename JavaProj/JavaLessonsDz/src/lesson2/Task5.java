package lesson2;

//Створіть програму, що виводить на екран перші 55 елементів послідовності 
//1 3 5 7 9 11 13 15 17 ....

public class Task5 {

	public static void main(String[] args) {

		int n = 1;
		for (int i = 0; i < 55; i++) {
			System.out.println(n);
			n = n + 2;
		}

	}

}
