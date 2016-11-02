package springjta;

import org.springframework.context.support.GenericXmlApplicationContext;
import springjta.entity.Contact;
import springjta.service.ContactService;

public class TxJtaSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:tx-jta-app-context.xml");
        ctx.refresh();
        ContactService contactService = ctx.getBean("contactJTAService", ContactService.class);
        Contact contact = new Contact();
        contact.setFirstName("Jta");
        contact.setLastName("Manager");
        contactService.save(contact);
        System.out.println("Contact saved successfully");
    }
}
