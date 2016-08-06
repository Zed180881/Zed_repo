package part1.chapter20;

import java.io.*;

class CharArrayWriterDemo {
    public static void main(String[] args) {
        CharArrayWriter f = new CharArrayWriter();
        String s = "This data should be out to array";
        char[] buf = new char[s.length()];
        s.getChars(0, s.length(), buf, 0);

        try {
            f.write(buf);
        } catch (IOException e) {
            System.out.println("Buffer write error");
            return;
        }

        System.out.println("Buffer in String");
        System.out.println(f.toString());
        System.out.println("In Array");
        char[] c = f.toCharArray();
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
        }
        System.out.println();
        System.out.println("In outputStream of FileWriter type");
        try (FileWriter f2 = new FileWriter("d:/test.txt")) {
            f.writeTo(f2);
        } catch (IOException e) {
            System.out.println("IO Error: " + e);
            return;
        }
        System.out.println("In start position");
        f.reset();
        for (int i = 0; i < 3; i++) {
            f.write('X');
        }
        System.out.println(f.toString());
    }
}
