package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Commodity;
import ua.entity.Producer;
import ua.repository.ProducerRepository;
import ua.service.ProducerService;

@Service
@Transactional
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private ProducerRepository producerRepository;

    @Override
    public void save(String producerName) {
	if (producerRepository.findByProducerName(producerName) == null)
	    producerRepository.save(new Producer(producerName));
    }

    @Override
    public Producer findByProducerName(String producerName) {
	return producerRepository.findByProducerName(producerName);
    }

    @Override
    public void deleteByProducerName(String producerName) {
	if (producerRepository.findByProducerName(producerName) != null)
	    producerRepository.delete(findByProducerName(producerName));
    }

    @Override
    public List<Producer> findAll() {
	return producerRepository.findAll();
    }

    @Override
    public void updateProducer(String producerName, String newProducerName) {
	if (producerRepository.findByProducerName(producerName) != null
		&& !newProducerName.equals(""))
	    producerRepository.findByProducerName(producerName)
		    .setProducerName(newProducerName);
    }

    @Override
    public List<Commodity> findCommoditiesByProducer(String producerName) {
	return producerRepository.findByProducerName(producerName)
		.getCommodities();
    }

}
