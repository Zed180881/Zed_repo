package main.java.daoconfigwithannotations;

import main.java.dao.ContactDao;
import main.java.entities.Contact;
import main.java.entities.ContactTelDetail;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class AnnotationJdbcDaoSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:daoconfigwithannotations.xml");
        ctx.refresh();
        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
        List<Contact> contacts = contactDao.findAll();
        System.out.println("List all contacts");
        listContacts(contacts);
        contacts = contactDao.findByFirstName("Chris");
        System.out.println("Find by name Chris:");
        listContacts(contacts);
        Contact contact = new Contact();
        contact.setId(1L);
        contact.setFirstName("Chris");
        contact.setLastName("John");
        contact.setBirthDate(new Date((new GregorianCalendar(1977, 10, 1)).getTime().getTime()));
        contactDao.update(contact);
        System.out.println("After update");
        listContacts(contactDao.findAll());
        contact = new Contact();
        contact.setFirstName("Rod");
        contact.setLastName("Johnson");
        contact.setBirthDate(new Date((new GregorianCalendar(2001, 10, 1)).getTime().getTime()));
        contactDao.insert(contact);
        System.out.println("After insert");
        listContacts(contactDao.findAll());
        contact = new Contact();
        contact.setFirstName("Michael");
        contact.setLastName("Jackson");
        contact.setBirthDate(new Date((new GregorianCalendar(1964, 10, 1)).getTime().getTime()));
        List<ContactTelDetail> contactTelDetails = new ArrayList<>();
        ContactTelDetail contactTelDetail = new ContactTelDetail();
        contactTelDetail.setTelType("Home");
        contactTelDetail.setTelNumber("11111111");
        contactTelDetails.add(contactTelDetail);
        contactTelDetail = new ContactTelDetail();
        contactTelDetail.setTelType("MoЬile");
        contactTelDetail.setTelNumber("22222222");
        contactTelDetails.add(contactTelDetail);
        contact.setContactTelDetails(contactTelDetails);
        contactDao.insertWithDetail(contact);
        System.out.println("After insert with detail");
        listContacts(contactDao.findAllWithDetail());
        System.out.println("First name by id 1");
        System.out.println(contactDao.findFirstNameById(1L));
    }

    private static void listContacts(List<Contact> contacts) {
        for (Contact contact : contacts) {
            System.out.println(contact);
            if (contact.getContactTelDetails() != null) {
                for (ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
                    System.out.println("---" + contactTelDetail);
                }
            }
            System.out.println();
        }
    }
}
