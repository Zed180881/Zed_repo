package part1.chapter20;

import java.io.FileInputStream;
import java.io.IOException;

class FileInputStreamDemo {
    public static void main(String[] args) {
        int size;
        try (FileInputStream f = new FileInputStream("e:/GamesToPlay.docx")) {

            System.out.println("Total bytes available: " + (size = f.available()));
            int n = size / 40;
            System.out.println("First " + n + " bytes of file readed by method read():");
            for (int i = 0; i < n; i++) {
                System.out.print((char) f.read());
            }
            System.out.println("\nYet available bytes: " + f.available());
            System.out.println("Reading next " + n + " bytes by method read(b[])");
            byte[] b = new byte[n];
            if (f.read(b) != n) {
                System.err.println("Cannot read " + n + " bytes");
            }
            System.out.println(new String(b, 0, n));
            System.out.println("\nYet available bytes: " + f.available());
            System.out.println("Skip half of available bytes by skip() method");
            f.skip(size / 2);
            System.out.println("\nYet available bytes: " + f.available());
            System.out.println("Reading " + n / 2 + " bytes in end of array");
            if (f.read(b, n / 2, n / 2) != n / 2) {
                System.err.println("Cannot read " + n / 2 + " bytes");
            }
            System.out.println(new String(b, 0, b.length));
            System.out.println("\nYet available bytes: " + f.available());
        } catch (IOException e) {
            System.out.println("Input-output error: " + e);
        }
    }
}
