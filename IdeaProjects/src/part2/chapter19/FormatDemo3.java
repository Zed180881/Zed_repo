package part1.chapter19;

import java.util.Formatter;

class FormatDemo3 {
    public static void main(String[] args) {
        Formatter fmt = new Formatter();
        fmt.format("Copying of file%nis finished on %d%%", 88);
        System.out.println(fmt);
        fmt.close();
    }
}
