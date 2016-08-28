package ua.form;

import org.springframework.web.multipart.MultipartFile;

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

    private String path;

    private int version;

    private MultipartFile file;

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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    } 
}
