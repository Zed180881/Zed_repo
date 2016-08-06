package part1.chapter18;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

class HTDemo2 {
    public static void main(String[] args) {
        Hashtable<String, Double> balance = new Hashtable<>();
        Enumeration<String> names;
        balance.put("John Dou", new Double(3434.34));
        balance.put("Tom Smith", new Double(123.22));
        balance.put("Jane Baker", new Double(1378.00));
        balance.put("Tod Hall", new Double(99.22));
        balance.put("Ralf Smith", new Double(-19.08));

        Set<String> set = balance.keySet();
        Iterator<String> itr = set.iterator();

        while (itr.hasNext()) {
            String str = itr.next();
            System.out.println(str + ": " + balance.get(str));
        }

        System.out.println();


        balance.put("John Dou", balance.get("John Dou") + 1000);
        System.out.println("New John Dou balance: " + balance.get("John Dou"));

    }
}
