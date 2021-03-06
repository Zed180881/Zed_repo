package lesson10Dz;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CollectionTest {

    private static final int TEST_SIZE = 10;
    private Collection collection = new Collection(TEST_SIZE);
    private List<Object> outputList = new ArrayList<Object>();

    @Before
    public void init() {
	for (int i = 0; i < collection.getObjectArray().length; i++) {
	    collection.getObjectArray()[i] = i;
	}
    }

    @After
    public void clear() {
	collection = new Collection(TEST_SIZE);
	outputList.clear();
    }

    @Test
    public void iteratorFirstTest() {
	System.out.println("First iterator test");
	Collection.FirstIterator iterator = collection.new FirstIterator();
	while (iterator.hasNext()) {
	    Object o = iterator.next();
	    outputList.add(o);
	    System.out.println(o);
	}
	for (int i = 1; i < outputList.size(); i = i + 2) {
	    assertEquals(0, outputList.get(i));
	}
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void iteratorFirstExceptionTest() {
	Collection.FirstIterator iterator = collection.new FirstIterator();
	while (true) {
	    Object o = iterator.next();
	    outputList.add(o);
	}
    }

    @Test
    public void iteratorSecondTest() {
	System.out.println("Second iterator test");
	Collection.SecondIterator iterator = collection.new SecondIterator();
	while (iterator.hasNext()) {
	    Object o = iterator.next();
	    outputList.add(o);
	    System.out.println(o);
	}
	assertEquals(TEST_SIZE / 2, outputList.size());
	assertEquals(
		collection.getObjectArray()[collection.getObjectArray().length - 1],
		outputList.get(0));
	assertEquals(collection.getObjectArray()[1],
		outputList.get(outputList.size() - 1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void iteratorSecondExceptionTest() {
	Collection.SecondIterator iterator = collection.new SecondIterator();
	while (true) {
	    Object o = iterator.next();
	    outputList.add(o);
	}
    }

    @Test
    public void iteratorAnonimousTest() {
	System.out.println("Anonimous iterator test");
	Iterator iterator = new Iterator() {

	    int cursor = collection.getObjectArray().length - 1;

	    @Override
	    public boolean hasNext() {
		return cursor > -1;
	    }

	    @Override
	    public Object next() {
		int i = cursor;
		cursor = i - 3;
		if (i % 2 != 0)
		    return collection.getObjectArray()[i];
		return null;
	    }
	};

	while (iterator.hasNext()) {
	    Object o = iterator.next();
	    if (o == null)
		continue;
	    outputList.add(o);
	    System.out.println(o);
	}
	assertEquals(
		collection.getObjectArray()[collection.getObjectArray().length - 1],
		outputList.get(0));
	assertEquals(collection.getObjectArray()[3], outputList.get(1));
    }

    @Test
    public void iteratorLocalTest() {
	System.out.println("Local iterator test");
	outputList = collection.localIterator();
	assertEquals(-100, outputList.get(0));
    }

    @Test
    public void iteratorStaticTest() {
	System.out.println("Static iterator test");
	Collection.StaticIterator iterator = new Collection.StaticIterator();
	while (iterator.hasNext()) {
	    Object o = iterator.next();
	    outputList.add(o);
	    System.out.println(o);
	}
	for (int i = 1; i < outputList.size(); i++) {
	    assertEquals(1, (Integer) outputList.get(i) % 2);
	}
    }

}
