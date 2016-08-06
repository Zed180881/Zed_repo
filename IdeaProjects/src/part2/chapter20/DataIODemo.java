package part1.chapter20;

import java.io.*;

class DataIODemo {
    public static void main(String[] args) {
        try (DataOutputStream dout = new DataOutputStream(new FileOutputStream("d:\\test.dat"))) {
            dout.writeDouble(98.6);
            dout.writeInt(1000);
            dout.writeBoolean(true);
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        try (DataInputStream din = new DataInputStream(new FileInputStream("d:\\test.dat"))) {
            double d = din.readDouble();
            int i = din.readInt();
            boolean b = din.readBoolean();
            System.out.println("Received values: " + d + " " + i + " " + b);
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
    }
}
