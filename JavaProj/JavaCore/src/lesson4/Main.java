package lesson4;

public class Main {
	public static void main(String[] args) {
		PersonalComputer comp = new PersonalComputer();
		System.out.println(comp);

		PersonalComputer comp1 = new PersonalComputer(8, 3200, 8000);
		System.out.println(comp1);

		PersonalComputer comp2 = new PersonalComputer(4, 4000, 16000, 128);
		System.out.println(comp2);

		PersonalComputer comp3 = new PersonalComputer(new Cpu(), new Ram(), new SSD());
		System.out.println(comp3);
		
		comp3.bust();
		System.out.println(comp3);

	}
}
