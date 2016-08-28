package ch07_Decorator;

public class RegularExtra extends Extra {
	public RegularExtra(String label, double price, Order order) {
		super(label, price, order);
	}

	public double getPrice() {
		return this.price + order.getPrice();
	}
}