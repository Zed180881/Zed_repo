package part1.chapter20;

import java.io.FileReader;
import java.io.IOException;

class FileReaderDemo {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("d:/test.txt")) {
            int c;
            while ((c = fr.read()) != -1)
                System.out.print((char) c);
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
    }
}
