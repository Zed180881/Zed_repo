package lesson3DzTask2;

//Створити interface Зарплата, в якому передбачити метод зарплата(). Створити клас
//Працівник з погодинною зарплатою, та Працівник з фіксованою місячною зарплатою .
//Формула розрахунку зарплати працівника є довільною. Вивести на екран скільки заробляють
//перший і другий працівники.

public class Main {

	public static void main(String[] args) {

		FixedWorker worker1 = new FixedWorker("Vasya", 140, 3000);
		PerHourWorker worker2 = new PerHourWorker("Kuzya", 120);

		worker1.printDetails();
		worker2.printDetails();

	}

}
