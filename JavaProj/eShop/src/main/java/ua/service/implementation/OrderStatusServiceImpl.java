package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.OrderStatus;
import ua.repository.OrderStatusRepository;
import ua.service.OrderStatusService;

@Service
@Transactional
public class OrderStatusServiceImpl implements OrderStatusService {
    private OrderStatus orderStatus;

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @Override
    public void save(OrderStatus orderStatus) {
	orderStatusRepository.save(orderStatus);
    }

    @Override
    public OrderStatus findByOrderStatusName(String orderStatusName) {
	return orderStatusRepository.findByOrderStatusName(orderStatusName);
    }

    @Override
    public void deleteByOrderStatusName(String orderStatusName) {
	if ((orderStatus = orderStatusRepository
		.findByOrderStatusName(orderStatusName)) != null)
	    orderStatusRepository.delete(orderStatus);
    }

    @Override
    public List<OrderStatus> findAll() {
	return orderStatusRepository.findAll();
    }

    @Override
    public OrderStatus findOne(int id) {
	return orderStatusRepository.findOne(id);
    }

    @Override
    public void deleteById(int id) {
	orderStatusRepository.delete(id);
    }

}
