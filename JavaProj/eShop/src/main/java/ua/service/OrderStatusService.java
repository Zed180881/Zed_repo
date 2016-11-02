package ua.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.OrderStatus;
import ua.form.filter.OrderStatusFilter;

public interface OrderStatusService {

    void save(OrderStatus orderStatus);

    OrderStatus findByOrderStatusName(String orderStatusName);

    void deleteByOrderStatusName(String orderStatusName);

    void deleteById(int id) throws DataIntegrityViolationException;

    List<OrderStatus> findAll();

    OrderStatus findOne(int id);

    Page<OrderStatus> findAll(Pageable pageable);

    Page<OrderStatus> findAll(Pageable pageable, OrderStatusFilter filter);
}
