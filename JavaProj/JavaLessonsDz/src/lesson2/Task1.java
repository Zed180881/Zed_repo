package lesson2;

//Створити програму, що перевіряє і повідомляє на екран, чи є ціле число записане 
//в змінну n, парним або непарним.

public class Task1 {

	public static void main(String[] args) {

		int n = 10;
		checkNumber(n);

	}

	static void checkNumber(int n) {
		if (n % 2 == 1)
			System.out.println(n + " - непарне число!");
		else
			System.out.println(n + " - парне число!");

	}

}
