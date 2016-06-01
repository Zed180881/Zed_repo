package lesson1;

public class Person {
	private String name;
	private int age;

	public Person() {

	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void walk() {
		System.out.println(this.name + " go-go-go");
	}

	public String toString() {
		return "Person name: " + this.name + " age: " + this.age;
	}

}
