package ua.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class CommodityOrder {

    private int id;

    private User user;

    private List<Commodity> commodities = new ArrayList<Commodity>();

    private double sum = 0.0;

    private OrderStatus orderStatus;

    private LocalDate orderDate;

    private LocalDate payDate;

    private LocalDate deliveryDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
	return id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public User getUser() {
	return user;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    public List<Commodity> getCommodities() {
	return commodities;
    }

    public double getSum() {
	return sum;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public OrderStatus getOrderStatus() {
	return orderStatus;
    }

    public LocalDate getOrderDate() {
	return orderDate;
    }

    public LocalDate getPayDate() {
	return payDate;
    }

    public LocalDate getDeliveryDate() {
	return deliveryDate;
    }

    public void setId(int id) {
	this.id = id;
    }

    public void setUser(User user) {
	this.user = user;
    }

    public void setCommodities(List<Commodity> commodities) {
	this.commodities = commodities;
    }

    public void setSum(double sum) {
	this.sum = sum;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
	this.orderStatus = orderStatus;
    }

    public void setOrderDate(LocalDate orderDate) {
	this.orderDate = orderDate;
    }

    public void setPayDate(LocalDate payDate) {
	this.payDate = payDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
	this.deliveryDate = deliveryDate;
    }

    public double calculateSum() {
	double sum = 0;
	for (Commodity commodity : commodities)
	    sum += commodity.getPrice();
	return sum;
    }
}
