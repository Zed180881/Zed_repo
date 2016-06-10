package lesson5;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Linkedlist {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.addFirst("A");
		list.addFirst("B");
		list.addLast("C");
		// list.removeFirst();
		// list.removeLast();
		System.out.println(list);

		Iterator<String> iter = list.iterator();
//		iter.hasNext();
//		iter.next();
//		iter.remove();
		while (iter.hasNext()) {
			if (iter.next().equals("A"))
				iter.remove();
		}
		System.out.println(list);
		
		ListIterator<String> listIterator = list.listIterator(list.size());
		while (listIterator.hasPrevious()){
			System.out.println(listIterator.previous());
		}
		listIterator.add("X"); //only for next
		listIterator.set("D");
		
	}
}
