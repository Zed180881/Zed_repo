package part1.chapter18;

import java.util.ArrayList;

class ForEachDemo {
    public static void main(String[] args) {
        ArrayList<Integer> vals = new ArrayList<>();
        vals.add(1);
        vals.add(2);
        vals.add(3);
        vals.add(4);
        vals.add(5);

        System.out.println("Start content of vals: ");
        for (Integer val : vals) {
            System.out.println(val + " ");
        }
        int sum = 0;

        for (Integer val : vals) {
            sum += val;
        }
        System.out.println("Sum of vals:" + sum);
    }
}
