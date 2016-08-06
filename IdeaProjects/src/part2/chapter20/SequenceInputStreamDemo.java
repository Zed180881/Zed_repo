package part1.chapter20;

import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Vector;

class SequenceInputStreamDemo {
    public static void main(String[] args) {
        int c;
        Vector<String> files = new Vector<>();
        files.addElement("d:\\file1.txt");
        files.addElement("d:\\file2.txt");
        files.addElement("d:\\file3.txt");
        InputStreamEnumerator ise = new InputStreamEnumerator(files);
        try (InputStream input = new SequenceInputStream(ise)) {
            while ((c = input.read()) != -1)
                System.out.print((char) c);
        } catch (IOException | NullPointerException e) {
            System.out.println("IOException: " + e);
        }


    }
}
