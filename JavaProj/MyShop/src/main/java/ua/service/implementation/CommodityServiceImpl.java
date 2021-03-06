package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Category;
import ua.entity.Commodity;
import ua.entity.CommodityOrder;
import ua.entity.CommodityStatus;
import ua.entity.Producer;
import ua.repository.CategoryRepository;
import ua.repository.CommodityRepository;
import ua.repository.CommodityStatusRepository;
import ua.repository.ProducerRepository;
import ua.service.CommodityService;

@Service
@Transactional
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityRepository commodityRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProducerRepository producerRepository;

    @Autowired
    private CommodityStatusRepository commodityStatusRepository;

    @Override
    public void save(String categoryName, String model, String producerName,
	    int quantity, double price, String statusName, int warranty) {
	if (commodityRepository.findByModel(model) == null) {
	    Commodity commodity = new Commodity();
	    Category category = categoryRepository
		    .findByCategoryName(categoryName);
	    if (category != null)
		commodity.setCategory(category);
	    else {
		System.out.println("Model not found");
		return;
	    }
	    Producer producer = producerRepository
		    .findByProducerName(producerName);
	    if (producer != null)
		commodity.setProducer(producer);
	    else {
		System.out.println("Producer not found");
		return;
	    }
	    if (quantity >= 0)
		commodity.setQuantity(quantity);
	    else {
		System.out.println("Invalid Quantity");
		return;
	    }
	    if (price > 0)
		commodity.setPrice(price);
	    else {
		System.out.println("Invalid Price");
		return;
	    }
	    CommodityStatus commodityStatus = commodityStatusRepository
		    .findByCommodityStatusName(statusName);
	    if (commodityStatus != null)
		commodity.setCommodityStatus(commodityStatus);
	    else {
		System.out.println("Commodity Status not found");
		return;
	    }
	    if (warranty >= 0)
		commodity.setWarranty(warranty);
	    else {
		System.out.println("Invalid Warranty");
		return;
	    }
	    if (!model.equals(""))
		commodity.setModel(model);
	    else {
		System.out.println("Invalid ModelName");
		return;
	    }
	    commodityRepository.save(commodity);
	}
    }

    @Override
    public Commodity findByCommodityModel(String commodityModel) {
	return commodityRepository.findByModel(commodityModel);
    }

    @Override
    public void deleteByCommodityModel(String commodityModel) {
	if (commodityRepository.findByModel(commodityModel) != null)
	    commodityRepository.delete(findByCommodityModel(commodityModel));
    }

    @Override
    public List<Commodity> findAll() {
	return commodityRepository.findAll();
    }

    @Override
    public void updateCommodity(String commodityModel, String categoryName,
	    String model, String producerName, int quantity, double price,
	    String statusName, int warranty) {
	if (commodityRepository.findByModel(commodityModel) != null) {
	    Category category = categoryRepository
		    .findByCategoryName(categoryName);
	    if (category != null)
		commodityRepository.findByModel(commodityModel).setCategory(
			category);
	    Producer producer = producerRepository
		    .findByProducerName(producerName);
	    if (producer != null)
		commodityRepository.findByModel(commodityModel).setProducer(
			producer);
	    if (quantity >= 0)
		commodityRepository.findByModel(commodityModel).setQuantity(
			quantity);
	    if (price > 0)
		commodityRepository.findByModel(commodityModel).setPrice(price);
	    CommodityStatus commodityStatus = commodityStatusRepository
		    .findByCommodityStatusName(statusName);
	    if (commodityStatus != null)
		commodityRepository.findByModel(commodityModel)
			.setCommodityStatus(commodityStatus);
	    if (warranty >= 0)
		commodityRepository.findByModel(commodityModel).setWarranty(
			warranty);
	    if (!model.equals(""))
		commodityRepository.findByModel(commodityModel).setModel(model);
	}

    }

    @Override
    public List<CommodityOrder> findCommodityOrdersByCommodityModel(
	    String commodityModel) {
	return commodityRepository.findByModel(commodityModel)
		.getCommodityOrders();
    }

}
