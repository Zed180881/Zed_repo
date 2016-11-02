package main.java.usingdatasources;

import main.java.dao.ContactDao;
import org.springframework.context.support.GenericXmlApplicationContext;

public class JdbcContactDaoSarnple {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:usingdatasources.xml");
        ctx.refresh();
        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
        System.out.println("First name for contact id 1 is: " +
                contactDao.findFirstNameById(1l));
        contactDao = ctx.getBean("contactDaoNamed", ContactDao.class);
        System.out.println("Last name for contact id 1 is: " +
                contactDao.findLastNameById(1l));
    }
}
