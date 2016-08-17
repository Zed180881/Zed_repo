package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.CommodityStatus;
import ua.repository.CommodityStatusRepository;
import ua.service.CommodityStatusService;

@Service
@Transactional
public class CommodityStatusServiceImpl implements CommodityStatusService {
    private CommodityStatus commodityStatus;

    @Autowired
    private CommodityStatusRepository commodityStatusRepository;

    @Override
    public void save(CommodityStatus commodityStatus) {
	commodityStatusRepository.save(commodityStatus);
    }

    @Override
    public CommodityStatus findByCommodityStatusName(String commodityStatusName) {
	return commodityStatusRepository
		.findByCommodityStatusName(commodityStatusName);
    }

    @Override
    public void deleteByCommodityStatusName(String commodityStatusName) {
	if ((commodityStatus = commodityStatusRepository
		.findByCommodityStatusName(commodityStatusName)) != null)
	    commodityStatusRepository.delete(commodityStatus);
    }

    @Override
    public List<CommodityStatus> findAll() {
	return commodityStatusRepository.findAll();
    }

    @Override
    public CommodityStatus findOne(int id) {
	return commodityStatusRepository.findOne(id);
    }

    @Override
    public void deleteById(int id) {
	commodityStatusRepository.delete(id);
    }
}
