package part1.chapter16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class UseTrim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Enter 'stop' for exit.");
        System.out.println("Enter state name: ");
        do {
            str = br.readLine().trim();
            if (str.equals("Иллинойс"))
                System.out.println("Столица - Спрингфилд.");
            else if (str.equals("Миссури"))
                System.out.println("Столица - Джефферсон-сити.");
            else if (str.equals("Калифорния"))
                System.out.println("Столица - Сакраменто.");
            else if (str.equals("Вашингтон"))
                System.out.println("Столица - Олимпия.");
        } while (!str.equals("stop"));
    }
}
