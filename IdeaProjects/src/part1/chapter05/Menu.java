package part1.chapter05;

import java.io.IOException;

/**
 * Created by Zed on 14.07.2016.
 */
class Menu {
    public static void main(String[] args) throws IOException {
        char choice;
        do {
            System.out.println("Справка по оператору:");
            System.out.println("1. if");
            System.out.println("2. switch");
            System.out.println("3. while");
            System.out.println("4. do-while");
            System.out.println("5. for");
            System.out.println("Выберите нужный пункт:");
            choice = (char) System.in.read();
        } while (choice < '1' || choice > '5');
        System.out.println();

        switch (choice) {
            case '1':
                System.out.println("if:");
                System.out.println("if (условие) оператор;");
                System.out.println("else оператор;");
                break;
            case '2':
                System.out.println("switch:");
                break;
            case '3':
                System.out.println("while:");
                break;
            case '4':
                System.out.println("do-while:");
                break;
            case '5':
                System.out.println("for:");
                break;
        }
    }
}
