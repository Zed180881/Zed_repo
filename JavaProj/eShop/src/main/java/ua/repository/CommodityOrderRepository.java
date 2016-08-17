package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.CommodityOrder;

public interface CommodityOrderRepository extends
	JpaRepository<CommodityOrder, Integer> {
    
    @Query("SELECT DISTINCT co FROM CommodityOrder co LEFT JOIN FETCH co.user LEFT JOIN FETCH co.orderStatus LEFT JOIN FETCH co.commodities ORDER BY co.id")
    List<CommodityOrder> findAll();
    
    @Query("SELECT co FROM CommodityOrder co LEFT JOIN FETCH co.user LEFT JOIN FETCH co.orderStatus LEFT JOIN FETCH co.commodities com LEFT JOIN FETCH com.category LEFT JOIN FETCH com.producer LEFT JOIN FETCH com.commodityStatus WHERE co.id=:id")
    CommodityOrder findOne(@Param("id") int id);
}
