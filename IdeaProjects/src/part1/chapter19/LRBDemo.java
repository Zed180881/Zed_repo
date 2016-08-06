package part1.chapter19;

import java.util.Locale;
import java.util.ResourceBundle;

class LRBDemo {
    public static void main(String[] args) {
        ResourceBundle rd = ResourceBundle.getBundle("SampleRB");

        System.out.println("English version: ");
        System.out.println("Title: " + rd.getString("title"));
        System.out.println("Stop text: " + rd.getString("StopText"));
        System.out.println("Start text: " + rd.getString("StartText"));

        rd = ResourceBundle.getBundle("SampleRB", Locale.GERMAN);

        System.out.println("German version: ");
        System.out.println("Title: " + rd.getString("title"));
        System.out.println("Stop text: " + rd.getString("StopText"));
        System.out.println("Start text: " + rd.getString("StartText"));
    }
}
