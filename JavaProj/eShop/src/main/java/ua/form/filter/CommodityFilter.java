package ua.form.filter;

public class CommodityFilter {

    private String model;

    private int categoryId;

    private int producerId;

    private int commodityStatusId;

    private int minQuantity;

    private int maxQuantity;

    private double minPrice;

    private double maxPrice;

    private int minWarranty;

    private int maxWarranty;

    public String getModel() {
	return model;
    }

    public void setModel(String model) {
	this.model = model;
    }

    public int getCategoryId() {
	return categoryId;
    }

    public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
    }

    public int getProducerId() {
	return producerId;
    }

    public void setProducerId(int producerId) {
	this.producerId = producerId;
    }

    public int getCommodityStatusId() {
	return commodityStatusId;
    }

    public void setCommodityStatusId(int commodityStatusId) {
	this.commodityStatusId = commodityStatusId;
    }

    public int getMinQuantity() {
	return minQuantity;
    }

    public void setMinQuantity(int minQuantity) {
	this.minQuantity = minQuantity;
    }

    public int getMaxQuantity() {
	return maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
	this.maxQuantity = maxQuantity;
    }

    public double getMinPrice() {
	return minPrice;
    }

    public void setMinPrice(double minPrice) {
	this.minPrice = minPrice;
    }

    public double getMaxPrice() {
	return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
	this.maxPrice = maxPrice;
    }

    public int getMinWarranty() {
	return minWarranty;
    }

    public void setMinWarranty(int minWarranty) {
	this.minWarranty = minWarranty;
    }

    public int getMaxWarranty() {
	return maxWarranty;
    }

    public void setMaxWarranty(int maxWarranty) {
	this.maxWarranty = maxWarranty;
    }

    @Override
    public String toString() {
	return "CommodityFilter [model=" + model + ", categoryId=" + categoryId
		+ ", producerId=" + producerId + ", commodityStatusId="
		+ commodityStatusId + ", minQuantity=" + minQuantity
		+ ", maxQuantity=" + maxQuantity + ", minPrice=" + minPrice
		+ ", maxPrice=" + maxPrice + ", minWarranty=" + minWarranty
		+ ", maxWarranty=" + maxWarranty + "]";
    }

}
