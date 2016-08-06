package part1.chapter07;

/**
 * Created by Zed on 19.07.2016.1
 */
class Test {
    private int a, b;

    Test(int a, int b) {
        this.a = a;
        this.b = b;
    }

    boolean equals(Test o) {
        return (o.a == a && o.b == b);
    }

}
