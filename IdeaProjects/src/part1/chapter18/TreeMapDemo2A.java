package part1.chapter18;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class TreeMapDemo2A {
    public static void main(String[] args) {
//        CompLastNames compLN = new CompLastNames();
        Comparator<String> compLN = (o1, o2) -> o1.substring(o1.lastIndexOf(' ')).compareToIgnoreCase(o2.substring(o2.lastIndexOf(' ')));
        Comparator<String> compLastThenFirst = compLN.thenComparing((o1, o2) -> o1.compareTo(o2));

        TreeMap<String, Double> tm = new TreeMap<>(compLastThenFirst); //250 uah
        tm.put("John Dou", new Double(3434.34));
        tm.put("Tom Smith", new Double(123.22));
        tm.put("Jane Baker", new Double(1378.00));
        tm.put("Tod Hall", new Double(99.22));
        tm.put("Ralf Smith", new Double(-19.08));

        Set<Map.Entry<String, Double>> set = tm.entrySet();
        for (Map.Entry<String, Double> me : set) {
            System.out.println(me.getKey() + ": " + me.getValue());
        }
        System.out.println();
        tm.put("John Dou", tm.get("John Dou") + 1000);
        System.out.println("New John Dou balance: " + tm.get("John Dou"));

    }
}
