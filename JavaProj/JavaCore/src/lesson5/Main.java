package lesson5;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		strings.add("A");
		strings.add("B");
		System.out.println(strings);
		strings.add(0, "C");
		strings.set(1, "C");
		System.out.println(strings);
		// strings.clear();
		strings.contains("A");
		strings.indexOf("B");
		strings.forEach((n) -> System.out.print(n + " "));
		for (String e : strings) {
			System.out.print(e + " ");
		}
		strings.removeIf((e) -> e.equals("B"));
		
	}

}
