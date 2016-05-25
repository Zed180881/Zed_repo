package lesson2;

public class Main {

	public static void main(String[] args) {

		int a = 2;
		int b = 3;
		int c = 4;
		System.out.println(add(a, b));
		System.out.println(add(a, b, c));
		System.out.println(add(2, 3, 4, 5, 6, 7));

	}

	private static int add(int... nums) {
		int sum = 0;
		for (int n : nums)
			sum += n;
		return sum;
	}

}
