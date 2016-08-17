package part2.chapter30;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegExpr {
    public static void main(String[] args) {
        Pattern pat;
        Matcher mat;
        boolean found;

        pat = Pattern.compile("Java");
        mat = pat.matcher("Java");

        found = mat.matches();

        System.out.println("Checking matching Java with Java:");
        if (found)
            System.out.println("Matches");
        else
            System.out.println("Doesn't Matches");
        System.out.println();

        System.out.println("Checking matching Java with Java 8:");
        mat = pat.matcher("Java 8");
        found = mat.matches();
        if (found)
            System.out.println("Matches");
        else
            System.out.println("Doesn't Matches");
    }
}
