package part1.chapter22;

import java.net.InetAddress;
import java.net.UnknownHostException;

class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println(inetAddress);
        System.out.println(inetAddress.getHostAddress());
        inetAddress = InetAddress.getByName("www.HerbSchildt.com");
        System.out.println(inetAddress);
        InetAddress[] inetAddresses = InetAddress.getAllByName("www.nba.com");
        for (InetAddress address : inetAddresses) {
            System.out.println(address);
        }
    }
}
