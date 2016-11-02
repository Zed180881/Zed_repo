package springtransactionapi;

import org.springframework.context.support.GenericXmlApplicationContext;
import springtransactionapi.entity.Contact;
import springtransactionapi.service.ContactService;

import java.util.List;

public class TxProgrammaticSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:tx-programmatic-app-context.xml");
        ctx.refresh();
        ContactService contactService = ctx.getBean("contactProgrammaticService", ContactService.class);
        List<Contact> contacts = contactService.findAll();
        contacts.forEach(System.out::println);
        Contact contact = contactService.findById(1L);
        contact.setFirstName("Peter");
        contactService.save(contact);
        System.out.println("Contact saved successfully: " + contact);
        System.out.println("Contact count: " + contactService.countAll());
    }
}
