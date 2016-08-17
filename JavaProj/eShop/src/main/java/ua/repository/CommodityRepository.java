package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.Commodity;

public interface CommodityRepository extends JpaRepository<Commodity, Integer> {

    Commodity findByModel(String commodityModel);

    @Query("SELECT co FROM Commodity co LEFT JOIN FETCH co.category LEFT JOIN FETCH co.producer LEFT JOIN FETCH co.commodityStatus ORDER BY co.id")
    List<Commodity> findAll();
    
    @Query("SELECT co FROM Commodity co LEFT JOIN FETCH co.category LEFT JOIN FETCH co.producer LEFT JOIN FETCH co.commodityStatus WHERE co.id=:id")
    Commodity findOne(@Param("id") int id);
}
