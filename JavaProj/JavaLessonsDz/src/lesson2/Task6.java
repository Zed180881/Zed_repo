package lesson2;

//Створіть програму, що виводить на екран всі невід'ємні 
//елементи послідовності 90 85 80 75 70 65 60 ....

public class Task6 {

	public static void main(String[] args) {

		int n = 90;
		while (n >= 0) {
			System.out.println(n);
			n = n - 5;
		}

	}

}
