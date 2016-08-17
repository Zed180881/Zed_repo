package part2.chapter30;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegExpr2 {
    public static void main(String[] args) {
        Pattern pat = Pattern.compile("Java");
        Matcher mat = pat.matcher("Java 8");

        System.out.println("Finding Java in Java 8:");

        if (mat.find())
            System.out.println("Found");
        else
            System.out.println("Not found");
    }
}
