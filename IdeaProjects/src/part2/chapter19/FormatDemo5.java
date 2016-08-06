package part1.chapter19;

import java.util.Formatter;

class FormatDemo5 {
    public static void main(String[] args) {
        Formatter fmt = new Formatter();

        fmt = new Formatter();
        fmt.format("% d", -100);
        System.out.println(fmt);
        fmt.close();

        fmt = new Formatter();
        fmt.format("% d", 100);
        System.out.println(fmt);
        fmt.close();

        fmt = new Formatter();
        fmt.format("% d", -200);
        System.out.println(fmt);
        fmt.close();

        fmt = new Formatter();
        fmt.format("% d", 200);
        System.out.println(fmt);
        fmt.close();

        fmt = new Formatter();
        fmt.format("%,.2f", 435165489.26);
        System.out.println(fmt);
        fmt.close();
    }
}
