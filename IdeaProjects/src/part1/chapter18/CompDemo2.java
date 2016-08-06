package part1.chapter18;

import java.util.TreeSet;

class CompDemo2 {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>((o1, o2) -> o2.compareTo(o1));

        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");

        for (String t : ts) {
            System.out.print(t + " ");
        }
        System.out.println();

        TreeSet<String> tsr = new TreeSet<>(new MyComp().reversed());
        tsr.addAll(ts);

        for (String s : tsr) {
            System.out.print(s + " ");
        }
    }
}
