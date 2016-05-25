package lesson2;

import java.util.Scanner;

/*
 Виведіть на екран всі позитивні подільники натурального числа, 
 введеного користувачем з клавіатури.

 Перевірте, чи є число записане в змінну n натуральне число - простим. 
 Постарайтеся не виконувати зайвих дій (наприклад, після того, як ви знайшли 
 хоча б один нетривіальний дільник вже ясно, що число складене і перевірку 
 продовжувати не потрібно). Також врахуйте, що найменший дільник натурального числа n, 
 якщо він взагалі є, обов'язково розташовується в відрізку [2; √n].
 */

public class Task11 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out
				.println("Введіть натуральне число для визначення дільників: ");
		int n = in.nextInt();
		in.close();
		if (checkCorrect(n)) {
			if (checkSimple(n))
				System.out.println(n + " просте число");
			else
				naturalDiv(n);
		} else
			System.out.println("Число повинне бути більше одиниці!");
	}

	static boolean checkCorrect(int n) {
		if (n < 2) {

			return false;
		} else
			return true;
	}

	static boolean checkSimple(int n) {
		for (int i = (int) Math.sqrt(n); i > 1; i--) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	static void naturalDiv(int n) {

		System.out.println("Позитивні дільники числа " + n + ":");
		for (int i = n - 1; i > 1; i--) {
			if (n % i == 0)
				System.out.println(i);
		}

	}
}
