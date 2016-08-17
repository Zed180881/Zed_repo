package ua.service;

import java.util.List;

import ua.entity.CommodityOrder;
import ua.form.CommodityOrderForm;

public interface CommodityOrderService {

    void save(CommodityOrderForm commodityOrderForm);

    CommodityOrder findByOrderID(String orderID);

    void deleteById(int id);

    List<CommodityOrder> findAll();

    CommodityOrderForm findOne(int id);

    void addCommodity(int id, int commodityID);

    void deleteCommodity(int id, int commodityID);
}
