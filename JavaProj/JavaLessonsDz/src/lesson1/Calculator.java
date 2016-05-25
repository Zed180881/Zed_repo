package lesson1;

public class Calculator {

	public static String calc(int firstVariable, int secondVariable,
			char operationType) {
		switch (operationType) {
		case '+':
			return String.valueOf(firstVariable + secondVariable);
		case '-':
			return String.valueOf(firstVariable - secondVariable);
		case '*':
			return String.valueOf(firstVariable * secondVariable);
		case '/':
			return String.valueOf((double) firstVariable / secondVariable);
		default:
			return "Unknown operation type";
		}
	}

	public static void main(String[] args) {

		char operationType = '+';
		int firstVariable = 8;
		int secondVariable = 3;
		System.out.println(calc(firstVariable, secondVariable, operationType));

		// через if

		// if (operationType == '+') {
		// System.out.println(firstVariable + secondVariable);
		// } else if (operationType == '-') {
		// System.out.println(firstVariable - secondVariable);
		// } else if (operationType == '*') {
		// System.out.println(firstVariable * secondVariable);
		// } else if (operationType == '/') {
		// System.out.println(firstVariable / secondVariable);
		// } else {
		// System.out.println("Unknown operation type");
		// }

		// через switch

		// switch (operationType) {
		// case '+': {
		// System.out.println(firstVariable + secondVariable);
		// break;
		// }
		// case '-': {
		// System.out.println(firstVariable - secondVariable);
		// break;
		// }
		// case '*': {
		// System.out.println(firstVariable * secondVariable);
		// break;
		// }
		// case '/': {
		// System.out.println((double) firstVariable / secondVariable);
		// break;
		// }
		// default: {
		// System.out.println("Unknown operation type");
		// break;
		// }
		// }

	}

}
