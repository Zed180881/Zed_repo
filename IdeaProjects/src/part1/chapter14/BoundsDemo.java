package part1.chapter14;

class BoundsDemo {
    public static void main(String[] args) {
        Integer[] inums = {1, 2, 3, 4, 5};
        Stats<Integer> iob = new Stats<>(inums);
        double v = iob.average();
        System.out.println("Average of iob: " + v);

        Double[] dnums = {1.1, 2.2, 3.3, 4.4, 5.5};
        Stats<Double> dob = new Stats<>(dnums);
        double w = dob.average();
        System.out.println("Average of dob: " + w);

        /*String[] strs = {"1", "2", "3", "4", "5"};
        Stats<String> strob = new Stats<>(strs);
        double x = strob.average();
        System.out.println("Average of strob: " + x);*/
    }
}
