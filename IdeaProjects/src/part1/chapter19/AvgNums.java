package part1.chapter19;

import java.util.Scanner;

class AvgNums {
    public static void main(String[] args) {
        Scanner conin = new Scanner(System.in);

        int count = 0;
        double sum = 0.0;
        System.out.println("Enter numbers for average computing:");
        while (conin.hasNext()) {
            if (conin.hasNextDouble()) {
                sum += conin.nextDouble();
                count++;
            } else {
                String str = conin.next();
                if (str.equals("ready")) break;
                else {
                    System.out.println("Error of data format");
                    continue;
                }
            }
        }
        conin.close();
        System.out.println("Average is: " + sum / count);
    }
}
