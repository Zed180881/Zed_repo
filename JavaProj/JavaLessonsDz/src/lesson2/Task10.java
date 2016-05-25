package lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Створіть програму, яка обчислює факторіал натурального числа n, яке 
//користувач введе з клавіатури.

//import java.util.Scanner;

public class Task10 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		System.out
				.println("Введіть натуральне число для обчислення факторіала: ");

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		int n = Integer.parseInt(reader.readLine());

		// реалізація через сканер
		// Scanner in = new Scanner(System.in);
		// int n = in.nextInt();
		// in.close();

		if (n < 0)
			System.out
					.println("Ви ввели від'ємне число - воно не належить до натуральних");
		else
			System.out.println("Факторіал числа " + n + " дорівнює "
					+ factorial(n));

	}

	private static int factorial(int n) {
		if (n == 0)
			return 1;
		else {
			int f = 1;
			for (int i = 1; i <= n; i++) {
				f = f * i;
			}
			return f;
		}

	}

}
