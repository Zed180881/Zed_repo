package lesson02DzTask2;

// Створити клас MyMath. В ньому створити 2-3 константи і 3-4 статичні методи.
//Константи і методи повинні бути математичного характеру.

public class MyMath {

	public static final double PI = 3.14159;
	public static final double E = 2.71828;
	public static final double GOLD_CUT = 1.618033;
	public static final double EMBRI_TREFTEN = 0.70258;

	public static int abs(int a) {
		if (a < 0)
			return a * -1;
		return a;
	}

	public static double abs(double a) {
		if (a < 0)
			return a * -1;
		return a;
	}

	public static int max(int a, int b) {
		if (a > b)
			return a;
		return b;
	}

	public static double max(double a, double b) {
		if (a > b)
			return a;
		return b;
	}

	public static int min(int a, int b) {
		if (a < b)
			return a;
		return b;
	}

	public static double min(double a, double b) {
		if (a < b)
			return a;
		return b;
	}

	public static double pow(double a, int b) {
		if (b < 0)
			return 0.0;
		if (b == 0)
			return 1.0;
		if (b == 1)
			return a;
		for (int i = 1; i < b; i++) {
			a = a * a;
		}
		return a;
	}

}
