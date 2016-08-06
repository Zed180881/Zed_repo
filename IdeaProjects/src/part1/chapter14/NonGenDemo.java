package part1.chapter14;

class NonGenDemo {
    public static void main(String[] args) {
        NonGen iOb;
        iOb = new NonGen(88);
        iOb.showType();

        int v = (Integer) iOb.getOb();
        System.out.println("value: " + v);
        System.out.println();

        NonGen strOb = new NonGen("NoGenerics Test");
        strOb.showType();

        String str = (String) strOb.getOb();
        System.out.println("value: " + str);
        System.out.println();

        iOb = strOb;
        v = (Integer) iOb.getOb();
    }

}
