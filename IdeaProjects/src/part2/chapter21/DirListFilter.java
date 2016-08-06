package part1.chapter21;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

class DirListFilter {
    public static void main(String[] args) {
        String dirName = "d:/Translation";
        DirectoryStream.Filter<Path> how = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {
                return Files.isWritable(entry);
            }
        };
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(Paths.get(dirName), how)) {
            System.out.printf("Directory %s%n", dirName);
            for (Path path : dirStream) {
                BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
                if (attributes.isDirectory())
                    System.out.printf("<DIR> %s%n", path.getName(1));
                else
                    System.out.printf("      %s%n", path.getName(1));
            }
        } catch (IOException e) {
            System.out.printf("IOException: %s%n", e);
        }
    }
}
