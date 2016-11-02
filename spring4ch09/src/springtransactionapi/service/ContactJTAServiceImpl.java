package springtransactionapi.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springtransactionapi.entity.Contact;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("contactJTAService")
@Repository
@Transactional
public class ContactJTAServiceImpl implements ContactService {
    @PersistenceContext(unitName = "emfA")
    private EntityManager entityManagerA;
    @PersistenceContext(unitName = "emfB")
    private EntityManager entityManagerB;

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Contact findById(Long id) {
        return null;
    }

    @Override
    public Contact save(Contact contact) {
        Contact contactB = new Contact();
        contactB.setFirstName(contact.getFirstName());
        contactB.setLastName(contact.getLastName());
        if (contact.getId() == null) {
            entityManagerA.persist(contact);
            entityManagerB.persist(contactB);
//            throw new JpaSystemException(new PersistenceException());
        } else {
            entityManagerA.merge(contact);
            entityManagerB.merge(contact);
        }
        return contact;
    }

    @Override
    public long countAll() {
        return 0;
    }
}
