package part1.chapter18;

import java.util.Comparator;

class TComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int i, j, k;
        i = o1.lastIndexOf(" ");
        j = o2.lastIndexOf(" ");
        k = o1.substring(i).compareTo(o2.substring(j));
        if (k == 0)
            return o1.compareTo(o2);
        else
            return k;
    }
}
