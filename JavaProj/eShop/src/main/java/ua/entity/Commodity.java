package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(indexes = @Index(columnList = "model"))
public class Commodity {

    private int id;

    private Category category;

    private String model;
    
    private String description;

    private Producer producer;

    private int quantity;

    private double price;

    private CommodityStatus commodityStatus;

    private int warranty;

    private String path;

    private int version;

    private List<CommodityOrder> commodityOrders = new ArrayList<>();

    public Commodity() {
    }   
    
    public Commodity(int id, Category category, String model,
	    String description, Producer producer, int quantity, double price,
	    CommodityStatus commodityStatus, int warranty) {
	this.id = id;
	this.category = category;
	this.model = model;
	this.description = description;
	this.producer = producer;
	this.quantity = quantity;
	this.price = price;
	this.commodityStatus = commodityStatus;
	this.warranty = warranty;
    }

    @Lob
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
	return id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Category getCategory() {
	return category;
    }

    public String getModel() {
	return model;
    }

    @ManyToOne(fetch = FetchType.LAZY)
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

    @ManyToOne(fetch = FetchType.LAZY)
    public CommodityStatus getCommodityStatus() {
	return commodityStatus;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "commodities")
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
