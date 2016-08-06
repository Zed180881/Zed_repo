package part1.chapter14;

class OverrideDemo {
    public static void main(String[] args) {
        Gen<Integer> iOb = new Gen<>(88);
        Gen2<Integer, Integer> iOb2 = new Gen2<>(99);
        Gen2<String, Integer> strOb2 = new Gen2<>("Generics test");

        System.out.println(iOb.getOb());
        System.out.println(iOb2.getOb());
        System.out.println(strOb2.getOb());

    }
}
