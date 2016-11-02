package hibernatejpa;

import hibernatejpa.entity.Contact;
import hibernatejpa.entity.ContactSummary;
import hibernatejpa.entity.ContactTelDetail;
import hibernatejpa.service.ContactService;
import hibernatejpa.service.ContactSummaryService;
import hibernatejpa.service.ContactSummaryUntypeImpl;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class SpringJPASample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring-config.xml");
        ctx.refresh();
        ContactService contactService = ctx.getBean("jpaContactService", ContactService.class);
        listContacts(contactService.findAll());
        listContactsWithDetail(contactService.findAllWithDetail());
        Contact contact = contactService.findById(1L);
        System.out.println("");
        System.out.println("Contact with id 1:" + contact);
        System.out.println("");
        ContactSummaryUntypeImpl contactSummaryUntype = ctx.getBean("contactSummaryUntype", ContactSummaryUntypeImpl.class);
        contactSummaryUntype.displayAllContactsSummary();
        ContactSummaryService contactSummaryService = ctx.getBean("contactSummaryService", ContactSummaryService.class);
        List<ContactSummary> contacts = contactSummaryService.findAll();
        contacts.forEach(System.out::println);
        contact = new Contact();
        contact.setFirstName("Michael");
        contact.setLastName("Jackson");
        contact.setBirthDate(new Date());
        ContactTelDetail contactTelDetail = new ContactTelDetail("Home", "1111111111");
        contact.addContactTelDetail(contactTelDetail);
        contactTelDetail = new ContactTelDetail("Mobile", "2222222222");
        contact.addContactTelDetail(contactTelDetail);
        contactService.save(contact);
        listContactsWithDetail(contactService.findAllWithDetail());
        contact = contactService.findById(1L);
        contact.setFirstName("Kim Fung");
        contact.getContactTelDetails().removeIf(contactTel -> contactTel.getTelType().equals("Home"));
        contactService.save(contact);
        listContactsWithDetail(contactService.findAllWithDetail());
        contact = contactService.findById(1L);
        contactService.delete(contact);
        listContactsWithDetail(contactService.findAllWithDetail());
        listContacts(contactService.findAllByNativeQuery());
        listContactsWithDetail(contactService.findByCriteriaQuery("John", "Smith"));
    }

    private static void listContacts(List<Contact> contacts) {
        System.out.println("");
        System.out.println("Listing contacts without details:");
        for (Contact contact : contacts) {
            System.out.println(contact);
            System.out.println();
        }
    }

    private static void listContactsWithDetail(List<Contact> contacts) {
        System.out.println("");
        System.out.println("Listing contacts with details: ");
        for (Contact contact : contacts) {
            System.out.println(contact);
            if (contact.getContactTelDetails() != null) {
                contact.getContactTelDetails().forEach(System.out::println);
            }
            if (contact.getHobbies() != null) {
                contact.getHobbies().forEach(System.out::println);
            }
            System.out.println();
        }
    }

}
