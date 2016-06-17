package lesson7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArithmeticTest {
	
	Arithmetic ar = new Arithmetic();

	@Before
	public void initTestCase(){
		System.out.println("before test");
	}
	
	@After
	public void cleanTestCase(){
		System.out.println("After test");
	}
	
	
	@Test
	public void addTest() {
		
		int expected = 4;
		int actual = Arithmetic.add(2, 2);
		assertEquals(expected, actual);
		System.out.println("test1");
	}
	
	@Test
	public void divbyZeroTest() {
		int expected = 0;
		int actual = Arithmetic.div(2, 0);
		assertEquals(expected, actual);
		System.out.println("test2");
	}
	
	@Test
	public void divTest() {
		int expected = 2;
		int actual = Arithmetic.div(4, 2);
		assertEquals(expected, actual);
		System.out.println("test3");
	}

}
