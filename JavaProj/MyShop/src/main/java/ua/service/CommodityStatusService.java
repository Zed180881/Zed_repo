package ua.service;

import java.util.List;

import ua.entity.Commodity;
import ua.entity.CommodityStatus;

public interface CommodityStatusService {

    void save(String commodityStatusName);

    CommodityStatus findByCommodityStatusName(String commodityStatusName);

    void deleteByCommodityStatusName(String commodityStatusName);

    List<CommodityStatus> findAll();

    void updateCommodityStatus(String commodityStatusName,
	    String newCommodityStatusName);

    List<Commodity> findCommoditiesByCommodityStatus(String commodityStatusName);

}
