package lesson01;

import java.util.Date;
import java.util.List;

public class Order {

    private int id;

    private List<Commodity> commodities;

    private double sum;

    private OrderStatus orderStatus;

    private Date order_date;

    private Date pay_date;

    private Date delivery_date;

    
    
    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public List<Commodity> getGoods() {
	return commodities;
    }

    public void setGoods(List<Commodity> goods) {
	this.commodities = goods;
    }

    public double getSum() {
	return sum;
    }

    public void setSum(double sum) {
	this.sum = sum;
    }

    public OrderStatus getOrderStatus() {
	return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
	this.orderStatus = orderStatus;
    }

    public Date getOrder_date() {
	return order_date;
    }

    public void setOrder_date(Date order_date) {
	this.order_date = order_date;
    }

    public Date getPay_date() {
	return pay_date;
    }

    public void setPay_date(Date pay_date) {
	this.pay_date = pay_date;
    }

    public Date getDelivery_date() {
	return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
	this.delivery_date = delivery_date;
    }
}
