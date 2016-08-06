package ua.entity;

import java.util.ArrayList;
import java.util.Date;
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

    private double sum;

    private OrderStatus orderStatus;

    private Date orderDate;

    private Date payDate;

    private Date deliveryDate;

    public CommodityOrder() {
    }

    public CommodityOrder(User user, List<Commodity> commodities,
	    OrderStatus orderStatus, Date orderDate, Date payDate,
	    Date deliveryDate) {
	this.user = user;
	this.commodities = commodities;
	this.sum = this.calculateSum();
	this.orderStatus = orderStatus;
	this.orderDate = orderDate;
	this.payDate = payDate;
	this.deliveryDate = deliveryDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
	return id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public User getUser() {
	return user;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public List<Commodity> getCommodities() {
	return commodities;
    }

    public double getSum() {
	return sum;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public OrderStatus getOrderStatus() {
	return orderStatus;
    }

    public Date getOrderDate() {
	return orderDate;
    }

    public Date getPayDate() {
	return payDate;
    }

    public Date getDeliveryDate() {
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

    public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
    }

    public void setPayDate(Date payDate) {
	this.payDate = payDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
	this.deliveryDate = deliveryDate;
    }

    public double calculateSum() {
	double sum = 0;
	for (Commodity commodity : commodities)
	    sum += commodity.getPrice();
	return sum;
    }
}
