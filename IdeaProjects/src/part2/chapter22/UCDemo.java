package part2.chapter22;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

class UCDemo {
    public static void main(String[] args) throws IOException {
        int c;
        URL hp = new URL("http://www.HerbSchildt.com");
        URLConnection hpCon = hp.openConnection();

        long d = hpCon.getDate();
        if (d == 0)
            System.out.println("Information about date is absent");
        else
            System.out.printf("Date: %tc%n", new Date(d));
        System.out.printf("Content type: %s%n", hpCon.getContentType());
        d = hpCon.getExpiration();
        if (d == 0)
            System.out.println("Information about expiration is absent");
        else
            System.out.printf("Expiration date: %tc%n", new Date(d));
        d = hpCon.getLastModified();
        if (d == 0)
            System.out.println("Information about last modification is absent");
        else
            System.out.printf("Last modified: %tc%n", new Date(d));
        long len = hpCon.getContentLengthLong();
        if (len == -1)
            System.out.println("Content length unreachable");
        else
            System.out.printf("Content length: %d%n", len);
        if (len != 0) {
            System.out.println("=== Content ===");
            InputStream inputStream = hpCon.getInputStream();
            while ((c = inputStream.read()) != -1) {
                System.out.print((char) c);
            }
            inputStream.close();
        } else
            System.out.println("Content unreachable");
    }
}
