package main.java;

import main.java.javawithgroovy.Contact;
import main.java.javawithgroovy.ContactService;
import org.joda.time.format.DateTimeFormat;
import org.springframework.context.support.GenericXmlApplicationContext;

public class RuleEngineTest {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context.xml");
        ctx.refresh();
        ContactService contactService = ctx.getBean("contactService", ContactService.class);
        Contact contact = new Contact();
        contact.setId(1L);
        contact.setFirstName("Chris");
        contact.setLastName("Schaefer");
        contact.setBirthDate(DateTimeFormat.forPattern(
                "yyyy-MM-dd").parseDateTime("1981-05-03"));
        contactService.applyRule(contact);
        System.out.println("Contact: " + contact);
        try {
            System.in.read();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        contactService.applyRule(contact);
        System.out.println("Contact: " + contact);
    }
}
