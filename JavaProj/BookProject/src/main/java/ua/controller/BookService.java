package ua.controller;

import java.util.List;

public class BookService {

    private BookDao bookDao;

    public void saveBook() {
	Book book = new Book();
	bookDao.save(book);
    }

    public void updateBook() {
	bookDao.update(new Book());
    }

    public void findOneBook() {
	@SuppressWarnings("unused")
	Book book = bookDao.find(2);
    }

    public void findAll() {
	@SuppressWarnings("unused")
	List<Book> books = bookDao.find();
    }

    public void delete() {
	bookDao.delete(new Book());
    }

    public BookDao getBookDao() {
	return bookDao;
    }

    public void setBookDao(BookDao bookDao) {
	this.bookDao = bookDao;
    }

    public void init() {
	System.out.println("Hi, all!");
    }

    public void close() {
	System.out.println("By-by");
    }

}
