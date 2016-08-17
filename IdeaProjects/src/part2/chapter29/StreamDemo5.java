package part2.chapter29;

import java.util.ArrayList;
import java.util.stream.Stream;

class StreamDemo5 {
    public static void main(String[] args) {
        ArrayList<NamePhoneEMail> myList = new ArrayList<>();
        myList.add(new NamePhoneEMail("Larry", "555-5555", "Larry@HerbSchildt.com"));
        myList.add(new NamePhoneEMail("James", "555-4444", "James@HerbSchildt.com"));
        myList.add(new NamePhoneEMail("Mary", "555-3333", "Mary@HerbSchildt.com"));

        System.out.println("Source elements from myList:");
        myList.stream().forEach(a -> {
            System.out.println(a.name + " " + a.phonenum + " " + a.email);
        });
        System.out.println();

        Stream<NamePhone> nameAndPhone = myList.stream().map(a -> new NamePhone(a.name, a.phonenum));
        System.out.println("Names and phones list:");
        nameAndPhone.forEach(a -> System.out.println(a.name + " " + a.phonenum));
    }
}
