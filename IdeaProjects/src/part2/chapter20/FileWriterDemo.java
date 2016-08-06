package part1.chapter20;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

class FileWriterDemo {
    public static void main(String[] args) {
        String source = "Now is the time for all good men\n" +
                "to come to the aid of their country\n" +
                "and pay their due taxes.";
        char[] buffer = new char[source.length()];
        source.getChars(0, source.length(), buffer, 0);

        try (FileWriter f0 = new FileWriter("d:/test1.txt");
             FileWriter f1 = new FileWriter("d:/test2.txt");
             FileWriter f2 = new FileWriter("d:/test3.txt")) {
            for (int i = 0; i < buffer.length; i += 2) {
                f0.write(buffer[i]);
            }
            f1.write(buffer);

            f2.write(buffer, buffer.length - buffer.length / 4, buffer.length / 4);
        } catch (IOException e) {
            System.out.println("Input-Output error");
        }
    }
}
