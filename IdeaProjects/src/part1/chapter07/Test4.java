package part1.chapter07;

/**
 * Created by Zed on 19.07.2016.1
 */
class Test4 {
    int a;

    public Test4(int a) {
        this.a = a;
    }

    Test4 incrByTen() {
        return new Test4(a + 10);
    }
}
