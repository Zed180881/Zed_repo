package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.CommodityOrder;
import ua.form.CommodityOrderForm;
import ua.form.filter.CommodityOrderFilter;

public interface CommodityOrderService {

    void save(CommodityOrderForm commodityOrderForm);

    CommodityOrder findByOrderID(String orderID);

    void deleteById(int id);

    List<CommodityOrder> findAll();

    CommodityOrderForm findOne(int id);

    void addCommodity(int id, int commodityID);

    void deleteCommodity(int id, int commodityID);

    Page<CommodityOrder> findAll(Pageable pageable);

    Page<CommodityOrder> findAll(Pageable pageable, CommodityOrderFilter filter);
}
