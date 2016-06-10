package lesson3DzTask2;

public class PerHourWorker extends Worker {

	public PerHourWorker(String name, int workHours) {
		super(name, workHours);
	}

	@Override
	public double getSalary() {
		return this.getWorkHours() * PAID_PER_HOUR;
	}

	@Override
	public void printDetails() {
		System.out.println("Працівник: " + this.getName());
		System.out.println("Форма оплати: погодинна. Ставка: " + PAID_PER_HOUR
				+ " $ за годину.");
		System.out.println("Пропрацював в цьому місяці: " + this.getWorkHours()
				+ " годин");
		System.out.println("Заробив за місяць: " + this.getSalary() + " $");
	}
}
