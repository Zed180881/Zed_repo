package lesson03;

public class Rectangle implements Geometric {

	private int a;
	private int b;

	public Rectangle(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public int square() {
		return a * b;
	}

	@Override
	public int perimeter() {
		
		return 2 * (a + b);
	}

}
