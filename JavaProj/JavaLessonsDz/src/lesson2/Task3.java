package lesson2;

//У три змінні a, b і c записані три дійсних числа. Створити програму, 
//яка буде знаходити і виводити на екран речові коріння квадратного рівняння 
//ax² + bx + c = 0, або повідомляти, що коріння немає.

public class Task3 {

	public static void main(String[] args) {
		double a = 1;
		double b = 10;
		double c = -4;
		solveQuadratic(a, b, c);
	}

	static void solveQuadratic(double a, double b, double c) {

		if (a == 0)
			if (b == 0)
				if (c == 0)
					System.out.println("Рішення - будь-яке число");
				else
					System.out.println("Рішень немає!");
			else
				System.out.println("x1 = x2 = " + (-c / b));
		else {
			if ((b * b - 4 * a * c) < 0)
				System.out
						.println("Рівняння не має речових коренів - тільки комплексні");
			else {
				double x1 = -(b / a) / 2
						+ Math.sqrt(((b / a) / 2) * ((b / a) / 2) - (c / a));
				double x2 = -(b / a) / 2
						- Math.sqrt(((b / a) / 2) * ((b / a) / 2) - (c / a));
				System.out.println("Корені рівняння: х1= " + x1 + " x2= " + x2);
			}

		}

	}
}
