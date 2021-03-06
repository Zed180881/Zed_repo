package lesson10;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lesson06.Seasons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MapTest {

    private Map<String, String> map = new HashMap<>();    
    private SeasonQupte seasonQupte = new SeasonQupte();
    private Map<String, List<String>> mapList = new HashMap<>();

    @Before
    public void init() {
	map.put("Ivan", "Manager");
	map.put("Petro", "QA");
	map.put("Mykola", "QC");
	map.put("Sergiy", "Developer");
	mapList.put("Ivan", new ArrayList<>());
	mapList.get("Ivan").add("Barsik");
	mapList.get("Ivan").add("Bobik");
	mapList.put("Petro", new ArrayList<>());
	mapList.get("Petro").add("Bobco");
	mapList.get("Petro").add("Pulka");
	mapList.put("Mykola", new ArrayList<>());
	mapList.get("Mykola").add("Bulka");
	mapList.get("Mykola").add("Srulka");
	mapList.put(null, new ArrayList<>());
	mapList.get(null).add("Tuzik");

    }

    @After
    public void clear() {
	map.clear();
    }

    @Test
    public void get() {
	String actual = map.get("Ivan");
	String expected = "Manager";
	assertEquals(expected, actual);
	assertNull(map.get("Manager"));
    }

    @Test
    public void getQuote() {
	String actual = seasonQupte.getQuote(Seasons.WINTER);
	String expected = "Winter is cold";
	assertEquals(expected, actual);
	actual = seasonQupte.getQuote(Seasons.SUMMER);
	expected = "Summer is hot";
	assertEquals(expected, actual);
    }

    @Test
    public void mapListTest() {
	List<String> petNames = new ArrayList<>();
	Iterator<Map.Entry<String, List<String>>> entryIter = mapList
		.entrySet().iterator();
	while (entryIter.hasNext()) {
	    Map.Entry<String, List<String>> entry = entryIter.next();
	    @SuppressWarnings("unused")
	    String owner = entry.getKey();
	    Iterator<String> listIter = entry.getValue().iterator();
	    while (listIter.hasNext()) {
		String petName = listIter.next();
		petNames.add(petName);
	    }
	}
	assertEquals(7, petNames.size());
	petNames.clear();

	for (Map.Entry<String, List<String>> mapEntry : mapList.entrySet()) {
	    @SuppressWarnings("unused")
	    String owner = mapEntry.getKey();
	    for (String petName : mapEntry.getValue()) {
		petNames.add(petName);
	    }
	}
	assertEquals(7, petNames.size());
	petNames.clear();

	petNames = mapList.entrySet().stream().map(Map.Entry::getValue)
		.flatMap(List::stream).collect(Collectors.toList());
	assertEquals(7, petNames.size());
	petNames.clear();	
    }

}
