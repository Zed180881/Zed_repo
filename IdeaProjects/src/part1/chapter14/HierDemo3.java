package part1.chapter14;

class HierDemo3 {
    public static void main(String[] args) {
        Gen<Integer> iOb = new Gen<>(88);
        Gen2<Integer, String> iOb2 = new Gen2<>(99);
        Gen2<String, String> strOb2 = new Gen2<String, String>("Generics test");

        if (iOb2 instanceof Gen2<?, ?>)
            System.out.println("iOb2 is instance of Gen2");
        if (iOb2 instanceof Gen<?>)
            System.out.println("iOb2 is instance of Gen");
        System.out.println();

        if (strOb2 instanceof Gen2<?, ?>)
            System.out.println("strOb2 is instance of Gen2");
        if (strOb2 instanceof Gen<?>)
            System.out.println("strOb2 is instance of Gen");
        System.out.println();

        if (iOb instanceof Gen2<?, ?>)
            System.out.println("iOb is instance of Gen2");
        if (iOb instanceof Gen<?>)
            System.out.println("iOb is instance of Gen");

//        if (iOb2 instanceof Gen2<Integer, String>)
//            System.out.println("iOb2 is instance of Gen2");
    }
}
