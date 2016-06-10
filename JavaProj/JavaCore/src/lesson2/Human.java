package lesson2;

public class Human {
	private int age;	
	
	public Human() {
		
	}

	public Human(int age) {
		setAge(age);
	}

	public void walk() {
		System.out.println("go-go-go");
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		age = age >0 ? this.age : 1;		
	}

	public String toString() {
		return "xxx" + super.toString();
	}
	
}
