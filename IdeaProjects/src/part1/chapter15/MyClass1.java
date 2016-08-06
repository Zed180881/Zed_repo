package part1.chapter15;

class MyClass1<T> {
    private T val;

    MyClass1(T val) {
        this.val = val;
    }

    public MyClass1() {
        this.val = null;
    }

    T getVal() {
        return val;
    }
}
