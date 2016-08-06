package part1.chapter21;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class DirTreeList {
    public static void main(String[] args) {
        String dirname = "d:/Translation";
        System.out.printf("Directory tree begin from directory %s:%n", dirname);
        try {
            Files.walkFileTree(Paths.get(dirname), new MyFileVisitor());
        } catch (IOException e) {
            System.out.printf("IOException: %s%n", e);
        }
    }
}
