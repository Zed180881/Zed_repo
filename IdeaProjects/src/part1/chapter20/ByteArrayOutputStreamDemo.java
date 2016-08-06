package part1.chapter20;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class ByteArrayOutputStreamDemo {
    public static void main(String[] args) {
        ByteArrayOutputStream f = new ByteArrayOutputStream();
        String s = "This data should be out to array";
        byte[] buf = s.getBytes();

        try {
            f.write(buf);
        } catch (IOException e) {
            System.out.println("Buffer write error");
            return;
        }

        System.out.println("Buffer in String");
        System.out.println(f.toString());
        System.out.println("In Array");
        byte[] b = f.toByteArray();
        for (int i = 0; i < b.length; i++) {
            System.out.print((char) b[i]);
        }
        System.out.println();
        System.out.println("In outputStream");
        try (FileOutputStream f2 = new FileOutputStream("d:/test.txt")) {
            f.writeTo(f2);
        } catch (IOException e) {
            System.out.println("IO Error");
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
