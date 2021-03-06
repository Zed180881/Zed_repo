package lesson08;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SetTest {

	private Set<Person> set = new TreeSet<Person>(new PersonComparator());

	@Before
	public void init() {
		set.add(new Person("Ivan", 15));
		set.add(new Person("Vitaliy", 20));
		set.add(new Person("Petro", 18));
		set.add(new Person("Ivan", 50));
	}

	@After
	public void clear() {
		set.clear();

	}

	@Test
	public void sizeTest() {
		int actual = set.size();
		System.out.println(set);
		assertEquals(4, actual);
	}

	@Test
	public void compareTest() {
		Comparator<Person> comparator = new PersonComparator();
		Person p1 = new Person("Ivan", 18);
		Person p2 = new Person("Petro", 18);
		boolean result = comparator.compare(p1, p2) > 0;
		boolean reverse = comparator.compare(p2, p1) > 0;
		assertTrue(result);
		assertFalse(reverse);
		Comparable<Person> comparable = (Comparable<Person>) p1;
		assertTrue(comparable.compareTo(p2) < 0);
	}

	@Test
	public void sort() {
		List<String> list = new ArrayList<>(Arrays.asList("D", "R", "Q", "A", "U"));
		System.out.println(list);
		list.sort(null);
		System.out.println(list);
		list.sort((o1, o2) -> {
			return o2.compareTo(o1);
		});
		System.out.println(list);
	}

}
