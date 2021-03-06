package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.OrderStatus;
import ua.form.filter.OrderStatusFilter;
import ua.repository.OrderStatusRepository;
import ua.service.OrderStatusService;
import ua.service.implementation.specification.OrderStatusFilterSpecification;

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
    @Transactional(readOnly = true)
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
    @Transactional(readOnly = true)
    public List<OrderStatus> findAll() {
	return orderStatusRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public OrderStatus findOne(int id) {
	return orderStatusRepository.findOne(id);
    }

    @Override
    public void deleteById(int id) throws DataIntegrityViolationException {
	orderStatusRepository.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<OrderStatus> findAll(Pageable pageable) {	
	return orderStatusRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<OrderStatus> findAll(Pageable pageable, OrderStatusFilter filter) {	
	return orderStatusRepository.findAll(new OrderStatusFilterSpecification(filter), pageable);
    }

}
