package ua.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Commodity;
import ua.entity.User;
import ua.form.CommodityForm;
import ua.form.filter.CommodityFilter;

public interface CommodityService {

    void save(CommodityForm commodityForm);

    Commodity findByCommodityModel(String commodityModel);

    void deleteByCommodityModel(String commodityModel);

    void deleteById(int id) throws DataIntegrityViolationException;

    List<Commodity> findAll();

    CommodityForm findOneForm(int id);

    Commodity findOne(int id);

    Page<Commodity> findAll(Pageable pageable);

    Page<Commodity> findAll(Pageable pageable, CommodityFilter filter);

    void addToCart(int id, User user);
}
