package ua.service;

import java.util.List;

import ua.entity.Commodity;
import ua.entity.CommodityOrder;

public interface CommodityService {

    void save(String categoryName, String model, String producerName,
	    int quantity, double price, String statusName, int warranty);

    Commodity findByCommodityModel(String commodityModel);

    void deleteByCommodityModel(String commodityModel);

    List<Commodity> findAll();

    void updateCommodity(String commodityModel, String categoryName,
	    String model, String producerName, int quantity, double price,
	    String statusName, int warranty);

    List<CommodityOrder> findCommodityOrdersByCommodityModel(
	    String commodityModel);

}
