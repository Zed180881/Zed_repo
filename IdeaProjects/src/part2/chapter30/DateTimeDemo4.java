package part2.chapter30;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

class DateTimeDemo4 {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("English","US"));
        LocalDateTime curDateTime = LocalDateTime.parse("June 21, 2014 12:01 AM",DateTimeFormatter.ofPattern("MMMM d',' yyyy hh':'mm a"));
        System.out.println(curDateTime.format(DateTimeFormatter.ofPattern("MMMM d',' yyyy hh':'mm a")));
    }
}
