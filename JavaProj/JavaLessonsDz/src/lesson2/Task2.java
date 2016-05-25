package lesson2;

//Створити програму, що виводить на екран найближче до 10 з двох чисел, 
//записаних в змінні m і n. Наприклад, серед чисел 8,5 і 11,45 найближче до десяти 11,45.

public class Task2 {

	public static void main(String[] args) {
		double m = 8.5;
		double n = 11.45;
		nearestTen(m, n);
	}

	static void nearestTen(double m, double n) {
		System.out.print("З двох чисел " + m + " та " + n
				+ " найближче до 10 число ");
		if (Math.abs(m - 10) > Math.abs(n - 10))
			System.out.println(n);
		else
			System.out.println(m);
	}

}
