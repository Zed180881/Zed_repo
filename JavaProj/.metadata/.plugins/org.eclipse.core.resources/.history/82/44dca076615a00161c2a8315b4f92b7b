package ua.service;

import java.util.List;

import ua.entity.CommodityOrder;
import ua.entity.OrderStatus;

public interface OrderStatusService {

    void save(String orderStatusName);

    OrderStatus findByOrderStatusName(String orderStatusName);

    void deleteByOrderStatusName(String orderStatusName);

    List<OrderStatus> findAll();

    void updateOrderStatus(String orderStatusName, String newOrderStatusName);

    List<CommodityOrder> findCommodityOrdersByOrderStatus(String orderStatusName);

}
