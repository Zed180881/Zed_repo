package part1.chapter18;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, Double> hm = new HashMap<>(); //250 uah
        hm.put("John Dou", new Double(3434.34));
        hm.put("Tom Smith", new Double(123.22));
        hm.put("Jane Baker", new Double(1378.00));
        hm.put("Tod Hall", new Double(99.22));
        hm.put("Ralf Smith", new Double(-19.08));

        Set<Map.Entry<String, Double>> set = hm.entrySet();
        for (Map.Entry<String, Double> me : set) {
            System.out.println(me.getKey() + ": " + me.getValue());
        }
        System.out.println();
        hm.put("John Dou", hm.get("John Dou") + 1000);
        System.out.println("New John Dou balance: " + hm.get("John Dou"));

    }
}
