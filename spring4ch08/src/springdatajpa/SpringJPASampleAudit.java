package springdatajpa;

import org.springframework.context.support.GenericXmlApplicationContext;
import springdatajpa.entity.ContactAudit;
import springdatajpa.service.ContactAuditService;

import java.util.Date;
import java.util.List;

public class SpringJPASampleAudit {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:springdatajpa.xml");
        ctx.refresh();
        ContactAuditService contactService = ctx.getBean("contactAuditService", ContactAuditService.class);
        List<ContactAudit> contacts = contactService.findAll();
        listContacts(contacts);
        System.out.println("Add new contact");
        ContactAudit contact = new ContactAudit();
        contact.setFirstName("Мichael");
        contact.setLastName("Jackson");
        contact.setBirthDate(new Date());
        contactService.save(contact);
        contacts = contactService.findAll();
        listContacts(contacts);
        contact = contactService.findById(1L);
        System.out.println("");
        System.out.println("Contact with id 1:" + contact);
        System.out.println("");
        System.out.println("Update contact");
        contact.setFirstName("Tom");
        contactService.save(contact);
        contacts = contactService.findAll();
        listContacts(contacts);
        ContactAudit oldContact = contactService.findAuditByRevision(1L, 1);
        System.out.println("");
        System.out.println("Old Contact with id 1 and rev 1:" + oldContact);
        System.out.println("");
        oldContact = contactService.findAuditByRevision(1L, 2);
        System.out.println("");
        System.out.println("Old Contact with id 1 and rev 2:" + oldContact);
        System.out.println("");
    }

    private static void listContacts(List<ContactAudit> contacts) {
        System.out.println("");
        System.out.println("Listing contacts without details:");
        for (ContactAudit contact : contacts) {
            System.out.println(contact);
            System.out.println();
        }
    }
}
