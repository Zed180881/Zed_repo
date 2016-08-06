package part1.chapter18;

import java.util.LinkedList;

class MailList {
    public static void main(String[] args) {
        LinkedList<Address> ml = new LinkedList<>();
        ml.add(new Address("J.W. West", "11 Oak Ave", "Urbana", "IL", "61801"));
        ml.add(new Address("Ralph Baker", "1142 Maple Lane", "Mahomet", "IL", "61853"));
        ml.add(new Address("Tom Carlton", "867 Elm St", "Champaign", "IL", "61820"));

        for (Address address : ml) {
            System.out.println(address);
        }
        System.out.println();
    }
}
