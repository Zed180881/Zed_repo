package part1.chapter18;

import java.util.Comparator;

class CompThenByFirstName implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        return o1.compareToIgnoreCase(o2);
    }
}
