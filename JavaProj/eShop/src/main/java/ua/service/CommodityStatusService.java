package ua.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.CommodityStatus;
import ua.form.filter.CommodityStatusFilter;

public interface CommodityStatusService {

    void save(CommodityStatus commodityStatus);

    CommodityStatus findByCommodityStatusName(String commodityStatusName);

    void deleteByCommodityStatusName(String commodityStatusName);

    void deleteById(int id) throws DataIntegrityViolationException;

    List<CommodityStatus> findAll();

    CommodityStatus findOne(int id);

    Page<CommodityStatus> findAll(Pageable pageable);

    Page<CommodityStatus> findAll(Pageable pageable,
	    CommodityStatusFilter filter);
}
