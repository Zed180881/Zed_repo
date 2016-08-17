package part2.chapter30;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class AddClient {
    public static void main(String[] args) {
        String addServerURL = "rmi://" + args[0] + "/AddServer";
        try {
            AddServerIntf addServerIntf = (AddServerIntf) Naming.lookup(addServerURL);
            System.out.println("First number: " + args[1]);
            double d1 = Double.parseDouble(args[1]);
            System.out.println("Second number:" + args[2]);
            double d2 = Double.parseDouble(args[2]);
            System.out.println("Sum: " + addServerIntf.add(d1, d2));
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            System.out.println(e);
        }
    }
}
