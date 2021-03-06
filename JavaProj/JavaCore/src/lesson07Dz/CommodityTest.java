package lesson07Dz;

import static org.junit.Assert.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class CommodityTest {
	
	List<Commodity> listToCheck;
	CommodityManager commodityManager;
	
	@Before
	public void initTestCase(){
		commodityManager = new CommodityManager();
		listToCheck = new ArrayList<>();		
	}	
	
	@Test
	public void commodityManagerTest() throws IOException{
		InputStream inputStream = new FileInputStream("arguments_commodity.txt");
		commodityManager.run(inputStream);
	}
	
	@Test
	public void createListTest() {
		commodityManager.fillCommodityList();
		listToCheck.add(new Commodity(1, "Kent", 150, 24.5));
		listToCheck.add(new Commodity(25, "R1", 100, 20.1));
		listToCheck.add(new Commodity(15, "LM", 200, 16.5));
		listToCheck.add(new Commodity(11, "Bond", 58, 14.35));
		listToCheck.add(new Commodity(16, "Prima", 70, 12.5));
		listToCheck.add(new Commodity(19, "Lucky Strike", 66, 16.9));
		listToCheck.add(new Commodity(2, "Davidoff", 100, 25.1));
		listToCheck.add(new Commodity(13, "Vogue", 300, 18.1));
		listToCheck.add(new Commodity(3, "Sobranie", 15, 32.3));
		listToCheck.add(new Commodity(5, "Rotmans", 89, 22.15));
		assertEquals(listToCheck, commodityManager.getCommodityList());
	}
	
	@Test
	public void addCommodityTest() {
		commodityManager.fillCommodityList();
		commodityManager.addCommodity(new Commodity(256, "Magna", 178, 66.7));
		listToCheck.add(new Commodity(1, "Kent", 150, 24.5));
		listToCheck.add(new Commodity(25, "R1", 100, 20.1));
		listToCheck.add(new Commodity(15, "LM", 200, 16.5));
		listToCheck.add(new Commodity(11, "Bond", 58, 14.35));
		listToCheck.add(new Commodity(16, "Prima", 70, 12.5));
		listToCheck.add(new Commodity(19, "Lucky Strike", 66, 16.9));
		listToCheck.add(new Commodity(2, "Davidoff", 100, 25.1));
		listToCheck.add(new Commodity(13, "Vogue", 300, 18.1));
		listToCheck.add(new Commodity(3, "Sobranie", 15, 32.3));
		listToCheck.add(new Commodity(5, "Rotmans", 89, 22.15));
		listToCheck.add(new Commodity(256, "Magna", 178, 66.7));
		assertEquals(listToCheck, commodityManager.getCommodityList());
	}
	
	@Test
	public void deleteCommodityByIdTest() {
		commodityManager.fillCommodityList();
		commodityManager.deleteCommodity(25);
		listToCheck.add(new Commodity(1, "Kent", 150, 24.5));
//		listToCheck.add(new Commodity(25, "R1", 100, 20.1));
		listToCheck.add(new Commodity(15, "LM", 200, 16.5));
		listToCheck.add(new Commodity(11, "Bond", 58, 14.35));
		listToCheck.add(new Commodity(16, "Prima", 70, 12.5));
		listToCheck.add(new Commodity(19, "Lucky Strike", 66, 16.9));
		listToCheck.add(new Commodity(2, "Davidoff", 100, 25.1));
		listToCheck.add(new Commodity(13, "Vogue", 300, 18.1));
		listToCheck.add(new Commodity(3, "Sobranie", 15, 32.3));
		listToCheck.add(new Commodity(5, "Rotmans", 89, 22.15));		
		assertEquals(listToCheck, commodityManager.getCommodityList());
	}
	
	@Test
	public void deleteCommodityByNameTest() {
		commodityManager.fillCommodityList();
		commodityManager.deleteCommodity("Kent");
//		listToCheck.add(new Commodity(1, "Kent", 150, 24.5));
		listToCheck.add(new Commodity(25, "R1", 100, 20.1));
		listToCheck.add(new Commodity(15, "LM", 200, 16.5));
		listToCheck.add(new Commodity(11, "Bond", 58, 14.35));
		listToCheck.add(new Commodity(16, "Prima", 70, 12.5));
		listToCheck.add(new Commodity(19, "Lucky Strike", 66, 16.9));
		listToCheck.add(new Commodity(2, "Davidoff", 100, 25.1));
		listToCheck.add(new Commodity(13, "Vogue", 300, 18.1));
		listToCheck.add(new Commodity(3, "Sobranie", 15, 32.3));
		listToCheck.add(new Commodity(5, "Rotmans", 89, 22.15));		
		assertEquals(listToCheck, commodityManager.getCommodityList());
	}
	
	@Test
	public void replaceCommodityTest() {
		commodityManager.fillCommodityList();
		commodityManager.replaceCommodity(15, new Commodity(15, "Magna", 178, 66.7));
		listToCheck.add(new Commodity(1, "Kent", 150, 24.5));
		listToCheck.add(new Commodity(25, "R1", 100, 20.1));
		listToCheck.add(new Commodity(15, "Magna", 178, 66.7));
		listToCheck.add(new Commodity(11, "Bond", 58, 14.35));
		listToCheck.add(new Commodity(16, "Prima", 70, 12.5));
		listToCheck.add(new Commodity(19, "Lucky Strike", 66, 16.9));
		listToCheck.add(new Commodity(2, "Davidoff", 100, 25.1));
		listToCheck.add(new Commodity(13, "Vogue", 300, 18.1));
		listToCheck.add(new Commodity(3, "Sobranie", 15, 32.3));
		listToCheck.add(new Commodity(5, "Rotmans", 89, 22.15));		
		assertEquals(listToCheck, commodityManager.getCommodityList());
	}
	
	@Test
	public void  sortByIdTest() {
		commodityManager.fillCommodityList();
		commodityManager.sortById(false);
		listToCheck.add(new Commodity(1, "Kent", 150, 24.5));
		listToCheck.add(new Commodity(2, "Davidoff", 100, 25.1));
		listToCheck.add(new Commodity(3, "Sobranie", 15, 32.3));
		listToCheck.add(new Commodity(5, "Rotmans", 89, 22.15));
		listToCheck.add(new Commodity(11, "Bond", 58, 14.35));
		listToCheck.add(new Commodity(13, "Vogue", 300, 18.1));
		listToCheck.add(new Commodity(15, "LM", 200, 16.5));
		listToCheck.add(new Commodity(16, "Prima", 70, 12.5));
		listToCheck.add(new Commodity(19, "Lucky Strike", 66, 16.9));
		listToCheck.add(new Commodity(25, "R1", 100, 20.1));		
		assertEquals(listToCheck, commodityManager.getCommodityList());
	}
	
	@Test
	public void  sortByIdReverseTest() {
		commodityManager.fillCommodityList();
		commodityManager.sortById(true);
		listToCheck.add(new Commodity(25, "R1", 100, 20.1));
		listToCheck.add(new Commodity(19, "Lucky Strike", 66, 16.9));
		listToCheck.add(new Commodity(16, "Prima", 70, 12.5));
		listToCheck.add(new Commodity(15, "LM", 200, 16.5));
		listToCheck.add(new Commodity(13, "Vogue", 300, 18.1));
		listToCheck.add(new Commodity(11, "Bond", 58, 14.35));		
		listToCheck.add(new Commodity(5, "Rotmans", 89, 22.15));
		listToCheck.add(new Commodity(3, "Sobranie", 15, 32.3));
		listToCheck.add(new Commodity(2, "Davidoff", 100, 25.1));
		listToCheck.add(new Commodity(1, "Kent", 150, 24.5));		
		assertEquals(listToCheck, commodityManager.getCommodityList());
	}
	
	@Test
	public void  sortByNameTest() {
		commodityManager.fillCommodityList();
		commodityManager.sortByName(false);
		listToCheck.add(new Commodity(11, "Bond", 58, 14.35));
		listToCheck.add(new Commodity(2, "Davidoff", 100, 25.1));
		listToCheck.add(new Commodity(1, "Kent", 150, 24.5));
		listToCheck.add(new Commodity(15, "LM", 200, 16.5));
		listToCheck.add(new Commodity(19, "Lucky Strike", 66, 16.9));
		listToCheck.add(new Commodity(16, "Prima", 70, 12.5));
		listToCheck.add(new Commodity(25, "R1", 100, 20.1));
		listToCheck.add(new Commodity(5, "Rotmans", 89, 22.15));
		listToCheck.add(new Commodity(3, "Sobranie", 15, 32.3));
		listToCheck.add(new Commodity(13, "Vogue", 300, 18.1));		
		assertEquals(listToCheck, commodityManager.getCommodityList());
	}
	
	@Test
	public void  sortByNameReverseTest() {
		commodityManager.fillCommodityList();
		commodityManager.sortByName(true);
		listToCheck.add(new Commodity(13, "Vogue", 300, 18.1));
		listToCheck.add(new Commodity(3, "Sobranie", 15, 32.3));
		listToCheck.add(new Commodity(5, "Rotmans", 89, 22.15));
		listToCheck.add(new Commodity(25, "R1", 100, 20.1));
		listToCheck.add(new Commodity(16, "Prima", 70, 12.5));
		listToCheck.add(new Commodity(19, "Lucky Strike", 66, 16.9));
		listToCheck.add(new Commodity(15, "LM", 200, 16.5));
		listToCheck.add(new Commodity(1, "Kent", 150, 24.5));
		listToCheck.add(new Commodity(2, "Davidoff", 100, 25.1));		
		listToCheck.add(new Commodity(11, "Bond", 58, 14.35));		
		assertEquals(listToCheck, commodityManager.getCommodityList());
	}
	
	@Test
	public void  sortByQuantityTest() {
		commodityManager.fillCommodityList();
		commodityManager.sortByQuantity(false);
		listToCheck.add(new Commodity(3, "Sobranie", 15, 32.3));
		listToCheck.add(new Commodity(11, "Bond", 58, 14.35));	
		listToCheck.add(new Commodity(19, "Lucky Strike", 66, 16.9));
		listToCheck.add(new Commodity(16, "Prima", 70, 12.5));
		listToCheck.add(new Commodity(5, "Rotmans", 89, 22.15));
		listToCheck.add(new Commodity(25, "R1", 100, 20.1));
		listToCheck.add(new Commodity(2, "Davidoff", 100, 25.1));
		listToCheck.add(new Commodity(1, "Kent", 150, 24.5));
		listToCheck.add(new Commodity(15, "LM", 200, 16.5));
		listToCheck.add(new Commodity(13, "Vogue", 300, 18.1));	
		assertEquals(listToCheck, commodityManager.getCommodityList());
	}
	
	@Test
	public void  sortByQuantityReverseTest() {
		commodityManager.fillCommodityList();
		commodityManager.sortByQuantity(true);
		listToCheck.add(new Commodity(13, "Vogue", 300, 18.1));	
		listToCheck.add(new Commodity(15, "LM", 200, 16.5));
		listToCheck.add(new Commodity(1, "Kent", 150, 24.5));		
		listToCheck.add(new Commodity(25, "R1", 100, 20.1));
		listToCheck.add(new Commodity(2, "Davidoff", 100, 25.1));
		listToCheck.add(new Commodity(5, "Rotmans", 89, 22.15));
		listToCheck.add(new Commodity(16, "Prima", 70, 12.5));
		listToCheck.add(new Commodity(19, "Lucky Strike", 66, 16.9));
		listToCheck.add(new Commodity(11, "Bond", 58, 14.35));			
		listToCheck.add(new Commodity(3, "Sobranie", 15, 32.3));
		assertEquals(listToCheck, commodityManager.getCommodityList());
	}
	
	@Test
	public void  sortByPriceTest() {
		commodityManager.fillCommodityList();
		commodityManager.sortByPrice(false);
		listToCheck.add(new Commodity(16, "Prima", 70, 12.5));
		listToCheck.add(new Commodity(11, "Bond", 58, 14.35));
		listToCheck.add(new Commodity(15, "LM", 200, 16.5));
		listToCheck.add(new Commodity(19, "Lucky Strike", 66, 16.9));
		listToCheck.add(new Commodity(13, "Vogue", 300, 18.1));	
		listToCheck.add(new Commodity(25, "R1", 100, 20.1));
		listToCheck.add(new Commodity(5, "Rotmans", 89, 22.15));
		listToCheck.add(new Commodity(1, "Kent", 150, 24.5));
		listToCheck.add(new Commodity(2, "Davidoff", 100, 25.1));
		listToCheck.add(new Commodity(3, "Sobranie", 15, 32.3));
		assertEquals(listToCheck, commodityManager.getCommodityList());
	}
	
	@Test
	public void  sortByPriceReverseTest() {
		commodityManager.fillCommodityList();
		commodityManager.sortByPrice(true);
		listToCheck.add(new Commodity(3, "Sobranie", 15, 32.3));
		listToCheck.add(new Commodity(2, "Davidoff", 100, 25.1));
		listToCheck.add(new Commodity(1, "Kent", 150, 24.5));
		listToCheck.add(new Commodity(5, "Rotmans", 89, 22.15));
		listToCheck.add(new Commodity(25, "R1", 100, 20.1));
		listToCheck.add(new Commodity(13, "Vogue", 300, 18.1));
		listToCheck.add(new Commodity(19, "Lucky Strike", 66, 16.9));
		listToCheck.add(new Commodity(15, "LM", 200, 16.5));
		listToCheck.add(new Commodity(11, "Bond", 58, 14.35));
		listToCheck.add(new Commodity(16, "Prima", 70, 12.5));
		assertEquals(listToCheck, commodityManager.getCommodityList());
	}
	
	@Test
	public void commoditySettersTest(){
		Commodity comToTest = new Commodity(13, "Vogue", 300, 18.1);
		Commodity comToCheck = new Commodity(25, "R1", 258, 12.56);
		comToTest.setId(25);
		comToTest.setName("R1");
		comToTest.setQuantity(258);
		comToTest.setPrice(12.56);
		assertEquals(comToCheck, comToTest);
	}
	
	@Test
	public void commodityHashCodeTest(){
		Commodity comToTest = new Commodity(13, "Vogue", 300, 18.1);
		Commodity comToCheck = new Commodity(13, "Vogue", 300, 18.1);
		assertEquals(comToCheck.hashCode(), comToTest.hashCode());
		comToTest = new Commodity(13, null, 300, 18.1);
		comToCheck = new Commodity(13, null, 300, 18.1);
		assertEquals(comToCheck.hashCode(), comToTest.hashCode());
	}
	
	@Test
	public void commodityEqualsTest(){
		Commodity c1 = new Commodity(13, "Vogue", 300, 18.1);
		Commodity c2 = c1;
		assertTrue(c1.equals(c2));
		c2 = null;
		assertFalse(c1.equals(c2));
		assertFalse(c1.equals("string"));
		c1 = new Commodity(13, null, 300, 18.1);
		c2 = new Commodity(13, "Vogue", 300, 18.1);
		assertFalse(c1.equals(c2));
		c2.setName(null);
		assertTrue(c1.equals(c2));
		c1 = new Commodity(13, "R1", 300, 18.1);
		c2 = new Commodity(13, "Vogue", 300, 18.1);
		assertFalse(c1.equals(c2));
		c1 = new Commodity(13, "Vogue", 301, 18.1);
		c2 = new Commodity(13, "Vogue", 300, 18.1);
		assertFalse(c1.equals(c2));
		c1 = new Commodity(13, "Vogue", 300, 19.1);
		c2 = new Commodity(13, "Vogue", 300, 18.1);
		assertFalse(c1.equals(c2));
	}
}
