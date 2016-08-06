package ua.controller;

import java.util.List;

public class BookDaoImplDB implements BookDao {

    public void save(Book book) {
	System.out.println("Saved to Db " + book);

    }

    public void update(Book book) {
	System.out.println("Updated in Db " + book);

    }

    public Book find(int id) {
	System.out.println("Finded from Db by " + id);
	return null;
    }

    public List<Book> find() {
	System.out.println("Finded all from Db");
	return null;
    }

    public void delete(Book book) {
	System.out.println("Deleted from Db " + book);

    }

}
