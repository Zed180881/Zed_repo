package part1.chapter18;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

class AlgorithmsDemo {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(-8);
        ll.add(20);
        ll.add(-20);
        ll.add(8);

        Comparator<Integer> r = Collections.reverseOrder();
        Collections.sort(ll, r);
        System.out.print("Reverse order sorted list: ");
        for (Integer integer : ll) {
            System.out.print(integer + " ");
        }
        System.out.println();

        Collections.shuffle(ll);
        System.out.print("List shuffled: ");
        for (Integer integer : ll) {
            System.out.print(integer + " ");
        }
        System.out.println();

        System.out.println("Minimum: " + Collections.min(ll));
        System.out.println("Maximum: " + Collections.max(ll));
    }
}
