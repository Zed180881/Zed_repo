package lesson03DzTask2;

public abstract class Worker implements Salary {

	private String name;
	private int workHours;

	public String getName() {
		return this.name;
	}

	public int getWorkHours() {
		return this.workHours;
	}

	public Worker(String name, int workHours) {
		this.name = name;
		this.workHours = workHours;
	}

	public abstract double getSalary();	

}
