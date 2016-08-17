package ua.service;

import java.util.List;

import ua.entity.CommodityStatus;

public interface CommodityStatusService {

    void save(CommodityStatus commodityStatus);

    CommodityStatus findByCommodityStatusName(String commodityStatusName);

    void deleteByCommodityStatusName(String commodityStatusName);
    
    void deleteById(int id);

    List<CommodityStatus> findAll();

    CommodityStatus findOne(int id);
}
