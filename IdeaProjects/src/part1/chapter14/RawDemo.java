package part1.chapter14;

class RawDemo {
    public static void main(String[] args) {
        Gen<Integer> iOb = new Gen<>(88);
        Gen<String> strOb = new Gen<>("Generics test");

        Gen raw = new Gen(new Double(98.6));

        double d = (Double) raw.getOb();
        System.out.println("Value: " + d);

//        int i = (Integer) raw.getOb();
        strOb = raw;
//        String str = strOb.getOb();
        raw = iOb;
//        d = (Double) raw.getOb();
    }
}
