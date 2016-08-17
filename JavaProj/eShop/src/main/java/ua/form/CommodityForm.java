package ua.form;

import ua.entity.Category;
import ua.entity.CommodityStatus;
import ua.entity.Producer;

public class CommodityForm {

    private int id;

    private Category category;

    private String model;

    private Producer producer;

    private String quantity;

    private String price;

    private CommodityStatus commodityStatus;

    private String warranty;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public Category getCategory() {
	return category;
    }

    public void setCategory(Category category) {
	this.category = category;
    }

    public String getModel() {
	return model;
    }

    public void setModel(String model) {
	this.model = model;
    }

    public Producer getProducer() {
	return producer;
    }

    public void setProducer(Producer producer) {
	this.producer = producer;
    }

    public String getQuantity() {
	return quantity;
    }

    public void setQuantity(String quantity) {
	this.quantity = quantity;
    }

    public String getPrice() {
	return price;
    }

    public void setPrice(String price) {
	this.price = price;
    }

    public CommodityStatus getCommodityStatus() {
	return commodityStatus;
    }

    public void setCommodityStatus(CommodityStatus commodityStatus) {
	this.commodityStatus = commodityStatus;
    }

    public String getWarranty() {
	return warranty;
    }

    public void setWarranty(String warranty) {
	this.warranty = warranty;
    }
}
