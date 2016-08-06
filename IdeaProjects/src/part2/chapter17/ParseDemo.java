package part1.chapter17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ParseDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int i;
        int sum = 0;
        System.out.println("Enter a number (0 for exit");
        do {
            str = br.readLine();
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect format");
                i = 0;
            }
            sum += i;
            System.out.println("Current sum: " + sum);
        } while (i != 0);
    }
}
