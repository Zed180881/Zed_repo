package ua.service;

import java.util.List;

import ua.entity.Commodity;
import ua.form.CommodityForm;

public interface CommodityService {

    void save(CommodityForm commodityForm);

    Commodity findByCommodityModel(String commodityModel);

    void deleteByCommodityModel(String commodityModel);

    void deleteById(int id);

    List<Commodity> findAll();

    CommodityForm findOneForm(int id);

    Commodity findOne(int id);
}
