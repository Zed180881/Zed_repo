package lesson2;

public class Main {

	public static void main(String[] args) {

		Human h = new Human();
		Object o = new Human();
		System.out.println(o);
		System.out.println(h instanceof Object);
		h.walk();
		h.setAge(10);
		int age = h.getAge();
		System.out.println(age);
		Hunter hunter = new Hunter();
		hunter.eatMeat("beard meat");
		hunter.walk();
		hunter.killMammont();
		Zemlekop zemlecop = new Zemlekop();
		zemlecop.work("lopata");
		System.out.println(h);
		System.out.println(hunter);
	}

}
