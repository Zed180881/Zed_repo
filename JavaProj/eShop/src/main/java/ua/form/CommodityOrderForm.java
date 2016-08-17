package ua.form;

import java.util.ArrayList;
import java.util.List;

import ua.entity.Commodity;
import ua.entity.OrderStatus;
import ua.entity.User;

public class CommodityOrderForm {

    private int id;

    private User user;

    private OrderStatus orderStatus;

    private String orderDate;

    private String payDate;

    private String deliveryDate;

    private List<Commodity> commodities = new ArrayList<>();

    private String sum;

    public List<Commodity> getCommodities() {
	return commodities;
    }

    public void setCommodities(List<Commodity> commodities) {
	this.commodities = commodities;
    }

    public String getSum() {
	return sum;
    }

    public void setSum(String sum) {
	this.sum = sum;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

    public OrderStatus getOrderStatus() {
	return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
	this.orderStatus = orderStatus;
    }

    public String getOrderDate() {
	return orderDate;
    }

    public void setOrderDate(String orderDate) {
	this.orderDate = orderDate;
    }

    public String getPayDate() {
	return payDate;
    }

    public void setPayDate(String payDate) {
	this.payDate = payDate;
    }

    public String getDeliveryDate() {
	return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
	this.deliveryDate = deliveryDate;
    }

}
