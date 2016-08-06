package part1.chapter18;

import java.util.LinkedList;

class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();
        ll.add("F");
        ll.add("B");
        ll.add("D");
        ll.add("E");
        ll.add("C");
        ll.addLast("Z");
        ll.addFirst("A");
        ll.add(1, "A2");

        System.out.println("Start content of ll: " + ll);

        ll.remove("F");
        ll.remove(2);
        System.out.println("Content of ll after remove: " + ll);

        ll.removeFirst();
        ll.removeLast();

        System.out.println("Content of ll after remove first and last: " + ll);

        String val = ll.get(2);
        ll.set(2, val + " changed");

        System.out.println("Content of ll after change: " + ll);
    }
}
