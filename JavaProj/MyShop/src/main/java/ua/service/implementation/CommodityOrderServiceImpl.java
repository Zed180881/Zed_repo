package ua.service.implementation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Commodity;
import ua.entity.CommodityOrder;
import ua.entity.OrderStatus;
import ua.entity.User;
import ua.repository.CommodityOrderRepository;
import ua.repository.CommodityRepository;
import ua.repository.OrderStatusRepository;
import ua.repository.UserRepository;
import ua.service.CommodityOrderService;

@Service
@Transactional
public class CommodityOrderServiceImpl implements CommodityOrderService {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy"); // 05.09.2015

    @Autowired
    private CommodityOrderRepository commodityOrderRepository;

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommodityRepository commodityRepository;

    @Override
    public void save(String userName, String orderStatusName, String orderDate,
	    String payDate, String deliveryDate, List<String> commodityModels) {

	CommodityOrder commodityOrder = new CommodityOrder();
	User user = userRepository.findByFullName(userName);
	if (user != null)
	    commodityOrder.setUser(user);
	else {
	    System.out.println("User not found");
	    return;
	}
	OrderStatus orderStatus = orderStatusRepository
		.findByOrderStatusName(orderStatusName);
	if (orderStatus != null)
	    commodityOrder.setOrderStatus(orderStatus);
	else {
	    System.out.println("Order Status not found");
	    return;
	}
	try {
	    if (!orderDate.equals(""))
		commodityOrder.setOrderDate(sdf.parse(orderDate));
	    if (!payDate.equals(""))
		commodityOrder.setPayDate(sdf.parse(payDate));
	    if (!deliveryDate.equals(""))
		commodityOrder.setDeliveryDate(sdf.parse(deliveryDate));
	} catch (ParseException e) {
	    System.out.println("Error parsing date.");
	    System.out.println("Please enter date in format dd.mm.yyyy");
	    return;
	}
	List<Commodity> commodities = new ArrayList<>();
	for (String commodityModel : commodityModels) {
	    Commodity commodity = commodityRepository
		    .findByModel(commodityModel);
	    if (commodity != null)
		commodities.add(commodity);
	}
	if (commodities.size() > 0)
	    commodityOrder.setCommodities(commodities);
	else {
	    System.out.println("Order without commodities");
	    return;
	}
	commodityOrder.setSum(commodityOrder.calculateSum());
	commodityOrderRepository.save(commodityOrder);
    }

    @Override
    public CommodityOrder findByOrderID(String orderID) {
	return commodityOrderRepository.findOne(Integer.parseInt(orderID));
    }

    @Override
    public void deleteByOrderID(String orderID) {
	if (commodityOrderRepository.findOne(Integer.parseInt(orderID)) != null)
	    commodityRepository.delete(Integer.parseInt(orderID));
    }

    @Override
    public List<CommodityOrder> findAll() {
	return commodityOrderRepository.findAll();
    }

    @Override
    public void updateCommodityOrder(String orderID, String orderStatusName,
	    String payDate, String deliveryDate) {
	if (commodityOrderRepository.findOne(Integer.parseInt(orderID)) != null) {

	    OrderStatus orderStatus = orderStatusRepository
		    .findByOrderStatusName(orderStatusName);
	    if (orderStatus != null)
		commodityOrderRepository.findOne(Integer.parseInt(orderID))
			.setOrderStatus(orderStatus);

	    try {
		if (!payDate.equals(""))
		    commodityOrderRepository.findOne(Integer.parseInt(orderID))
			    .setPayDate(sdf.parse(payDate));
		if (!deliveryDate.equals(""))
		    commodityOrderRepository.findOne(Integer.parseInt(orderID))
			    .setDeliveryDate(sdf.parse(deliveryDate));
	    } catch (ParseException e) {
		System.out.println("Error parsing date.");
		System.out.println("Please enter date in format dd.mm.yyyy");
	    }
	}

    }

    @Override
    public List<Commodity> findCommoditiesByOrderID(String orderID) {
	return commodityOrderRepository.findOne(Integer.parseInt(orderID))
		.getCommodities();
    }

}
