package lesson09;

import static org.junit.Assert.*;

import java.util.Iterator;

import lesson09.Shop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ShopTest {

    private final Shop shop = new Shop();

    @Before
    public void init() {
	shop.init();
    }

    @After
    public void clear() {
	shop.clear();
    }

    @Test
    public void initTest() {
	assertEquals(9, shop.size());
    }

    @Test
    public void addTest() {
	Item testItem = new Item("TestItem", new Manufacturer(
		"TestManufacturer", "TestCountry"), 100.0, 60,
		Category.valueOf("INDUSTRY"));
	shop.addItem("TestItem", "TestManufacturer", "TestCountry", 100.0, 60,
		"INDUSTRY");
	assertEquals(10, shop.size());
	assertTrue(shop.getItems().contains(testItem));
    }

    @Test
    public void sellItemtest() {
	shop.sellItem("Iphone", 3);
	assertEquals(9, shop.size());
	shop.sellItem("Iphone", 7);
	assertEquals(8, shop.size());
	shop.sellItem("Galaxy", 30);
	assertEquals(8, shop.size());
    }

    @Test
    public void sortByPriceTest() {
	shop.sortByPrice();
	Iterator<Item> iter = shop.getItems().iterator();
	Item first = iter.next();
	while (iter.hasNext()) {
	    Item second = iter.next();
	    boolean test = (first.getPrice() * 100) - (second.getPrice() * 100) <= 0;
	    assertTrue(test);
	    first = second;
	}
    }

    @Test
    public void increasePriceTest() {
	double expected = 0;
	for (Item item : shop.getItems()) {
	    if (item.getCategory()==Category.ALCHEMY)
		expected = expected + item.getPrice();
	}
	expected = expected *120/100;		
	shop.increase("ALCHEMY", 20);
	double actual = 0;
	for (Item item : shop.getItems()) {
	    if (item.getCategory()==Category.ALCHEMY)
		actual = actual + item.getPrice();
	}
	assertEquals(expected, actual, 1e-15);
    }

}
