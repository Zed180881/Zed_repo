package lesson1;
public class Main {

	static void say(String s) {
		System.out.println(s);
	}

	static void print(int i) {
		System.out.println(i);
	}

	static void print(int i, int j) {
		System.out.println(i + j);
	}

	static void print(char i) {
		System.out.println(i);
	}
	
	static void print(boolean i) {
		System.out.println(i);
	}

	public static void main(String[] args) {
		// System.out.println("Hello");
		// byte a=1;
		// short b=1;
		// int c=1;
		// long d=3000000000L;
		// char e='+';
		// float f=1.0f;
		// double g=1.0;
		// boolean h=true;

		// boolean b = true;
		// int i = b ? 1 : 2; // тернарний оператор
		// char x = (i == 1) ? 'a' : 'z';
		// System.out.println(x);

		int a = 5;
		int b = 10;
		int i = (a > b) ? a : b;
		System.out.println(i);
		say("Hello");
		print(4);
		print(4, 5);
		print('a');
		print(false);
	}
}
