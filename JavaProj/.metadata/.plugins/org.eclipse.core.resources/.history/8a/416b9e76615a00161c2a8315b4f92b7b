package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.OrderStatus;

public interface OrderStatusRepository extends
	JpaRepository<OrderStatus, Integer> {

    OrderStatus findByOrderStatusName(String orderStatusName);

}
