package part1.chapter21;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

class NIOStreamWrite {
    public static void main(String[] args) {
        try (OutputStream fout = new BufferedOutputStream(Files.newOutputStream(Paths.get("d:/test.txt")))) {
            for (int i = 0; i < 26; i++) {
                fout.write((byte) ('A' + i));
            }
        } catch (IOException e) {
            System.out.printf("IOException %s%n", e);
        }
    }
}
