package ua.entity;

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
public class Commodity {

    private int id;

    private Category category;

    private String model;

    private Producer producer;

    private int quantity;

    private double price;

    private CommodityStatus commodityStatus;

    private int warranty;

    private List<CommodityOrder> commodityOrders = new ArrayList<>();

    public Commodity() {
    }

    public Commodity(Category category, String model, Producer producer,
	    int quantity, double price, CommodityStatus commodityStatus,
	    int warranty) {
	this.category = category;
	this.model = model;
	this.producer = producer;
	this.quantity = quantity;
	this.price = price;
	this.commodityStatus = commodityStatus;
	this.warranty = warranty;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
	return id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Category getCategory() {
	return category;
    }

    public String getModel() {
	return model;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Producer getProducer() {
	return producer;
    }

    public int getQuantity() {
	return quantity;
    }

    public double getPrice() {
	return price;
    }

    public int getWarranty() {
	return warranty;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public CommodityStatus getCommodityStatus() {
	return commodityStatus;
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "commodities")
    public List<CommodityOrder> getCommodityOrders() {
	return commodityOrders;
    }

    public void setId(int id) {
	this.id = id;
    }

    public void setCategory(Category category) {
	this.category = category;
    }

    public void setModel(String model) {
	this.model = model;
    }

    public void setProducer(Producer producer) {
	this.producer = producer;
    }

    public void setQuantity(int quantity) {
	this.quantity = quantity;
    }

    public void setPrice(double price) {
	this.price = price;
    }

    public void setWarranty(int warranty) {
	this.warranty = warranty;
    }

    public void setCommodityStatus(CommodityStatus commodityStatus) {
	this.commodityStatus = commodityStatus;
    }

    public void setCommodityOrders(List<CommodityOrder> commodityOrders) {
	this.commodityOrders = commodityOrders;
    }
}
