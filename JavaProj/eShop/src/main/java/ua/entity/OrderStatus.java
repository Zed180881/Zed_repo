package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class OrderStatus {

    private int id;

    private String orderStatusName;

    private List<CommodityOrder> commodityOrders = new ArrayList<CommodityOrder>();    

    public OrderStatus() {	
    }
    
    public OrderStatus(String orderStatusName) {
	this.orderStatusName = orderStatusName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
	return id;
    }

    public String getOrderStatusName() {
	return orderStatusName;
    }

    @OneToMany(mappedBy = "orderStatus")
    public List<CommodityOrder> getCommodityOrders() {
	return commodityOrders;
    }

    public void setId(int id) {
	this.id = id;
    }

    public void setOrderStatusName(String orderStatusName) {
	this.orderStatusName = orderStatusName;
    }

    public void setCommodityOrders(List<CommodityOrder> commodityOrders) {
	this.commodityOrders = commodityOrders;
    }
}
