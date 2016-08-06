package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.CommodityOrder;
import ua.entity.OrderStatus;
import ua.repository.OrderStatusRepository;
import ua.service.OrderStatusService;

@Service
@Transactional
public class OrderStatusServiceImpl implements OrderStatusService {

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @Override
    public void save(String orderStatusName) {
	if (orderStatusRepository.findByOrderStatusName(orderStatusName) == null)
	    orderStatusRepository.save(new OrderStatus(orderStatusName));
    }

    @Override
    public OrderStatus findByOrderStatusName(String orderStatusName) {
	return orderStatusRepository.findByOrderStatusName(orderStatusName);
    }

    @Override
    public void deleteByOrderStatusName(String orderStatusName) {
	if (orderStatusRepository.findByOrderStatusName(orderStatusName) != null)
	    orderStatusRepository
		    .delete(findByOrderStatusName(orderStatusName));
    }

    @Override
    public List<OrderStatus> findAll() {
	return orderStatusRepository.findAll();
    }

    @Override
    public void updateOrderStatus(String orderStatusName,
	    String newOrderStatusName) {
	if (orderStatusRepository.findByOrderStatusName(orderStatusName) != null
		&& !newOrderStatusName.equals(""))
	    orderStatusRepository.findByOrderStatusName(orderStatusName)
		    .setOrderStatusName(newOrderStatusName);

    }

    @Override
    public List<CommodityOrder> findCommodityOrdersByOrderStatus(
	    String orderStatusName) {
	return orderStatusRepository.findByOrderStatusName(orderStatusName)
		.getCommodityOrders();
    }

}
