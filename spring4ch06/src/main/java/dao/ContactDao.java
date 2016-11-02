package main.java.dao;

import main.java.entities.Contact;

import java.util.List;

public interface ContactDao {
    List<Contact> findAll();

    List<Contact> findAllWithDetail();

    List<Contact> findByFirstName(String firstName);

    String findLastNameById(Long id);

    String findFirstNameById(Long id);

    void insert(Contact contact);

    void insertWithDetail(Contact contact);

    void update(Contact contact);

    void delete(Long contactId);
}
