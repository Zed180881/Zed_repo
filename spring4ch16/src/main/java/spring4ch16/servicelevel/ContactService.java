package spring4ch16.servicelevel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import spring4ch16.entity.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();

    Contact findById(Long id);

    Contact save(Contact contact);

    Page<Contact> findAllByPage(Pageable pageable);
}
