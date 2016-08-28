package ua.form.filter;

import java.time.LocalDate;

public class CommodityOrderFilter {

    private int userId;

    private int orderStatusId;

    private int commodityId;

    private LocalDate minOrderDate;

    private LocalDate maxOrderDate;

    private LocalDate minPayDate;

    private LocalDate maxPayDate;

    private LocalDate minDeliveryDate;

    private LocalDate maxDeliveryDate;

    private double minSum;

    private double maxSum;

    public int getUserId() {
	return userId;
    }

    public void setUserId(int userId) {
	this.userId = userId;
    }

    public int getOrderStatusId() {
	return orderStatusId;
    }

    public void setOrderStatusId(int orderStatusId) {
	this.orderStatusId = orderStatusId;
    }

    public int getCommodityId() {
	return commodityId;
    }

    public void setCommodityId(int commodityId) {
	this.commodityId = commodityId;
    }

    public LocalDate getMinOrderDate() {
	return minOrderDate;
    }

    public void setMinOrderDate(LocalDate minOrderDate) {
	this.minOrderDate = minOrderDate;
    }

    public LocalDate getMaxOrderDate() {
	return maxOrderDate;
    }

    public void setMaxOrderDate(LocalDate maxOrderDate) {
	this.maxOrderDate = maxOrderDate;
    }

    public LocalDate getMinPayDate() {
	return minPayDate;
    }

    public void setMinPayDate(LocalDate minPayDate) {
	this.minPayDate = minPayDate;
    }

    public LocalDate getMaxPayDate() {
	return maxPayDate;
    }

    public void setMaxPayDate(LocalDate maxPayDate) {
	this.maxPayDate = maxPayDate;
    }

    public LocalDate getMinDeliveryDate() {
	return minDeliveryDate;
    }

    public void setMinDeliveryDate(LocalDate minDeliveryDate) {
	this.minDeliveryDate = minDeliveryDate;
    }

    public LocalDate getMaxDeliveryDate() {
	return maxDeliveryDate;
    }

    public void setMaxDeliveryDate(LocalDate maxDeliveryDate) {
	this.maxDeliveryDate = maxDeliveryDate;
    }

    public double getMinSum() {
	return minSum;
    }

    public void setMinSum(double minSum) {
	this.minSum = minSum;
    }

    public double getMaxSum() {
	return maxSum;
    }

    public void setMaxSum(double maxSum) {
	this.maxSum = maxSum;
    }

    @Override
    public String toString() {
	return "CommodityOrderFilter [userId=" + userId + ", orderStatusId="
		+ orderStatusId + ", commodityId=" + commodityId
		+ ", minOrderDate=" + minOrderDate + ", maxOrderDate="
		+ maxOrderDate + ", minPayDate=" + minPayDate + ", maxPayDate="
		+ maxPayDate + ", minDeliveryDate=" + minDeliveryDate
		+ ", maxDeliveryDate=" + maxDeliveryDate + ", minSum=" + minSum
		+ ", maxSum=" + maxSum + "]";
    }
}
