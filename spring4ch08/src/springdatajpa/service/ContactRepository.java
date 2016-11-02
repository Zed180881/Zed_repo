package springdatajpa.service;

import org.springframework.data.repository.CrudRepository;
import springdatajpa.entity.Contact;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long> {
    List<Contact> findByFirstName(String firstName);

    List<Contact> findByFirstNameAndLastName(String firstName, String lastName);
}
