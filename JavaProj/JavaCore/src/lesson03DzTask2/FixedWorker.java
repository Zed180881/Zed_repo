package lesson03DzTask2;

public class FixedWorker extends Worker {

	private int wageRate; // оклад

	public FixedWorker(String name, int workHours, int wageRate) {
		super(name, workHours);
		this.wageRate = wageRate;
	}

	@Override
	public double getSalary() {
		return ((int)(1.0* this.wageRate * this.getWorkHours() / TOTAL_WORK_HOURS_IN_MONTH)*100)/100;
	}

	@Override
	public void printDetails() {
		System.out.println("Працівник: " + this.getName());
		System.out.println("Форма оплати: фіксована. Ставка: " + this.wageRate
				+ " $ в місяць.");
		System.out.println("Пропрацював в цьому місяці: " + this.getWorkHours()
				+ " годин");
		System.out.println("Заробив за місяць: " + this.getSalary() + " $");
	}

}
