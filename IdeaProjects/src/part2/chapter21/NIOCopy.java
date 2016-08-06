package part1.chapter21;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class NIOCopy {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Use: from to");
            return;
        }
        try {
            Path source = Paths.get(args[0]);
            Path target = Paths.get(args[1]);

            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.printf("IOException %s%n", e);
        }
    }
}
