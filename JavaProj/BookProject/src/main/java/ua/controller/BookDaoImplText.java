package ua.controller;

import java.util.List;

public class BookDaoImplText implements BookDao {

    public void save(Book book) {
	System.out.println("Saved to text file " + book);

    }

    public void update(Book book) {
	System.out.println("Updated in text file " + book);

    }

    public Book find(int id) {
	System.out.println("Finded from text file by " + id);
	return null;
    }

    public List<Book> find() {
	System.out.println("Finded all from text file");
	return null;
    }

    public void delete(Book book) {
	System.out.println("Deleted from text file " + book);

    }

}
