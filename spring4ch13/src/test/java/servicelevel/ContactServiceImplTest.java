package servicelevel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceTestConfig.class})
@TestExecutionListeners({ServiceTestExecutionListener.class})
@ActiveProfiles("test")
public class ContactServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    ContactService contactService;

    @DataSets(setUpDataSet = "servicelevel/ContactServiceImplTest.xls")
    @Test
    public void testFindAll() throws Exception {
        List<Contact> result = contactService.findAll();
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @DataSets(setUpDataSet = "servicelevel/ContactServiceImplTest.xls")
    @Test
    public void testFindByFirstNameAndLastName_1() throws Exception {
        Contact result = contactService.findByFirstNameAndLastName("Chris", "Schaefer");
        assertNotNull(result);
    }

    @DataSets(setUpDataSet = "servicelevel/ContactServiceImplTest.xls")
    @Test
    public void testFindByFirstNameAndLastName_2() throws Exception {
        Contact result = contactService.findByFirstNameAndLastName("Peter", "Chan");
        assertNotNull(result);
    }

    public void testAddContact() throws Exception {
        deleteFromTables("CONTACT");
        Contact contact = new Contact();
        contact.setFirstName("Rod");
        contact.setLastName("Johnson");
        contactService.save(contact);
        em.flush();
        List<Contact> contacts = contactService.findAll();
        assertEquals(1, contacts.size());
    }

    @Test(expected = ConstraintViolationException.class)
    public void testAddContactWithJSR349Error() throws Exception {
        deleteFromTables("CONTACT");
        Contact contact = new Contact();
        contactService.save(contact);
        em.flush();
        List<Contact> contacts = contactService.findAll();
        assertEquals(0, contacts.size());
    }
}
