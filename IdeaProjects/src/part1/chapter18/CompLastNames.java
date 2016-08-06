package part1.chapter18;

import java.util.Comparator;

class CompLastNames implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.substring(o1.lastIndexOf(' ')).compareToIgnoreCase(o2.substring(o2.lastIndexOf(' ')));
    }
}
