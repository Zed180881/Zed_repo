package part1.chapter14;

class Gen5<T extends Number> {
    T ob;

    T[] vals;

    public Gen5(T ob, T[] vals) {
        this.ob = ob;
//        this.vals = new T[10];
        this.vals = vals;
    }
}
