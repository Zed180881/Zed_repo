package lesson3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		do {
			System.out
					.println("������ ����� �� ����� �������� ���� �������� �����:");

			int userChoice = read(sc);
			int cpu = random(1, userChoice);
			game(true, userChoice, cpu, 1, sc);
		} while (continueGame(sc));
		sc.close();
	}

	static int read(Scanner sc) {
		if (sc.hasNextInt())
			return sc.nextInt();
		return 0;
	}

	static int random(int from, int to) {
		int r = (int) Math.round(Math.random() * (to - from) + from);
		return r;
	}

	static boolean continueGame(Scanner sc) {
		System.out.println("����������? 1- ���, 0 - �");
		if (read(sc) != 1)
			return false;
		return true;
	}

	static void game(boolean isRun, int userChoice, int cpu, int turns,
			Scanner sc) {
		while (isRun) {
			System.out.println("�������� ����� �� 1 �� " + userChoice);
			int user = read(sc);
			if (cpu == user) {
				System.out.println("�� ��������� � " + turns + " ������!");
				isRun = false;
			} else {
				turns++;
				if (cpu < user)
					System.out.println("�� �� �������! ������ ����� �����!");
				else
					System.out.println("�� �� �������! ������ ����� �����!");
			}
		}
	}
}
