package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.CommodityOrder;

public interface CommodityOrderRepository extends
	JpaRepository<CommodityOrder, Integer> {
}
