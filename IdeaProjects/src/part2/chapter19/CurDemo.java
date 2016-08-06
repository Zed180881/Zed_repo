package part1.chapter19;

import java.util.Currency;
import java.util.Locale;

class CurDemo {
    public static void main(String[] args) {
        Currency c = Currency.getInstance(Locale.US);
        System.out.println("Symbol: " + c.getSymbol());
        System.out.println("Digits after points: " + c.getDefaultFractionDigits());
    }
}
