package lesson2;

//Створіть програму, що виводить на екран перші 20 елементів послідовності 
//2 4 8 16 32 64 128 ....

public class Task7 {

	public static void main(String[] args) {

		int n = 2;
		for (int i = 0; i < 20; i++) {
			System.out.println(n);
			n = n * 2;
		}

	}

}
