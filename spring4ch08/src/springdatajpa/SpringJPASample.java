package springdatajpa;

import org.springframework.context.support.GenericXmlApplicationContext;
import springdatajpa.entity.Contact;
import springdatajpa.service.ContactService;

import java.util.List;

public class SpringJPASample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:springdatajpa.xml");
        ctx.refresh();
        ContactService contactService = ctx.getBean("springJpaContactService", ContactService.class);
        listContacts("Find all:", contactService.findAll());
        listContacts("Find by first name:", contactService.findByFirstName("Chris"));
        listContacts("Find by first and last name:", contactService.findByFirstNameAndLastName("Chris", "Schaefer"));
    }

    private static void listContacts(String message, List<Contact> contacts) {
        System.out.println("");
        System.out.println(message);
        System.out.println("Listing contacts without details:");
        contacts.forEach(System.out::println);
        System.out.println();
    }
}
