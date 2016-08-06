package part1.chapter18;

import java.util.Enumeration;
import java.util.Vector;

class VectorDemo {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>(3, 2);
        System.out.println("Start size of vector: " + v.size());
        System.out.println("Start capacity of vector: " + v.capacity());

        v.addElement(1);
        v.addElement(2);
        v.addElement(3);
        v.addElement(4);

        System.out.println("Capacity of vector after adding four elements: " + v.capacity());
        v.addElement(5);
        System.out.println("Current capacity of vector: " + v.capacity());

        v.addElement(6);
        v.addElement(7);
        System.out.println("Current capacity of vector: " + v.capacity());

        v.addElement(9);
        v.addElement(10);
        System.out.println("Current capacity of vector: " + v.capacity());

        v.addElement(11);
        v.addElement(12);

        System.out.println("First Element: " + v.firstElement());
        System.out.println("Last Element: " + v.lastElement());
        if (v.contains(3))
            System.out.println("Vactor contains 3");

        Enumeration<Integer> vEnum = v.elements();
        System.out.println("Vector elements:");
        while (vEnum.hasMoreElements())
            System.out.print(vEnum.nextElement() + " ");
        System.out.println();


    }
}
