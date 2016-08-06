package part1.chapter20;

import java.io.Console;

class ConsoleDemo {
    public static void main(String[] args) {
        String str;
        Console con;
        con = System.console();
        if (con == null) return;
        str = con.readLine("Enter string: ");
        con.printf("You enter String: %s\n", str);
    }
}
