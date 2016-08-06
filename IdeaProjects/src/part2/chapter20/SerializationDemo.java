package part1.chapter20;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("d:/serial.dat"))) {
            MyClass obj1 = new MyClass("Hello", -7, 2.7e10);
            System.out.println("object1: " + obj1);
            objectOutputStream.writeObject(obj1);
        } catch (IOException e) {
            System.out.println("Serialization exception: " + e);
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d:/serial.dat"))) {
            MyClass obj2 = (MyClass) objectInputStream.readObject();
            System.out.println("object2: " + obj2);
        } catch (Exception e) {
            System.out.println("Serialization exception: " + e);
        }
    }
}
