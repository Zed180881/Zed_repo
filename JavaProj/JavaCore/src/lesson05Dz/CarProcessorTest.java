package lesson05Dz;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarProcessorTest {
	
	List<Car> carsToTest;
	List<Car> carsToCheck;
	CarProcessor carProcessor;
	Set<Car> carsSetToTest;
	Set<Car> carsSetToCheck;
	
	@Before
	public void initTestCase(){
		carProcessor = new CarProcessor();
		carsToTest = new ArrayList<>();
		carsToCheck = new ArrayList<>();
		carsToTest.add(new Car("Mazda", "black", "sedan", 21, "winter", 15, true));
		carsToTest.add(new Car("Mazda", "red", "cupe", 19, "summer", 16, false));
		carsToTest.add(new Car("BMW", "metallic", "cabrio", 21, "demiseason", 17, true));
		carsToTest.add(new Car("BMW", "white", "sedan", 19, "winter", 18, true));
		carsToTest.add(new Car("Toyota", "red", "cupe", 17, "summer", 15, true));
		carsToTest.add(new Car("Toyota", "silver", "universal", 22, "winter", 18, true));
		carsToTest.add(new Car("Lada", "purple", "hatchback", 16, "winter", 20, false));
		carsToTest.add(new Car("Lada", "red", "sedan", 16, "summer", 16, false));
		carsToTest.add(new Car("Ford", "red", "cupe", 19, "demiseason", 16, true));
		carsToTest.add(new Car("Ford", "grey", "sedan", 21, "winter", 15, true));
		carsSetToTest = new LinkedHashSet<>();
		carsSetToCheck = new LinkedHashSet<>();
		carsSetToTest.add(new Car("Mazda", "black", "sedan", 21, "winter", 15, true));
		carsSetToTest.add(new Car("Mazda", "red", "cupe", 19, "summer", 16, false));
		carsSetToTest.add(new Car("BMW", "metallic", "cabrio", 21, "demiseason", 17, true));
		carsSetToTest.add(new Car("BMW", "white", "sedan", 19, "winter", 18, true));
		carsSetToTest.add(new Car("Toyota", "red", "cupe", 17, "summer", 15, true));
		carsSetToTest.add(new Car("Toyota", "silver", "universal", 22, "winter", 18, true));
		carsSetToTest.add(new Car("Lada", "purple", "hatchback", 16, "winter", 20, false));
		carsSetToTest.add(new Car("Lada", "red", "sedan", 16, "summer", 16, false));
		carsSetToTest.add(new Car("Ford", "red", "cupe", 19, "demiseason", 16, true));
		carsSetToTest.add(new Car("Ford", "grey", "sedan", 21, "winter", 15, true));
	}
	
	@Test
	public void carProcessorTest() throws IOException{
		InputStream inputStream = new FileInputStream("arguments.txt");
		carProcessor.processCars(inputStream);
	}
	
	@Test
	public void carSetDeleteByWheelsDiameterTest(){		
		Set<Car> deleteResult = carProcessor.carSetDeleteByWheelsDiameter(carsSetToTest, 20, 21);		
//		carsSetToCheck.add(new Car("Mazda", "black", "sedan", 21, "winter", 15, true));
		carsSetToCheck.add(new Car("Mazda", "red", "cupe", 19, "summer", 16, false));
//		carsSetToCheck.add(new Car("BMW", "metallic", "cabrio", 21, "demiseason", 17, true));
		carsSetToCheck.add(new Car("BMW", "white", "sedan", 19, "winter", 18, true));
		carsSetToCheck.add(new Car("Toyota", "red", "cupe", 17, "summer", 15, true));
		carsSetToCheck.add(new Car("Toyota", "silver", "universal", 22, "winter", 18, true));
		carsSetToCheck.add(new Car("Lada", "purple", "hatchback", 16, "winter", 20, false));
		carsSetToCheck.add(new Car("Lada", "red", "sedan", 16, "summer", 16, false));
		carsSetToCheck.add(new Car("Ford", "red", "cupe", 19, "demiseason", 16, true));
//		carsSetToCheck.add(new Car("Ford", "grey", "sedan", 21, "winter", 15, true));;
		assertEquals(carsSetToCheck, deleteResult);
	}
	
	@Test
	public void carSetReplaceTyresTest(){		
		carProcessor.carSetReplaceTyres(carsSetToTest, "red", 17, 17, "demiseason");		
		carsSetToCheck.add(new Car("Mazda", "black", "sedan", 21, "winter", 15, true));
		carsSetToCheck.add(new Car("Mazda", "red", "cupe", 19, "summer", 16, false));
		carsSetToCheck.add(new Car("BMW", "metallic", "cabrio", 21, "demiseason", 17, true));
		carsSetToCheck.add(new Car("BMW", "white", "sedan", 19, "winter", 18, true));
		carsSetToCheck.add(new Car("Toyota", "red", "cupe", 17, "demiseason", 15, true));
		carsSetToCheck.add(new Car("Toyota", "silver", "universal", 22, "winter", 18, true));
		carsSetToCheck.add(new Car("Lada", "purple", "hatchback", 16, "winter", 20, false));
		carsSetToCheck.add(new Car("Lada", "red", "sedan", 16, "summer", 16, false));
		carsSetToCheck.add(new Car("Ford", "red", "cupe", 19, "demiseason", 16, true));
		carsSetToCheck.add(new Car("Ford", "grey", "sedan", 21, "winter", 15, true));;
		assertEquals(carsSetToCheck, carsSetToTest);
	}
	
	@Test
	public void carSearchByTyreTypeAndWheelDiameterTest(){		
		Set<Car> searchResult = carProcessor.carSearchByTyreTypeAndWheelDiameter(carsSetToTest, "winter", 20, 21);		
		carsSetToCheck.add(new Car("Mazda", "black", "sedan", 21, "winter", 15, true));
//		carsSetToCheck.add(new Car("Mazda", "red", "cupe", 19, "summer", 16, false));
//		carsSetToCheck.add(new Car("BMW", "metallic", "cabrio", 21, "demiseason", 17, true));
//		carsSetToCheck.add(new Car("BMW", "white", "sedan", 19, "winter", 18, true));
//		carsSetToCheck.add(new Car("Toyota", "red", "cupe", 17, "summer", 15, true));
//		carsSetToCheck.add(new Car("Toyota", "silver", "universal", 22, "winter", 18, true));
//		carsSetToCheck.add(new Car("Lada", "purple", "hatchback", 16, "winter", 20, false));
//		carsSetToCheck.add(new Car("Lada", "red", "sedan", 16, "summer", 16, false));
//		carsSetToCheck.add(new Car("Ford", "red", "cupe", 19, "demiseason", 16, true));
		carsSetToCheck.add(new Car("Ford", "grey", "sedan", 21, "winter", 15, true));;
		assertEquals(carsSetToCheck, searchResult);
	}
	
	@Test
	public void carSearchByWheelDiameterTest(){		
		List<Car> searchResult = carProcessor.carSearchByWheelDiameter(carsToTest, 19);		
//		carsToCheck.add(new Car("Mazda", "black", "sedan", 21, "winter", 15, true));
		carsToCheck.add(new Car("Mazda", "red", "cupe", 19, "summer", 16, false));
//		carsToCheck.add(new Car("BMW", "metallic", "cabrio", 21, "demiseason", 17, true));
		carsToCheck.add(new Car("BMW", "white", "sedan", 19, "winter", 18, true));
//		carsToCheck.add(new Car("Toyota", "red", "cupe", 17, "summer", 15, true));
//		carsToCheck.add(new Car("Toyota", "silver", "universal", 22, "winter", 18, true));
//		carsToCheck.add(new Car("Lada", "purple", "hatchback", 16, "winter", 20, false));
//		carsToCheck.add(new Car("Lada", "red", "sedan", 16, "summer", 16, false));
		carsToCheck.add(new Car("Ford", "red", "cupe", 19, "demiseason", 16, true));
//		carsToCheck.add(new Car("Ford", "grey", "sedan", 21, "winter", 15, true));;
		assertEquals(carsToCheck, searchResult);
	}
	
	@Test
	public void carSearchByWheelDiameterAndBodyColorTest(){		
		List<Car> searchResult = carProcessor.carSearchByWheelDiameterAndBodyColor(carsToTest, 19, "red");		
//		carsToCheck.add(new Car("Mazda", "black", "sedan", 21, "winter", 15, true));
		carsToCheck.add(new Car("Mazda", "red", "cupe", 19, "summer", 16, false));
//		carsToCheck.add(new Car("BMW", "metallic", "cabrio", 21, "demiseason", 17, true));
//		carsToCheck.add(new Car("BMW", "white", "sedan", 19, "winter", 18, true));
//		carsToCheck.add(new Car("Toyota", "red", "cupe", 17, "summer", 15, true));
//		carsToCheck.add(new Car("Toyota", "silver", "universal", 22, "winter", 18, true));
//		carsToCheck.add(new Car("Lada", "purple", "hatchback", 16, "winter", 20, false));
//		carsToCheck.add(new Car("Lada", "red", "sedan", 16, "summer", 16, false));
		carsToCheck.add(new Car("Ford", "red", "cupe", 19, "demiseason", 16, true));
//		carsToCheck.add(new Car("Ford", "grey", "sedan", 21, "winter", 15, true));;
		assertEquals(carsToCheck, searchResult);
	}
	
	@Test
	public void carReplaceRedCarSteeringWheelTest1(){		
		carProcessor.carReplaceRedCarSteeringWheel(carsToTest, 1);		
		carsToCheck.add(new Car("Mazda", "black", "sedan", 21, "winter", 15, true));
		carsToCheck.add(new Car("Mazda", "red", "cupe", 19, "summer", 16, true));
		carsToCheck.add(new Car("BMW", "metallic", "cabrio", 21, "demiseason", 17, true));
		carsToCheck.add(new Car("BMW", "white", "sedan", 19, "winter", 18, true));
		carsToCheck.add(new Car("Toyota", "red", "cupe", 17, "summer", 15, true));
		carsToCheck.add(new Car("Toyota", "silver", "universal", 22, "winter", 18, true));
		carsToCheck.add(new Car("Lada", "purple", "hatchback", 16, "winter", 20, false));
		carsToCheck.add(new Car("Lada", "red", "sedan", 16, "summer", 16, true));
		carsToCheck.add(new Car("Ford", "red", "cupe", 19, "demiseason", 16, true));
		carsToCheck.add(new Car("Ford", "grey", "sedan", 21, "winter", 15, true));;
		assertEquals(carsToCheck, carsToTest);
	}
	
	@Test
	public void carReplaceRedCarSteeringWheelTest2(){		
		carProcessor.carReplaceRedCarSteeringWheel(carsToTest, 0);		
		carsToCheck.add(new Car("Mazda", "black", "sedan", 21, "winter", 15, true));
		carsToCheck.add(new Car("Mazda", "red", "cupe", 19, "summer", 16, false));
		carsToCheck.add(new Car("BMW", "metallic", "cabrio", 21, "demiseason", 17, true));
		carsToCheck.add(new Car("BMW", "white", "sedan", 19, "winter", 18, true));
		carsToCheck.add(new Car("Toyota", "red", "cupe", 17, "summer", 15, false));
		carsToCheck.add(new Car("Toyota", "silver", "universal", 22, "winter", 18, true));
		carsToCheck.add(new Car("Lada", "purple", "hatchback", 16, "winter", 20, false));
		carsToCheck.add(new Car("Lada", "red", "sedan", 16, "summer", 16, false));
		carsToCheck.add(new Car("Ford", "red", "cupe", 19, "demiseason", 16, false));
		carsToCheck.add(new Car("Ford", "grey", "sedan", 21, "winter", 15, true));;
		assertEquals(carsToCheck, carsToTest);
	}
	
	@Test
	public void carIncreaseWheelsDiameterTest(){
		carProcessor.carIncreaseWheelsDiameter(carsToTest);
		carsToCheck.add(new Car("Mazda", "black", "sedan", 42, "winter", 15, true));
		carsToCheck.add(new Car("Mazda", "red", "cupe", 19, "summer", 16, false));
		carsToCheck.add(new Car("BMW", "metallic", "cabrio", 42, "demiseason", 17, true));
		carsToCheck.add(new Car("BMW", "white", "sedan", 38, "winter", 18, true));
		carsToCheck.add(new Car("Toyota", "red", "cupe", 34, "summer", 15, true));
		carsToCheck.add(new Car("Toyota", "silver", "universal", 44, "winter", 18, true));
		carsToCheck.add(new Car("Lada", "purple", "hatchback", 16, "winter", 20, false));
		carsToCheck.add(new Car("Lada", "red", "sedan", 16, "summer", 16, false));
		carsToCheck.add(new Car("Ford", "red", "cupe", 38, "demiseason", 16, true));
		carsToCheck.add(new Car("Ford", "grey", "sedan", 42, "winter", 15, true));;
		assertEquals(carsToCheck, carsToTest);
	}
	
	@Test
	public void carReplaceCarsByWheelDiameterTest(){		
		carProcessor.carReplaceCarsByWheelDiameter(carsToTest, 19);		
		carsToCheck.add(new Car("Mazda", "black", "sedan", 21, "winter", 15, true));
		carsToCheck.add(new Car("Mazda", "red", "cupe", 19, "summer", 16, false));
		carsToCheck.add(new Car("BMW", "metallic", "cabrio", 21, "demiseason", 17, true));
		carsToCheck.add(new Car("BMW", "white", "sedan", 19, "winter", 18, true));
		carsToCheck.add(new Car());
		carsToCheck.add(new Car("Toyota", "silver", "universal", 22, "winter", 18, true));
		carsToCheck.add(new Car());
		carsToCheck.add(new Car());
		carsToCheck.add(new Car("Ford", "red", "cupe", 19, "demiseason", 16, true));
		carsToCheck.add(new Car("Ford", "grey", "sedan", 21, "winter", 15, true));;
		assertEquals(carsToCheck, carsToTest);
	}
	
	@Test
	public void carSearchByBodyTypeTest(){		
		List<Car> searchResult = carProcessor.carSearchByBodyType(carsToTest, "sedan");		
		carsToCheck.add(new Car("Mazda", "black", "sedan", 21, "winter", 15, true));
//		carsToCheck.add(new Car("Mazda", "red", "cupe", 19, "summer", 16, false));
//		carsToCheck.add(new Car("BMW", "metallic", "cabrio", 21, "demiseason", 17, true));
		carsToCheck.add(new Car("BMW", "white", "sedan", 19, "winter", 18, true));
//		carsToCheck.add(new Car("Toyota", "red", "cupe", 17, "summer", 15, true));
//		carsToCheck.add(new Car("Toyota", "silver", "universal", 22, "winter", 18, true));
//		carsToCheck.add(new Car("Lada", "purple", "hatchback", 16, "winter", 20, false));
		carsToCheck.add(new Car("Lada", "red", "sedan", 16, "summer", 16, false));
//		carsToCheck.add(new Car("Ford", "red", "cupe", 19, "demiseason", 16, true));
		carsToCheck.add(new Car("Ford", "grey", "sedan", 21, "winter", 15, true));;
		assertEquals(carsToCheck, searchResult);
	}
	
	@Test
	public void carDeleteByBodyColorTest(){		
		List<Car> deleteResult = carProcessor.carDeleteByBodyColor(carsToTest, "red");		
		carsToCheck.add(new Car("Mazda", "black", "sedan", 21, "winter", 15, true));
//		carsToCheck.add(new Car("Mazda", "red", "cupe", 19, "summer", 16, false));
		carsToCheck.add(new Car("BMW", "metallic", "cabrio", 21, "demiseason", 17, true));
		carsToCheck.add(new Car("BMW", "white", "sedan", 19, "winter", 18, true));
//		carsToCheck.add(new Car("Toyota", "red", "cupe", 17, "summer", 15, true));
		carsToCheck.add(new Car("Toyota", "silver", "universal", 22, "winter", 18, true));
		carsToCheck.add(new Car("Lada", "purple", "hatchback", 16, "winter", 20, false));
//		carsToCheck.add(new Car("Lada", "red", "sedan", 16, "summer", 16, false));
//		carsToCheck.add(new Car("Ford", "red", "cupe", 19, "demiseason", 16, true));
		carsToCheck.add(new Car("Ford", "grey", "sedan", 21, "winter", 15, true));;
		assertEquals(carsToCheck, deleteResult);
	}
	
	@Test
	public void carReplaceTyresTest(){		
		carProcessor.carReplaceTyres(carsToTest, 17, 19);		
		carsToCheck.add(new Car("Mazda", "black", "sedan", 21, "winter", 15, true));
		carsToCheck.add(new Car("Mazda", "red", "cupe", 19, "winter", 16, false));
		carsToCheck.add(new Car("BMW", "metallic", "cabrio", 21, "demiseason", 17, true));
		carsToCheck.add(new Car("BMW", "white", "sedan", 19, "winter", 18, true));
		carsToCheck.add(new Car("Toyota", "red", "cupe", 17, "winter", 15, true));
		carsToCheck.add(new Car("Toyota", "silver", "universal", 22, "winter", 18, true));
		carsToCheck.add(new Car("Lada", "purple", "hatchback", 16, "winter", 20, false));
		carsToCheck.add(new Car("Lada", "red", "sedan", 16, "summer", 16, false));
		carsToCheck.add(new Car("Ford", "red", "cupe", 19, "winter", 16, true));
		carsToCheck.add(new Car("Ford", "grey", "sedan", 21, "winter", 15, true));;
		assertEquals(carsToCheck, carsToTest);
	}
	
	@Test
	public void carDeleteByBodyTypeAndSteeringWheelDiameterTest(){		
		List<Car> deleteResult = carProcessor.carDeleteByBodyTypeAndSteeringWheelDiameter(carsToTest, "sedan", 16, 16);		
		carsToCheck.add(new Car("Mazda", "black", "sedan", 21, "winter", 15, true));
		carsToCheck.add(new Car("Mazda", "red", "cupe", 19, "summer", 16, false));
		carsToCheck.add(new Car("BMW", "metallic", "cabrio", 21, "demiseason", 17, true));
		carsToCheck.add(new Car("BMW", "white", "sedan", 19, "winter", 18, true));
		carsToCheck.add(new Car("Toyota", "red", "cupe", 17, "summer", 15, true));
		carsToCheck.add(new Car("Toyota", "silver", "universal", 22, "winter", 18, true));
		carsToCheck.add(new Car("Lada", "purple", "hatchback", 16, "winter", 20, false));
//		carsToCheck.add(new Car("Lada", "red", "sedan", 16, "summer", 16, false));
		carsToCheck.add(new Car("Ford", "red", "cupe", 19, "demiseason", 16, true));
		carsToCheck.add(new Car("Ford", "grey", "sedan", 21, "winter", 15, true));;
		assertEquals(carsToCheck, deleteResult);
	}
	
	@Test
	public void carIndexSearchByBodyTypeTest(){		
		List<Integer> searchResult = carProcessor.carIndexSearchByBodyType(carsToTest, "sedan");		
		List<Integer> indexToCheck = new ArrayList<Integer>();
		indexToCheck.add(0);
		indexToCheck.add(3);
		indexToCheck.add(7);
		indexToCheck.add(9);
		assertEquals(indexToCheck, searchResult);
	}
	
	@Test
	public void createCarProcessorTest() {		
		CarProcessor carProcessor = new CarProcessor();
		assertEquals(carsToTest, carProcessor.cars);
		assertEquals(carsSetToTest, carProcessor.carsSet);
		assertEquals(Wheel.Position.BACK_LEFT, Wheel.Position.valueOf("BACK_LEFT"));		
	}	
	
// Car Classes tests
	@Test
	public void createDefCarTest() {		
		Car car = new Car();
		assertEquals("BMW", car.getModel());
		assertEquals("sedan", car.getBodyType());
		assertEquals(15, car.getSteeringWheelDiameter());
		assertEquals(false, car.isSteeringWheelHasButtons());
		assertEquals(19, car.getWheelsDiameter());
		assertEquals("demiseasons", car.getTyreType());
	}

	@Test
	public void settersCarTest() {		
		Car car = new Car();
		car.setBodyType("cupe");
		car.setColor("red");
		car.setModel("Audi");
		car.setSteeringWheelDiameter(20);
		car.setSteeringWheelHasButtons(true);
		car.setTyreType("winter");
		car.setWheelsDiameter(25);
		assertEquals("Audi", car.getModel());
		assertEquals("cupe", car.getBodyType());
		assertEquals(20, car.getSteeringWheelDiameter());
		assertEquals(true, car.isSteeringWheelHasButtons());
		assertEquals(25, car.getWheelsDiameter());
		assertEquals("winter", car.getTyreType());
		Wheel wheel = new Wheel(Wheel.Position.FRONT_LEFT, 20, "summer");
		assertEquals(Wheel.Position.FRONT_LEFT, wheel.getWheelPosition());
		wheel.setWheelPosition(Wheel.Position.BACK_LEFT);
		assertEquals(Wheel.Position.BACK_LEFT, wheel.getWheelPosition());
	}

	@Test
	public void carToStringTest() {		
		Car car = new Car("Mazda", "black", "sedan", 21, "winter", 15, true);
		assertEquals(
				"Модель: Mazda, тип кузова - sedan, колір - black, діаметер коліс - 21, тип резини - winter, діаметер керма - 15, кермо з кнопками.",
				car.toString());
		car = new Car("Mazda", "black", "sedan", 21, "winter", 15, false);
		assertEquals(
				"Модель: Mazda, тип кузова - sedan, колір - black, діаметер коліс - 21, тип резини - winter, діаметер керма - 15, кермо без кнопок.",
				car.toString());
	}
	
	@Test
	public void hashCodeTest(){
		Wheel wheel1 = new Wheel(Wheel.Position.FRONT_LEFT, 19, "winter");
		Wheel wheel2 = new Wheel(Wheel.Position.FRONT_LEFT, 19, "winter");		
		assertEquals(wheel1.hashCode(), wheel2.hashCode());
		wheel1 = new Wheel(null, 19,"winter");
		wheel2 = new Wheel(null, 19,"winter");
		assertEquals(wheel1.hashCode(), wheel2.hashCode());
		wheel1 = new Wheel(Wheel.Position.FRONT_LEFT, 19,	null);
		wheel2 = new Wheel(Wheel.Position.FRONT_LEFT, 19,	null);
		assertEquals(wheel1.hashCode(), wheel2.hashCode());		
		Wheels wheels1 = new Wheels();
		Wheels wheels2 = new Wheels();
		assertEquals(wheels1.hashCode(), wheels2.hashCode());
		wheels1.spareWheel=null;
		wheels2.spareWheel=null;
		assertEquals(wheels1.hashCode(), wheels2.hashCode());
		wheels1.wheelBackLeft=null;
		wheels2.wheelBackLeft=null;
		assertEquals(wheels1.hashCode(), wheels2.hashCode());
		wheels1.wheelBackRight=null;
		wheels2.wheelBackRight=null;
		assertEquals(wheels1.hashCode(), wheels2.hashCode());
		wheels1.wheelFrontLeft=null;
		wheels2.wheelFrontLeft=null;
		assertEquals(wheels1.hashCode(), wheels2.hashCode());
		wheels1.wheelFrontRight=null;
		wheels2.wheelFrontRight=null;
		assertEquals(wheels1.hashCode(), wheels2.hashCode());
		Body body1 = new Body();
		Body body2 = new Body();
		assertEquals(body1.hashCode(), body2.hashCode());
		body1 = new Body(null, "sedan");
		body2 = new Body(null, "sedan");
		assertEquals(body1.hashCode(), body2.hashCode());
		body1 = new Body("red", null);
		body2 = new Body("red", null);
		assertEquals(body1.hashCode(), body2.hashCode());
		SteeringWheel steeringWheel1 = new SteeringWheel(15, true);
		SteeringWheel steeringWheel2 = new SteeringWheel(15, true);
		assertEquals(steeringWheel1.hashCode(), steeringWheel2.hashCode());
		steeringWheel1 = new SteeringWheel(16, false);
		steeringWheel2 = new SteeringWheel(16, false);
		assertEquals(steeringWheel1.hashCode(), steeringWheel2.hashCode());
		Car car1 = new Car();
		Car car2 = new Car();
		assertEquals(car1.hashCode(), car2.hashCode());
		car1.body = null;
		car2.body = null;
		assertEquals(car1.hashCode(), car2.hashCode());
		car1.steeringWheel = null;
		car2.steeringWheel = null;
		assertEquals(car1.hashCode(), car2.hashCode());
		car1.wheels = null;
		car2.wheels = null;
		assertEquals(car1.hashCode(), car2.hashCode());
		car1.setModel(null);
		car2.setModel(null);
		assertEquals(car1.hashCode(), car2.hashCode());		
	}
	
	@Test
	public void equalsWheelTest(){
		Wheel wheel1 = new Wheel(Wheel.Position.FRONT_LEFT, 19, "winter");
		Wheel wheel2 = new Wheel(Wheel.Position.FRONT_LEFT, 19, "winter");
		assertTrue(wheel1.equals(wheel2));		
		wheel1 = wheel2;
		assertTrue(wheel1.equals(wheel2));
		wheel2 = null;
		assertFalse(wheel1.equals(wheel2));
		assertFalse(wheel1.equals(new Body()));
		wheel1 = new Wheel(null, 19, "winter");
		wheel2 = new Wheel(Wheel.Position.FRONT_LEFT, 19, "winter");
		assertFalse(wheel1.equals(wheel2));
		wheel1 = new Wheel(null, 19, "winter");
		wheel2 = new Wheel(null, 19, "winter");
		assertTrue(wheel1.equals(wheel2));
		wheel1 = new Wheel(Wheel.Position.FRONT_RIGHT, 19, "winter");
		wheel2 = new Wheel(Wheel.Position.FRONT_LEFT, 19, "winter");
		assertFalse(wheel1.equals(wheel2));
		wheel1 = new Wheel(Wheel.Position.FRONT_RIGHT, 21, "winter");
		wheel2 = new Wheel(Wheel.Position.FRONT_RIGHT, 19, "winter");
		assertFalse(wheel1.equals(wheel2));
		wheel1 = new Wheel(Wheel.Position.FRONT_RIGHT, 19, "summer");
		wheel2 = new Wheel(Wheel.Position.FRONT_RIGHT, 19, "winter");
		assertFalse(wheel1.equals(wheel2));
		wheel1 = new Wheel(Wheel.Position.FRONT_RIGHT, 19, null);
		wheel2 = new Wheel(Wheel.Position.FRONT_RIGHT, 19, "winter");
		assertFalse(wheel1.equals(wheel2));
		wheel1 = new Wheel(Wheel.Position.FRONT_RIGHT, 19, null);
		wheel2 = new Wheel(Wheel.Position.FRONT_RIGHT, 19, null);
		assertTrue(wheel1.equals(wheel2));		
	}
	
	@Test
	public void equalsWheelsTest(){
		Wheels wheels1 = new Wheels();
		Wheels wheels2 = new Wheels();
		assertTrue(wheels1.equals(wheels2));		
		wheels1 = wheels2;
		assertTrue(wheels1.equals(wheels2));
		wheels2 = null;
		assertFalse(wheels1.equals(wheels2));
		assertFalse(wheels1.equals(new Body()));
		wheels1 = new Wheels();
		wheels2 = new Wheels();
		wheels2.spareWheel=null;
		assertFalse(wheels1.equals(wheels2));
		wheels1.spareWheel=null;
		assertTrue(wheels1.equals(wheels2));
		wheels2.wheelBackLeft=null;
		assertFalse(wheels1.equals(wheels2));
		wheels1.wheelBackLeft=null;
		assertTrue(wheels1.equals(wheels2));
		wheels2.wheelBackRight=null;
		assertFalse(wheels1.equals(wheels2));
		wheels1.wheelBackRight=null;
		assertTrue(wheels1.equals(wheels2));
		wheels2.wheelFrontLeft=null;
		assertFalse(wheels1.equals(wheels2));
		wheels1.wheelFrontLeft=null;
		assertTrue(wheels1.equals(wheels2));
		wheels2.wheelFrontRight=null;
		assertFalse(wheels1.equals(wheels2));
		wheels1.wheelFrontRight=null;
		assertTrue(wheels1.equals(wheels2));
		wheels1 = new Wheels();
		wheels2 = new Wheels();
		wheels1.spareWheel=null;
		assertFalse(wheels1.equals(wheels2));
		wheels2.spareWheel=null;
		assertTrue(wheels1.equals(wheels2));
		wheels1.wheelBackLeft=null;
		assertFalse(wheels1.equals(wheels2));
		wheels2.wheelBackLeft=null;
		assertTrue(wheels1.equals(wheels2));
		wheels1.wheelBackRight=null;
		assertFalse(wheels1.equals(wheels2));
		wheels2.wheelBackRight=null;
		assertTrue(wheels1.equals(wheels2));
		wheels1.wheelFrontLeft=null;
		assertFalse(wheels1.equals(wheels2));
		wheels2.wheelFrontLeft=null;
		assertTrue(wheels1.equals(wheels2));
		wheels1.wheelFrontRight=null;
		assertFalse(wheels1.equals(wheels2));
		wheels2.wheelFrontRight=null;
		assertTrue(wheels1.equals(wheels2));		
	}
	
	@Test
	public void equalsBodyTest(){
		Body body1 = new Body("red","sedan");
		Body body2 = new Body("red","sedan");
		assertTrue(body1.equals(body2));		
		body1 = body2;
		assertTrue(body1.equals(body2));
		body2 = null;
		assertFalse(body1.equals(body2));
		assertFalse(body1.equals(new SteeringWheel()));
		body1 = new Body (null, "sedan");
		body2 = new Body("red", "sedan");
		assertFalse(body1.equals(body2));
		body1 = new Body (null, "sedan");
		body2 = new Body (null, "sedan");
		assertTrue(body1.equals(body2));
		body1 = new Body("red", "sedan");
		body2 = new Body("black", "sedan");
		assertFalse(body1.equals(body2));		
		body1 = new Body("red", "cupe");
		body2 = new Body("red", "sedan");
		assertFalse(body1.equals(body2));
		body1 = new Body("red", null);
		body2 = new Body("red", "sedan");
		assertFalse(body1.equals(body2));
		body1 = new Body("red", null);
		body2 = new Body("red", null);
		assertTrue(body1.equals(body2));		
	}
	
	@Test
	public void equalsSteeringWheelTest(){
		SteeringWheel sw1 = new SteeringWheel(20, true);
		SteeringWheel sw2 = new SteeringWheel(20, true);
		assertTrue(sw1.equals(sw2));		
		sw1 = sw2;
		assertTrue(sw1.equals(sw2));
		sw2 = null;
		assertFalse(sw1.equals(sw2));
		assertFalse(sw1.equals(new Body()));
		sw1 = new SteeringWheel(20, true);
		sw2 = new SteeringWheel(21, true);
		assertFalse(sw1.equals(sw2));
		sw1 = new SteeringWheel(20, false);
		sw2 = new SteeringWheel(20, true);
		assertFalse(sw1.equals(sw2));
		sw1 = new SteeringWheel(20, true);
		sw2 = new SteeringWheel(20, false);
		assertFalse(sw1.equals(sw2));
		sw1 = new SteeringWheel(20, true);
		sw2 = new SteeringWheel(20, true);
		assertTrue(sw1.equals(sw2));		
	}
	
	@Test
	public void equalsCarTest(){
		Car car1 = new Car();
		Car car2 = new Car();
		assertTrue(car1.equals(car2));		
		car1 = car2;
		assertTrue(car1.equals(car2));
		car2 = null;
		assertFalse(car1.equals(car2));
		assertFalse(car1.equals(new Body()));
		car1 = new Car();
		car2 = new Car();
		car1.body = null;
		assertFalse(car1.equals(car2));
		car2.body = null;
		assertTrue(car1.equals(car2));
		car1.setModel(null);
		assertFalse(car1.equals(car2));
		car2.setModel(null);
		assertTrue(car1.equals(car2));
		car1.steeringWheel = null;
		assertFalse(car1.equals(car2));
		car2.steeringWheel = null;
		assertTrue(car1.equals(car2));
		car1.wheels = null;
		assertFalse(car1.equals(car2));
		car2.wheels = null;
		assertTrue(car1.equals(car2));
		car1 = new Car();
		car2 = new Car();
		car1.setBodyType(null);
		assertFalse(car1.equals(car2));
		car1 = new Car();
		car1.setSteeringWheelDiameter(0);
		assertFalse(car1.equals(car2));
		car1 = new Car();
		car1.setTyreType(null);
		assertFalse(car1.equals(car2));		
	}

}
