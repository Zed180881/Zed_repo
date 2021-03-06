package ua.service;

import java.util.List;

import ua.entity.Commodity;
import ua.entity.CommodityOrder;

public interface CommodityOrderService {

    void save(String userName, String orderStatusName, String orderDate,
	    String payDate, String deliveryDate, List<String> commodityModels);

    CommodityOrder findByOrderID(String orderID);

    void deleteByOrderID(String orderID);

    List<CommodityOrder> findAll();

    void updateCommodityOrder(String orderID, String orderStatusName,
	    String payDate, String deliveryDate);

    List<Commodity> findCommoditiesByOrderID(String orderID);

}
