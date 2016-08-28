package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.OrderStatus;

public interface OrderStatusRepository extends
	JpaRepository<OrderStatus, Integer>,
	JpaSpecificationExecutor<OrderStatus> {

    OrderStatus findByOrderStatusName(String orderStatusName);

}
