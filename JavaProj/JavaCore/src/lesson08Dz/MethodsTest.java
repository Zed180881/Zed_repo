package lesson08Dz;

import static org.junit.Assert.*;

import org.junit.Test;

public class MethodsTest {

	@Test
	public void methodTest() throws Exception {
		Methods methods = new Methods();
		methods.hashCode();
		assertEquals(Methods.add(25, -2), 23, 1e-15);
		assertEquals(Methods.substr(25, -2), 27, 1e-15);
		assertEquals(Methods.multipl(25, -2), -50, 1e-15);
		assertEquals(Methods.div(25, -2), -12.5, 1e-15);
		assertEquals(Methods.add(-25, 2), -23, 1e-15);
		assertEquals(Methods.substr(-25, 2), -27, 1e-15);
		assertEquals(Methods.multipl(-25, 2), -50, 1e-15);
		assertEquals(Methods.div(-25, 2), -12.5, 1e-15);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void IllegalArgumentExceptionTest() throws Exception {		
		try{
		    Methods.add(-25, -2);
		}
		catch (IllegalArgumentException e){
		    e.printStackTrace();
		}	
	   		
	}
	
	@Test(expected = ArithmeticException.class)
	public void ArithmeticExceptionTest1() throws Exception {		
		Methods.add(0, -2);		
	}
	
	@Test(expected = ArithmeticException.class)
	public void ArithmeticExceptionTest2() throws Exception {		
		Methods.add(2, 0);		
	}
	
	@Test(expected = IllegalAccessException.class)
	public void IllegalAccessExceptionTest() throws Exception {		
		Methods.add(0, 0);		
	}
	
	@Test(expected = MyException.class)
	public void MyExceptionTest() throws Exception {		
		Methods.add(1, 1);		
	}
}
