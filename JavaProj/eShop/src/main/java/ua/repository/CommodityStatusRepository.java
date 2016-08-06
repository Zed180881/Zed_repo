package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.CommodityStatus;

public interface CommodityStatusRepository extends
	JpaRepository<CommodityStatus, Integer> {

    CommodityStatus findByCommodityStatusName(String commodityStatusName);
}
