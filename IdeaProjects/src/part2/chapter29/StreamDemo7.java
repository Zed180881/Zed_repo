package part2.chapter29;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StreamDemo7 {
    public static void main(String[] args) {
        ArrayList<NamePhoneEMail> myList = new ArrayList<>();
        myList.add(new NamePhoneEMail("Larry", "555-5555", "Larry@HerbSchildt.com"));
        myList.add(new NamePhoneEMail("James", "555-4444", "James@HerbSchildt.com"));
        myList.add(new NamePhoneEMail("Mary", "555-3333", "Mary@HerbSchildt.com"));

        Stream<NamePhone> nameAndPhone = myList.stream().map(a -> new NamePhone(a.name, a.phonenum));
        List<NamePhone> npList = nameAndPhone.collect(Collectors.toList());
        System.out.println("Names and phones in list:");
        npList.forEach(a -> System.out.println(a.name + ": " + a.phonenum));

        nameAndPhone = myList.stream().map(a -> new NamePhone(a.name, a.phonenum));
        Set<NamePhone> npSet = nameAndPhone.collect(Collectors.toSet());
        System.out.println("Names and phones in set:");
        npSet.forEach(a -> System.out.println(a.name + ": " + a.phonenum));

        LinkedList<NamePhone> namePhones = myList.stream().map(a -> new NamePhone(a.name, a.phonenum)).collect(() -> new LinkedList<>(), (list, element) -> list.add(element), (listA, listB) -> listA.addAll(listB));
        namePhones.forEach(a -> System.out.println(a.name + ": " + a.phonenum));
    }
}
