package part1.chapter13;

public class NativeDemo {
    int i;

    public static void main(String[] args) {
        NativeDemo ob = new NativeDemo();

        ob.i = 10;

        System.out.println("Value of i before native method calling: " + ob.i);
        ob.test();
        System.out.println("Value of i after native method calling: " + ob.i);
    }

    public native void test();

    static {
        System.loadLibrary("NativeDemo");
    }
}
