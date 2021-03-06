package ua.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.Commodity;

public interface CommodityRepository extends JpaRepository<Commodity, Integer>,
	JpaSpecificationExecutor<Commodity> {

    Commodity findByModel(String commodityModel);

    @Query(value = "SELECT co FROM Commodity co LEFT JOIN FETCH co.category LEFT JOIN FETCH co.producer LEFT JOIN FETCH co.commodityStatus ORDER BY co.id", countQuery = "SELECT count(co.id) FROM Commodity co")
    List<Commodity> findAll();
    
    @Query(value = "SELECT co FROM Commodity co LEFT JOIN FETCH co.category LEFT JOIN FETCH co.producer LEFT JOIN FETCH co.commodityStatus ORDER BY co.id", countQuery = "SELECT count(co.id) FROM Commodity co")
    Page<Commodity> findAll(Pageable pageable);  

    @Query("SELECT co FROM Commodity co LEFT JOIN FETCH co.category LEFT JOIN FETCH co.producer LEFT JOIN FETCH co.commodityStatus WHERE co.id=:id")
    Commodity findOne(@Param("id") int id); 
}
