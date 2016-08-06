package part1.chapter19;

import java.util.Date;

class DateDemo {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        long msec = date.getTime();
        System.out.println("Count of milliseconds from 01.01.1970: " + msec);
    }
}
