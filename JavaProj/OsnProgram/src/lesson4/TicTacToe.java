package lesson4;

import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] battle = new int[3][3];		
		while (true) {
			cpuShot(battle);
			print(battle);
			if (isSomeOneWin(battle)) {
				System.out.println("Winner");
				break;
			}
			userShot(battle, sc);
			print(battle);
			if (isSomeOneWin(battle)) {
				System.out.println("Winner");
				break;
			}
		}
		sc.close();
	}

	static boolean isSomeOneWin(int[][] battle) {
		return (checkRow(battle) || checkColumn(battle) || checkDiag(battle) || isAllFieldFull(battle));
	}

	static boolean checkRow(int[][] battle) {

		for (int i = 0; i < battle.length; i++) {
			int sum = 0;
			for (int j = 0; j < battle[i].length; j++)
				sum += battle[i][j];
			if (sum == 3 || sum == -3)
				return true;
		}
		return false;
	}

	static boolean checkColumn(int[][] battle) {

		for (int i = 0; i < battle.length; i++) {
			int sum = 0;
			for (int j = 0; j < battle.length; j++)
				sum += battle[j][i];
			if (sum == 3 || sum == -3)
				return true;
		}
		return false;
	}

	static boolean checkDiag(int[][] battle) {
		int sum = battle[0][0] + battle[1][1] + battle[2][2];
		if (sum == 3 || sum == -3)
			return true;
		sum = battle[0][2] + battle[1][1] + battle[2][0];
		if (sum == 3 || sum == -3)
			return true;
		return false;
	}

	static boolean isAllFieldFull(int[][] battle) {
		for (int i = 0; i < battle.length; i++) {
			for (int j = 0; j < battle[i].length; j++) {
				if (battle[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	static void userShot(int[][] battle, Scanner sc) {
		System.out.println("Enter from 1 to 3 by x coordinate");
		int y = read(sc) - 1;
		System.out.println("Enter from 1 to 3 by y coordinate");
		int x = read(sc) - 1;
		battle[x][y] = 1;
	}

	static void cpuShot(int[][] battle) {
		boolean isShoted = true;
		while (isShoted) {
			int x = random(0, 2);
			int y = random(0, 2);
			if (battle[x][y] == 0) {
				isShoted = false;
				battle[x][y] = -1;
			}
		}
	}

	static void print(int[][] battle) {
		System.out.println("------");
		for (int i = 0; i < battle.length; i++) {
			for (int j = 0; j < battle[i].length; j++) {
				if (battle[i][j] == 1) {
					System.out.print("o ");
				} else if (battle[i][j] == -1) {
					System.out.print("x ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		System.out.println("------");
	}

	static int random(int from, int to) {
		int r = (int) Math.round(Math.random() * (to - from) + from);
		return r;
	}

	static int read(Scanner sc) {
		if (sc.hasNextInt()) {
			return sc.nextInt();
		}
		return 0;
	}
}