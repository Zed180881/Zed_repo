package lesson08Dz;

/*�������� ���� Methods, ������� � ����� ������ , �� �
 ������������� ���������, ���������, ��������, ������ ���� ������ .
 ��� ����� ��������� :

 ���� a<0, b<0 �������� IllegalArgumentException

 ���� a=0 b!=0 �������� ArithmeticException

 ���� a!=0 b=0 �������� ArithmeticException

 ���� a=0 b=0 �������� IllegalAccessException

 ���� a>0 b>0 �������� MyException

 ������������ �� ������ �������.*/

public class Methods {

	public static double add(double a, double b) throws Exception {
		check(a, b);
		return a + b;
	}

	public static double div(double a, double b) throws Exception {
		check(a, b);
		return a / b;
	}

	public static double substr(double a, double b) throws Exception {
		check(a, b);
		return a - b;
	}

	public static double multipl(double a, double b) throws Exception {
		check(a, b);
		return a * b;
	}

	private static void check(double a, double b) throws Exception {

		if ((a == 0 && b != 0) || (a != 0 && b == 0))
			throw new ArithmeticException();
		else if (a == 0 && b == 0)
			throw new IllegalAccessException();
		else if (a < 0 && b < 0)
			throw new IllegalArgumentException();
		else if (a > 0 && b > 0)
			throw new MyException();
	}
}
