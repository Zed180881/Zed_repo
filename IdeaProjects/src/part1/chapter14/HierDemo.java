package part1.chapter14;

class HierDemo {
    public static void main(String[] args) {
        Gen2<String, Integer> x = new Gen2<>("Value is: ", 99);
        System.out.println(x.getOb());
        System.out.println(x.getOb2());
    }
}
