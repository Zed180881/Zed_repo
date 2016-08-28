package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.CommodityStatus;

public interface CommodityStatusRepository extends
	JpaRepository<CommodityStatus, Integer>,
	JpaSpecificationExecutor<CommodityStatus> {

    CommodityStatus findByCommodityStatusName(String commodityStatusName);
}
