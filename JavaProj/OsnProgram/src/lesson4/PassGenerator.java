package lesson4;

public class PassGenerator {

	public static void main(String[] args) {
		char[] pass = new char[myRandom(10, 15)];
		generate(pass);
		valid(pass);
		System.out.println(pass);
	}

	static void valid(char[] pass) {
		boolean isValid = false;
		while (!isValid) {
			if (!validUpperLetter(pass)) {
				pass[myRandom(0, pass.length - 1)] = getLetter();
			} else if (!validLoverLetter(pass)) {
				pass[myRandom(0, pass.length - 1)] = getLetter();
			} else if (!validNumber(pass)) {
				pass[myRandom(0, pass.length - 1)] = getNumber();
			} else if (!validSpecialSymbol(pass)) {
				pass[myRandom(0, pass.length - 1)] = getSpecialSymbol();
			} else {
				isValid = true;
			}
		}
	}

	static boolean validUpperLetter(char[] pass) {
		boolean b = false;
		for (int i = 0; i < pass.length; i++) {
			if ((int) pass[i] >= 65 && (int) pass[i] <= 90) {
				b = true;
			}
		}
		return b;
	}

	static boolean validLoverLetter(char[] pass) {
		boolean b = false;
		for (int i = 0; i < pass.length; i++) {
			if ((int) pass[i] >= 97 && (int) pass[i] <= 122) {
				b = true;
			}
		}
		return b;
	}

	static boolean validNumber(char[] pass) {
		boolean b = false;
		for (int i = 0; i < pass.length; i++) {
			if ((int) pass[i] >= 48 && (int) pass[i] <= 57) {
				b = true;
			}
		}
		return b;
	}

	static boolean validSpecialSymbol(char[] pass) {
		boolean b = false;
		for (int i = 0; i < pass.length; i++) {
			if ((int) pass[i] >= 35 && (int) pass[i] <= 38) {
				b = true;
			}
		}
		return b;
	}

	static void generate(char[] pass) {
		for (int i = 0; i < pass.length; i++) {
			pass[i] = getSymbol(myRandom(1, 3));
		}
	}

	static char getSymbol(int random) {
		switch (random) {
		case 1:
			return getLetter();
		case 2:
			return getNumber();
		case 3:
			return getSpecialSymbol();
		}
		return 'a';
	}

	static char getSpecialSymbol() {
		return (char) myRandom(35, 38);
	}

	static char getNumber() {
		return (char) myRandom(48, 57);
	}

	static char getLetter() {
		if (myRandom(1, 2) == 1) {
			return (char) myRandom(65, 90);
		} else {
			return (char) myRandom(97, 122);
		}
	}

	static int myRandom(int min, int max) {
		return (int) Math.round(Math.random() * (max - min) + min);
	}
}