package part1.chapter19;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class AvgFile {
    public static void main(String[] args) throws IOException {
        int count = 0;
        double sum = 0.0;

        FileWriter fOut = new FileWriter("test.txt");
        fOut.write("2 3,4 5 6 7,4 9,1 10,5 ready");
        fOut.close();

        FileReader fin = new FileReader("test.txt");
        try (Scanner src = new Scanner(fin)) {
            while (src.hasNext()) {
                if (src.hasNextDouble()) {
                    sum += src.nextDouble();
                    count++;
                } else {
                    String str = src.next();
                    if (str.equals("ready")) break;
                    else {
                        System.out.println("Error of data format");
                        continue;
                    }
                }
            }
        }
        System.out.println("Average is: " + sum / count);

    }
}
