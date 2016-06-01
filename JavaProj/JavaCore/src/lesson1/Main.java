package lesson1;

public class Main {

	public static void main(String[] args) {
		// String s = "Hello";
		// System.out.println(s);
		// String s1 = "Hello";
		// String s2 = new String("Hello");
		// System.out.println(s == s1);
		// System.out.println(s == s2);
		// System.out.println(s.equalsIgnoreCase(s2));
		// System.out.println(s.charAt(0));
		// System.out.println(s.codePointAt(0));
		// System.out.println(s.compareTo(s1));
		// System.out.println(s.compareToIgnoreCase(s));
		// System.out.println(s.concat(s1));
		// System.out.println(s.contains("ello"));
		// System.out.println(s.endsWith("ello"));
		// System.out.println(s.indexOf('e'));
		// System.out.println(s.indexOf("ello"));
		// System.out.println(s.indexOf("l", 3));
		// System.out.println(s.lastIndexOf("l"));
		// System.out.println(s.substring(2));
		// System.out.println(s.substring(3, 5));

		String s = "hello world!";
		System.out.println(upperCaseFirstLetter(s));

	}

	static String upperCaseFirstLetter(String str) {
		str = str.replace(str.charAt(0), Character.toUpperCase(str.charAt(0)));
		int position = str.indexOf(" ") + 1;
		while (position != 0) {
			str = str.replace(str.charAt(position),
					Character.toUpperCase(str.charAt(position)));
		}
		return str;
	}

	static String delete(String str, String ch) {

		int position = str.indexOf(ch);
		while (position != -1) {
			str = str.substring(0, position)
					+ str.substring(position + 1, str.length());
			position = str.indexOf(ch);
		}
		return str;
	}

}
