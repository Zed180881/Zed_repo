package part1.chapter20;

import java.io.File;

class FileDemo {
    static void p(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        File f1 = new File("d:/Translation/text.txt");
        p("FileName: " + f1.getName());
        p("Path: " + f1.getPath());
        p("AbsolutePath: " + f1.getAbsolutePath());
        p("Parent: " + f1.getParent());
        p(f1.exists() ? "exists" : "not exists");
        p(f1.canWrite() ? "can write" : "not can write");
        p(f1.canRead() ? "can read" : "not can read");
        p(f1.isDirectory() ? "is directory" : "is not directory");
        p(f1.isFile() ? "is ordinary file" : "might be named channel");
        p(f1.isAbsolute() ? "is absolute" : "is not absolute");
        p("Last changed: " + f1.lastModified());
        p("size: " + f1.length() + " byte");

    }
}
