package part1.chapter14;

class NonGen {
    Object ob;

    NonGen(Object ob) {
        this.ob = ob;
    }

    Object getOb() {
        return ob;
    }

    void showType() {
        System.out.println("Type of object ob: " + ob.getClass().getName());
    }
}
