package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Commodity;
import ua.entity.CommodityStatus;
import ua.repository.CommodityStatusRepository;
import ua.service.CommodityStatusService;

@Service
@Transactional
public class CommodityStatusServiceImpl implements CommodityStatusService {

    @Autowired
    private CommodityStatusRepository commodityStatusRepository;

    @Override
    public void save(String commodityStatusName) {
	if (commodityStatusRepository
		.findByCommodityStatusName(commodityStatusName) == null)
	    commodityStatusRepository.save(new CommodityStatus(
		    commodityStatusName));
    }

    @Override
    public CommodityStatus findByCommodityStatusName(String commodityStatusName) {
	return commodityStatusRepository
		.findByCommodityStatusName(commodityStatusName);
    }

    @Override
    public void deleteByCommodityStatusName(String commodityStatusName) {
	if (commodityStatusRepository
		.findByCommodityStatusName(commodityStatusName) != null)
	    commodityStatusRepository
		    .delete(findByCommodityStatusName(commodityStatusName));
    }

    @Override
    public List<CommodityStatus> findAll() {
	return commodityStatusRepository.findAll();
    }

    @Override
    public void updateCommodityStatus(String commodityStatusName,
	    String newCommodityStatusName) {
	if (commodityStatusRepository
		.findByCommodityStatusName(commodityStatusName) != null
		&& !newCommodityStatusName.equals(""))
	    commodityStatusRepository.findByCommodityStatusName(
		    commodityStatusName).setCommodityStatusName(
		    newCommodityStatusName);

    }

    @Override
    public List<Commodity> findCommoditiesByCommodityStatus(
	    String commodityStatusName) {
	return commodityStatusRepository.findByCommodityStatusName(
		commodityStatusName).getCommodities();
    }

}
