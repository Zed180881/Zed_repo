package ua.controller;

import java.util.List;

public interface BookDao {

    void save(Book book);

    void update(Book book);

    Book find(int id);

    List<Book> find();

    void delete(Book book);
}
