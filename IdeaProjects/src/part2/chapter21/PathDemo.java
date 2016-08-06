package part1.chapter21;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

class PathDemo {
    public static void main(String[] args) {
        Path filepath = Paths.get("d:/Translation/test.txt");
        System.out.printf("File name: %s%n", filepath.getName(1));
        System.out.printf("File path: %s%n", filepath);
        System.out.printf("Absolute file path: %s%n", filepath.toAbsolutePath());
        System.out.printf("Parent folder: %s%n", filepath.getParent());

        if (Files.exists(filepath))
            System.out.println("File exists");
        else
            System.out.println("File not exists");

        try {
            if (Files.isHidden(filepath))
                System.out.println("File is hidden");
            else
                System.out.println("File is not hidden");
        } catch (IOException e) {
            System.out.printf("IOException %s%n", e);
        }
        if (Files.isWritable(filepath))
            System.out.println("File is Writable");
        else
            System.out.println("File is not writable");
        if (Files.isReadable(filepath))
            System.out.println("File is Readable");
        else
            System.out.println("File is not Readable");
        try {
            BasicFileAttributes attributes = Files.readAttributes(filepath, BasicFileAttributes.class);
            if (attributes.isDirectory())
                System.out.println("This is folder");
            else
                System.out.println("this is not folder");
            if (attributes.isRegularFile())
                System.out.println("This is regular file");
            else
                System.out.println("this is not regular file");
            if (attributes.isSymbolicLink())
                System.out.println("This is symbolic link");
            else
                System.out.println("this is not symbolic link");
            System.out.printf("Time of last file modification: %s%n", attributes.lastModifiedTime());
            System.out.printf("File size is %d bytes", attributes.size());
        } catch (IOException e) {
            System.out.printf("IOException %s%n", e);
        }
    }
}
