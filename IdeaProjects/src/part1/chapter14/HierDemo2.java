package part1.chapter14;

class HierDemo2 {
    public static void main(String[] args) {
        Gen3<String> w = new Gen3<>(47, "Welcome");
        System.out.println(w.getOb());
        System.out.println(w.getNum());
    }
}
