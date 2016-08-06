package part1.chapter07;

/**
 * Created by Zed on 19.07.2016.
 */
class UseStatic {
    static int a = 3;
    static int b;

    static void meth(int x) {
        System.out.println("x = " + x);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    static {
        System.out.println("static initialization block");
        b = a * 4;
    }

    public static void main(String[] args) {
        meth(42);
    }
}
