package ua.service;

import java.util.List;

import ua.entity.OrderStatus;

public interface OrderStatusService {

    void save(OrderStatus orderStatus);

    OrderStatus findByOrderStatusName(String orderStatusName);

    void deleteByOrderStatusName(String orderStatusName);
    
    void deleteById(int id);

    List<OrderStatus> findAll();

    OrderStatus findOne(int id);
}
