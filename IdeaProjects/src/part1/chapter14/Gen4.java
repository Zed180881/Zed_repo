package part1.chapter14;

class Gen4 extends Gen<String> {

    Gen4(String ob) {
        super(ob);
    }

    @Override
    String getOb() {
        System.out.print("Method String getOb() called: ");
        return ob;
    }
}
