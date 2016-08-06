package ua.service;

import java.util.List;

import ua.entity.Commodity;
import ua.entity.CommodityOrder;

public interface CommodityOrderService {

    void save(String userName, String orderStatusName, String orderDate,
	    String payDate, String deliveryDate, String commodityModel1,
	    String commodityModel2, String commodityModel3,
	    String commodityModel4, String commodityModel5);

    CommodityOrder findByOrderID(String orderID);

    void deleteByOrderID(String orderID);

    List<CommodityOrder> findAll();

    void updateCommodityOrder(String orderID, String orderStatusName,
	    String payDate, String deliveryDate);

    List<Commodity> findCommoditiesByOrderID(String orderID);

}
