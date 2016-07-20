package ua.entity;

//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
	EntityManagerFactory factory = Persistence
		.createEntityManagerFactory("primary");
	EntityManager em = factory.createEntityManager();
	em.getTransaction().begin();

//	Category category1 = new Category("TV");
//	em.persist(category1);
//	Category category2 = new Category("Phone");
//	em.persist(category2);
//	Category category3 = new Category("Freezer");
//	em.persist(category3);
//	Category category4 = new Category("MicroVawe");
//	em.persist(category4);
//
//	Producer producer1 = new Producer("LG");
//	em.persist(producer1);
//	Producer producer2 = new Producer("Samsung");
//	em.persist(producer2);
//	Producer producer3 = new Producer("Bosh");
//	em.persist(producer3);
//	Producer producer4 = new Producer("Apple");
//	em.persist(producer4);
//
//	CommodityStatus commodityStatus1 = new CommodityStatus("Available");
//	em.persist(commodityStatus1);
//	CommodityStatus commodityStatus2 = new CommodityStatus("NotAvailable");
//	em.persist(commodityStatus2);
//	CommodityStatus commodityStatus3 = new CommodityStatus("Expected");
//	em.persist(commodityStatus3);
//	CommodityStatus commodityStatus4 = new CommodityStatus("Deprecated");
//	em.persist(commodityStatus4);
//
//	Commodity commodity1 = new Commodity(category1, "Model1", producer1,
//		20, 10.3, commodityStatus1, 12);
//	em.persist(commodity1);
//	Commodity commodity2 = new Commodity(category1, "Model2", producer2,
//		11, 15.0, commodityStatus2, 12);
//	em.persist(commodity2);
//	Commodity commodity3 = new Commodity(category1, "Model3", producer3,
//		152, 56.9, commodityStatus3, 24);
//	em.persist(commodity3);
//	Commodity commodity4 = new Commodity(category2, "Model6", producer4,
//		115, 14.5, commodityStatus4, 6);
//	em.persist(commodity4);
//	Commodity commodity5 = new Commodity(category3, "Model7", producer2,
//		156, 11.3, commodityStatus1, 1);
//	em.persist(commodity5);
//	Commodity commodity6 = new Commodity(category2, "Model15", producer4,
//		132, 200.5, commodityStatus1, 3);
//	em.persist(commodity6);
//
//	User user1 = new User("Vasya Pupkin", "vasya97", "123456",
//		"vasya97@gmail.com", "+380971111111", "Kiev, Hreschatyk, 27/15");
//	em.persist(user1);
//	User user2 = new User("Ivan Ivanov", "vanuya95", "vano",
//		"vanya95@gmail.com", "+380972222222", "Lviv, Shevchenka, 57/17");
//	em.persist(user2);
//	User user3 = new User("Petro Petrov", "petya91", "ppp",
//		"petya91@gmail.com", "+380973333333",
//		"Harkiv, Peremogy, 168/91");
//	em.persist(user3);
//	User user4 = new User("Sydor Sydorov", "sidor87", "syd",
//		"sidor87@gmail.com", "+380974444444",
//		"Sumy, Nezalezhnosti, 25/87");
//	em.persist(user4);
//
//	OrderStatus orderStatus1 = new OrderStatus("New");
//	em.persist(orderStatus1);
//	OrderStatus orderStatus2 = new OrderStatus("Paid");
//	em.persist(orderStatus2);
//	OrderStatus orderStatus3 = new OrderStatus("Sended");
//	em.persist(orderStatus3);
//	OrderStatus orderStatus4 = new OrderStatus("Closed");
//	em.persist(orderStatus4);
//	OrderStatus orderStatus5 = new OrderStatus("Cancelled");
//	em.persist(orderStatus5);
//
//	List<Commodity> commodities1 = new ArrayList<>();
//	commodities1.add(commodity5);
//	commodities1.add(commodity4);
//	CommodityOrder commodityOrder1 = new CommodityOrder(user1,
//		commodities1, orderStatus1, new Date(), null, null);
//	em.persist(commodityOrder1);
//	List<Commodity> commodities2 = new ArrayList<>();
//	commodities1.add(commodity1);
//	commodities1.add(commodity2);
//	CommodityOrder commodityOrder2 = new CommodityOrder(user1,
//		commodities2, orderStatus2, new Date(), null, null);
//	em.persist(commodityOrder2);

	// Category category = em.find(Category.class, 1);
	// Producer producer = em.find(Producer.class, 1);
	// CommodityStatus commodityStatus = em.find(CommodityStatus.class, 1);
	// Commodity commodity = new Commodity();
	// commodity.setCategory(category);
	// commodity.setProducer(producer);
	// commodity.setCommodityStatus(commodityStatus);
	// commodity.setModel("Model1");
	// commodity.setPrice(1000);
	// commodity.setQuantity(126);
	// commodity.setWarranty(12);
	// em.persist(commodity);

	em.getTransaction().commit();
	em.close();
	factory.close();

    }

}
