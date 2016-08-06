package resCopyHybernateEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@SuppressWarnings("unused")
public class Main {

    public static void main(String[] args) {
	EntityManagerFactory factory = Persistence
		.createEntityManagerFactory("primary");
	EntityManager em = factory.createEntityManager();
	em.getTransaction().begin();

	 /*Category category1 = new Category("TV");
	 em.persist(category1);
	 Category category2 = new Category("Phone");
	 em.persist(category2);
	 Category category3 = new Category("Freezer");
	 em.persist(category3);
	 Category category4 = new Category("MicroVawe");
	 em.persist(category4);
	
	 Producer producer1 = new Producer("LG");
	 em.persist(producer1);
	 Producer producer2 = new Producer("Samsung");
	 em.persist(producer2);
	 Producer producer3 = new Producer("Bosh");
	 em.persist(producer3);
	 Producer producer4 = new Producer("Apple");
	 em.persist(producer4);
	
	 CommodityStatus commodityStatus1 = new CommodityStatus("Available");
	 em.persist(commodityStatus1);
	 CommodityStatus commodityStatus2 = new
	 CommodityStatus("NotAvailable");
	 em.persist(commodityStatus2);
	 CommodityStatus commodityStatus3 = new CommodityStatus("Expected");
	 em.persist(commodityStatus3);
	 CommodityStatus commodityStatus4 = new CommodityStatus("Deprecated");
	 em.persist(commodityStatus4);
	
	 Commodity commodity1 = new Commodity(category1, "Model1", producer1,
	 20, 10.3, commodityStatus1, 12);
	 em.persist(commodity1);
	 Commodity commodity2 = new Commodity(category1, "Model2", producer2,
	 11, 15.0, commodityStatus2, 12);
	 em.persist(commodity2);
	 Commodity commodity3 = new Commodity(category1, "Model3", producer3,
	 152, 56.9, commodityStatus3, 24);
	 em.persist(commodity3);
	 Commodity commodity4 = new Commodity(category2, "Model6", producer4,
	 115, 14.5, commodityStatus4, 6);
	 em.persist(commodity4);
	 Commodity commodity5 = new Commodity(category3, "Model7", producer2,
	 156, 11.3, commodityStatus1, 1);
	 em.persist(commodity5);
	 Commodity commodity6 = new Commodity(category2, "Model15", producer4,
	 132, 200.5, commodityStatus1, 3);
	 em.persist(commodity6);
	
	 User user1 = new User("Vasya Pupkin", "vasya97", "123456",
	 "vasya97@gmail.com", "+380971111111", "Kiev, Hreschatyk, 27/15");
	 em.persist(user1);
	 User user2 = new User("Ivan Ivanov", "vanuya95", "vano",
	 "vanya95@gmail.com", "+380972222222", "Lviv, Shevchenka, 57/17");
	 em.persist(user2);
	 User user3 = new User("Petro Petrov", "petya91", "ppp",
	 "petya91@gmail.com", "+380973333333",
	 "Harkiv, Peremogy, 168/91");
	 em.persist(user3);
	 User user4 = new User("Sydor Sydorov", "sidor87", "syd",
	 "sidor87@gmail.com", "+380974444444",
	 "Sumy, Nezalezhnosti, 25/87");
	 em.persist(user4);
	
	 OrderStatus orderStatus1 = new OrderStatus("New");
	 em.persist(orderStatus1);
	 OrderStatus orderStatus2 = new OrderStatus("Paid");
	 em.persist(orderStatus2);
	 OrderStatus orderStatus3 = new OrderStatus("Sended");
	 em.persist(orderStatus3);
	 OrderStatus orderStatus4 = new OrderStatus("Closed");
	 em.persist(orderStatus4);
	 OrderStatus orderStatus5 = new OrderStatus("Cancelled");
	 em.persist(orderStatus5);
	 
	 List<Commodity> commodities1 = new ArrayList<>();
	 commodities1.add(commodity4);
	 commodities1.add(commodity5);
!!!	 LocalDate orderDate = LocalDate.of(2016, 07, 25);
!!!	 LocalDate orderDate = LocalDate.now();
	 CommodityOrder commodityOrder1 = new CommodityOrder(user2,
	 commodities1, orderStatus1, new Date(), null, null);
	 em.persist(commodityOrder1);
	 
	 List<Commodity> commodities2 = new ArrayList<>();
	 commodities2.add(commodity1);
	 commodities2.add(commodity2);
	 CommodityOrder commodityOrder2 = new CommodityOrder(user1,
	 commodities2, orderStatus2, new Date(), null, null);
	 em.persist(commodityOrder2);*/	
	
//	 List<Commodity> commodities1 = new ArrayList<>();
//	 Commodity commodityToAdd1 =em.find(Commodity.class, 5); 
//	 commodities1.add(commodityToAdd1);
//	 Commodity commodityToAdd2 =em.find(Commodity.class, 4);
//	 commodities1.add(commodityToAdd2);
//	 CommodityOrder commodityOrderToAdd = em.find(CommodityOrder.class, 3);
//	 commodityOrderToAdd.setCommodities(commodities1);
//	 em.persist(commodityOrderToAdd);
	
//	List<Commodity> commodities = new ArrayList<>();
//	commodities.add(em.find(Commodity.class, 4));
//	commodities.add(em.find(Commodity.class, 5));
//	System.out.println(commodities);
//	CommodityOrder order = em.find(CommodityOrder.class, 1);
//	System.out.println(order);
//	for (Commodity commodity : commodities) {
//	    commodity.getCommodityOrders().add(order);
//	}
//	 List<Commodity> commodities1 = new ArrayList<>();
//	 Commodity commodityToAdd1 =em.find(Commodity.class, 5); 
//	 commodities1.add(commodityToAdd1);
//	 Commodity commodityToAdd2 =em.find(Commodity.class, 4);
//	 commodities1.add(commodityToAdd2);
//	 User userToAdd = em.find(User.class, 1);
//	 OrderStatus orderStatusToAdd = em.find(OrderStatus.class, 1);
//	 CommodityOrder commodityOrder1 = new CommodityOrder(userToAdd,
//	 commodities1, orderStatusToAdd, new Date(), null, null);
//	 em.persist(commodityOrder1);
	 
	 
	 

	/*Category category = em.createQuery("select c from Category c where c.categoryName=:name",
			Category.class).setParameter("name", "TV").getSingleResult();
	System.out.println(category.getId() + " " + category.getCategoryName());
	for (Commodity commodity:category.getCommodities()){
	    System.out.println(commodity.getModel());
	}
	Category category1 = em.createQuery("select c from Category c where c.categoryName=:name",
		Category.class).setParameter("name", "Phone").getSingleResult();
	System.out.println(category1.getId() + " " + category1.getCategoryName());
	for (Commodity commodity:category1.getCommodities()){
	    System.out.println(commodity.getModel());
	}
	Producer producer = em.createQuery("select p from Producer p where p.producerName=:name",
		Producer.class).setParameter("name", "Apple").getSingleResult();
	System.out.println(producer.getId() + " " + producer.getProducerName());
	for (Commodity commodity:producer.getCommodities()){
	    System.out.println(commodity.getModel());
	}
	Producer producer1 = em.createQuery("select p from Producer p where p.producerName=:name",
		Producer.class).setParameter("name", "LG").getSingleResult();
	System.out.println(producer1.getId() + " " + producer1.getProducerName());
	for (Commodity commodity:producer1.getCommodities()){
	    System.out.println(commodity.getModel());
	}
	CommodityStatus commodityStatus = em.createQuery("select cs from CommodityStatus cs where cs.commodityStatusName=:name",
		CommodityStatus.class).setParameter("name", "Available").getSingleResult();
	System.out.println(commodityStatus.getId() + " " + commodityStatus.getCommodityStatusName());
	for (Commodity commodity:commodityStatus.getCommodities()){
	    System.out.println(commodity.getModel());
	}
	
	User user = em.createQuery("select u from User u where u.fullName=:name",
		User.class).setParameter("name", "Vasya Pupkin").getSingleResult();
	System.out.println(user.getId() + " " + user.getFullName() + user.getLogin()+user.getFullName());
	for (CommodityOrder commodityOrder:user.getCommodityOrders()){
	    System.out.println(commodityOrder.getOrderDate()+" "+commodityOrder.getSum());
	    for (Commodity commodity: commodityOrder.getCommodities()){
		System.out.println(commodity.getModel());
	    }
	}*/
	
	/*List<Commodity> commodities = em.createQuery("select c from Commodity c join c.producer p where p.producerName=:name", Commodity.class).setParameter("name", "Apple").getResultList();
	for (Commodity commodity: commodities) {
	    System.out.println(commodity.getModel());
	}
	List<Commodity> commodities1 = em.createQuery("select c from Commodity c join c.producer p where p.producerName=:name", Commodity.class).setParameter("name", "LG").getResultList();
	for (Commodity commodity: commodities1) {
	    System.out.println(commodity.getModel());
	}
	List<Commodity> commodities3 = em.createQuery("select c from Commodity c join c.commodityStatus cs where cs.commodityStatusName=:name", Commodity.class).setParameter("name", "Available").getResultList();
	for (Commodity commodity: commodities3) {
	    System.out.println(commodity.getModel());
	}
	List<CommodityOrder> commodityOrders = em.createQuery("select co from CommodityOrder co join co.orderStatus cos where cos.orderStatusName=:name", CommodityOrder.class).setParameter("name", "New").getResultList();
	for (CommodityOrder commodityOrder: commodityOrders) {
	    System.out.println(commodityOrder.getSum());
	}*/
	
	/*Producer producer = em.createQuery("select p from Producer p join fetch p.commodities where p.producerName=:name",
		Producer.class).setParameter("name", "Apple").getSingleResult();
	System.out.println(producer.getId() + " " + producer.getProducerName());
	
	User user = em.createQuery("select u from User u join fetch u.commodityOrders where u.fullName=:name",
		User.class).setParameter("name", "Vasya Pupkin").getSingleResult();
	System.out.println(user.getId() + " " + user.getFullName() + user.getLogin()+user.getFullName());
	
	Category category = em.createQuery("select c from Category c join fetch c.commodities where c.categoryName=:name",
		Category.class).setParameter("name", "TV").getSingleResult();
	System.out.println(category.getId() + " " + category.getCategoryName());*/
	
	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaQuery<Commodity> cq = cb.createQuery(Commodity.class);
	Root<Commodity> root = cq.from(Commodity.class);
	Predicate findByCommodityModel = cb.equal(root.get("model"), "Model1");
	
	Join<Commodity, Producer> producerJoin = root.join("producer");
//	root.fetch("producer");
//	cq.distinct(true);
	
	Predicate findByProducerName = cb.equal(producerJoin.get("producerName"), "LG");	
	Predicate all = cb.and(findByCommodityModel, findByProducerName);
	
	Join<Commodity, Category> categoryJoin = root.join("category");
	Predicate findByCategory = cb.equal(categoryJoin.get("categoryName"), "TV");
	all = cb.and(all,findByCategory);
	
	
	cq.where(all);
	List<Commodity> commodities = em.createQuery(cq).getResultList();
	System.out.println(commodities);
	em.getTransaction().commit();
	em.close();
	factory.close();
	
	/*for (Commodity commodity:producer.getCommodities()){
	    System.out.println(commodity.getModel());
	}
	
	for (CommodityOrder commodityOrder:user.getCommodityOrders()){
	    System.out.println(commodityOrder.getOrderDate()+" "+commodityOrder.getSum());
	}
	
	for (Commodity commodity:category.getCommodities()){
	    System.out.println(commodity.getModel());
	}*/

    }

}
