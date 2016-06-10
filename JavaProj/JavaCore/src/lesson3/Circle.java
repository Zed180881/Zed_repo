package lesson3;

public class Circle implements RoundGeometric {

	private int radius;

	public Circle(int radius) {
		this.radius = radius;
	}

	@Override
	public int square() {
		return (int) (PI * radius * radius);
	}

	@Override
	public int perimeter() {
		
		return (int) (PI * radius * 2);
	}

}
