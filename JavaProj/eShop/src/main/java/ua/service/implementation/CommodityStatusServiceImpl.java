package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.CommodityStatus;
import ua.form.filter.CommodityStatusFilter;
import ua.repository.CommodityStatusRepository;
import ua.service.CommodityStatusService;
import ua.service.implementation.specification.CommodityStatusFilterSpecification;

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
    @Transactional(readOnly = true)
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
    @Transactional(readOnly = true)
    public List<CommodityStatus> findAll() {
	return commodityStatusRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public CommodityStatus findOne(int id) {
	return commodityStatusRepository.findOne(id);
    }

    @Override
    public void deleteById(int id) throws DataIntegrityViolationException {
	commodityStatusRepository.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CommodityStatus> findAll(Pageable pageable) {
	return commodityStatusRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CommodityStatus> findAll(Pageable pageable,
	    CommodityStatusFilter filter) {	
	return commodityStatusRepository.findAll(new CommodityStatusFilterSpecification(filter), pageable);
    }
}
