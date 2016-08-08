package part2.chapter22;

import java.net.MalformedURLException;
import java.net.URL;

class URLDemo {
    public static void main(String[] args) throws MalformedURLException {
        URL hp = new URL("http://www.HerbSchildt.com");
        System.out.printf("Protocol: %s%n", hp.getProtocol());
        System.out.printf("Port: %s%n", hp.getPort());
        System.out.printf("Host: %s%n", hp.getHost());
        System.out.printf("File: %s%n", hp.getFile());
        System.out.printf("Full form: %s%n", hp.toExternalForm());
    }
}
