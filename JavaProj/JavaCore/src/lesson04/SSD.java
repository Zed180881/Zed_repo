package lesson04;

public class SSD {
	private int capacity = 64;

	public SSD() {
	}

	public SSD(int capacity) {
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "SSD [capacity=" + capacity + "]";
	}

}
