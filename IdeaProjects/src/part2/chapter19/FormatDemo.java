package part1.chapter19;

import java.util.Formatter;

class FormatDemo {
    public static void main(String[] args) {
        Formatter fmt = new Formatter();
        fmt.format("Formatting with %s is simple %d %f", "Java utils", 10, 98.6);
        System.out.println(fmt);
        fmt.close();
    }
}