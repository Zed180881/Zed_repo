package part1.chapter19;

import java.util.Formatter;

class FormatDemo1 {
    public static void main(String[] args) {
        try (Formatter fmt = new Formatter()) {
            fmt.format("Formatting with %s is simple %d %f", "Java utils", 10, 98.6);
            System.out.println(fmt);
        }
    }
}
