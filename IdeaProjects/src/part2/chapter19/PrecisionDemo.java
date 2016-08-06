package part1.chapter19;

import java.util.Formatter;

class PrecisionDemo {
    public static void main(String[] args) {
        Formatter fmt = new Formatter();
        fmt.format("%.4f", 123.1234567);
        System.out.println(fmt);
        fmt.close();

        fmt = new Formatter();
        fmt.format("%16.2e", 123.1234567);
        System.out.println(fmt);
        fmt.close();

        fmt = new Formatter();
        fmt.format("%.15s", "Formatting in Java is simple now.");
        System.out.println(fmt);
        fmt.close();
    }
}
