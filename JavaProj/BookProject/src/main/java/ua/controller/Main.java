package ua.controller;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
	ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
		"/META-INF/applicationContext.xml");
	BookService bookService = context.getBean(BookService.class);
	bookService.saveBook();
	bookService.updateBook();
	bookService.findAll();
	bookService.findOneBook();
	bookService.delete();
	BookDao dao = bookService.getBookDao();
	System.out.println(dao.getClass());
	context.close();

    }

}
