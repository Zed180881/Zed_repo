package part1.chapter04;

/**
 * Created by Zed on 13.07.2016.
 */
class ByteShift {
    public static void main(String[] args) {
        byte a = 64, b;
        int i;

        i = a << 2;
        b = (byte) (a << 2);

        System.out.println("Первоначальное значение a: " + a);
        System.out.println("i and b: " + i + " " + b);

    }
}
