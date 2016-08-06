package part1.chapter13;

class MyClass {
    int a;
    int b;

    public MyClass(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public MyClass(int a) {
        this(a, a);
    }

    public MyClass() {
        this(0);
    }
}
