package part1.chapter18;

import java.util.ArrayList;

class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        System.out.println("Start size of al: " + al.size());

        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");
        al.add(1, "A2");

        System.out.println("Size of al after add elements: " + al.size());
        System.out.println("Content of al: " + al);

        al.remove("F");
        al.remove(2);
        System.out.println("Size of al after remove elements: " + al.size());
        System.out.println("Content of al: " + al);
    }
}
