package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Commodity;
import ua.form.CommodityForm;
import ua.repository.CategoryRepository;
import ua.repository.CommodityRepository;
import ua.repository.CommodityStatusRepository;
import ua.repository.ProducerRepository;
import ua.service.CommodityService;

@Service
@Transactional
public class CommodityServiceImpl implements CommodityService {

    private Commodity commodity;

    @Autowired
    private CommodityRepository commodityRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProducerRepository producerRepository;

    @Autowired
    private CommodityStatusRepository commodityStatusRepository;

    @Override
    public void save(CommodityForm commodityForm) {
	commodity = new Commodity();
	commodity.setId(commodityForm.getId());
	commodity.setModel(commodityForm.getModel());
	commodity.setCategory(commodityForm.getCategory());
	commodity.setCommodityStatus(commodityForm.getCommodityStatus());
	commodity.setPrice(Double.valueOf(commodityForm.getPrice()));
	commodity.setProducer(commodityForm.getProducer());
	commodity.setQuantity(Integer.valueOf(commodityForm.getQuantity()));
	commodity.setWarranty(Integer.valueOf(commodityForm.getWarranty()));
	commodityRepository.save(commodity);
    }

    @Override
    public Commodity findByCommodityModel(String commodityModel) {
	return commodityRepository.findByModel(commodityModel);
    }

    @Override
    public void deleteByCommodityModel(String commodityModel) {
	if ((commodity = commodityRepository.findByModel(commodityModel)) != null)
	    commodityRepository.delete(commodity);
    }

    @Override
    public List<Commodity> findAll() {
	return commodityRepository.findAll();
    }

    @Override
    public CommodityForm findOneForm(int id) {
	commodity = commodityRepository.findOne(id);
	CommodityForm commodityForm = new CommodityForm();
	commodityForm.setId(commodity.getId());
	commodityForm.setCategory(commodity.getCategory());
	commodityForm.setCommodityStatus(commodity.getCommodityStatus());
	commodityForm.setModel(commodity.getModel());
	commodityForm.setPrice(String.valueOf(commodity.getPrice()));
	commodityForm.setProducer(commodity.getProducer());
	commodityForm.setQuantity(String.valueOf(commodity.getQuantity()));
	commodityForm.setWarranty(String.valueOf(commodity.getWarranty()));
	return commodityForm;
    }

    @Override
    public Commodity findOne(int id) {
	return commodityRepository.findOne(id);
    }

    @Override
    public void deleteById(int id) {
	commodityRepository.delete(id);
    }
}
