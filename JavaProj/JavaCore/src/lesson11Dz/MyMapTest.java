package lesson11Dz;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyMapTest {

    private MyMap<String, String> map = new MyMap<String, String>();

    @Before
    public void init() {
	map.add(new MyEntry<String, String>("1", "one"));
	map.add(new MyEntry<String, String>("2", "two"));
	map.add(new MyEntry<String, String>("3", "three"));
	map.add(new MyEntry<String, String>("4", "four"));
	map.add(new MyEntry<String, String>("5", "five"));
    }

    @After
    public void clear() {
	map = new MyMap<String, String>();
    }

    @Test
    public void addTest() {
	assertFalse(map.getMapSet().contains(
		new MyEntry<String, String>("6", "six")));
	map.add(new MyEntry<String, String>("6", "six"));
	assertTrue(map.getMapSet().contains(
		new MyEntry<String, String>("6", "six")));
	assertEquals(6, map.getMapSet().size());
    }

    @Test
    public void deleteByKeyTest() {
	assertTrue(map.getMapSet().contains(
		new MyEntry<String, String>("5", "five")));
	map.deleteByKey("5");
	assertFalse(map.getMapSet().contains(
		new MyEntry<String, String>("5", "five")));
	assertEquals(4, map.getMapSet().size());
    }

    @Test
    public void deleteByValueTest() {
	assertTrue(map.getMapSet().contains(
		new MyEntry<String, String>("5", "five")));
	map.deleteByValue("five");
	assertFalse(map.getMapSet().contains(
		new MyEntry<String, String>("5", "five")));
	map.printMap();
	assertEquals(5, map.getMapSet().size());
    }

    @Test
    public void getKeySetTest() {
	Set<String> keySet = map.getKeySet();
	assertTrue(keySet.contains("1"));
	assertTrue(keySet.contains("2"));
	assertTrue(keySet.contains("3"));
	assertTrue(keySet.contains("4"));
	assertTrue(keySet.contains("5"));
	assertEquals(5, keySet.size());
    }
    
    @Test
    public void getValueListTest() {
	List<String> keyList = map.getValueList();
	assertTrue(keyList.contains("one"));
	assertTrue(keyList.contains("two"));
	assertTrue(keyList.contains("three"));
	assertTrue(keyList.contains("four"));
	assertTrue(keyList.contains("five"));
	assertEquals(5, keyList.size());
    }

}
