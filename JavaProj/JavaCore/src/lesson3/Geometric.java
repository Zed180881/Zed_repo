package lesson3;

public interface Geometric {

	public int square();

	public int perimeter();

	public default void print() {
		System.out.println(this.square() + " " + this.perimeter());
	}
}
