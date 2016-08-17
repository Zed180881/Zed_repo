package part2.chapter29;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

class StreamDemo10 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Alpha");
        myList.add("Beta");
        myList.add("Gamma");
        myList.add("Delta");
        myList.add("Xi");
        myList.add("Omega");

        Stream<String> myStream = myList.stream();
        Spliterator<String> splitItr = myStream.spliterator();
        Spliterator<String> splitItr2 = splitItr.trySplit();
        if (splitItr2 != null) {
            System.out.println("Spliterator2 result:");
            splitItr2.forEachRemaining(n -> System.out.println(n));
        }
        System.out.println("Spliterator1 result:");
        splitItr.forEachRemaining(n -> System.out.println(n));
    }
}
