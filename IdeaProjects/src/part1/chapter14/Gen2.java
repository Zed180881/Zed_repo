package part1.chapter14;

class Gen2<T, V> extends Gen<T> {
    V ob2;

    public Gen2(T ob) {
        super(ob);
    }

    public Gen2(T ob, V ob2) {
        super(ob);
        this.ob2 = ob2;
    }

    @Override
    T getOb() {
        System.out.print("Method getOb() from Gen2 class: ");
        return ob;
    }

    V getOb2() {
        return ob2;
    }
}
