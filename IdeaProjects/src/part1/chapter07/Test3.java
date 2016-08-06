package part1.chapter07;

/**
 * Created by Zed on 19.07.2016.1
 */
class Test3 {
    int a, b;

    Test3(int a, int b) {
        this.a = a;
        this.b = b;
    }

    void method(Test3 o) {
        o.a *= 2;
        o.b /= 2;
    }
}
