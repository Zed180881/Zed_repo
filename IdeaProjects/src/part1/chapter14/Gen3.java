package part1.chapter14;

class Gen3<T> extends NonGen1 {
    T ob;

    Gen3(int num, T ob) {
        super(num);
        this.ob = ob;
    }

    T getOb() {
        return ob;
    }
}
