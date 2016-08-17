package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Producer;
import ua.repository.ProducerRepository;
import ua.service.ProducerService;

@Service
@Transactional
public class ProducerServiceImpl implements ProducerService {
    private Producer producer;

    @Autowired
    private ProducerRepository producerRepository;

    @Override
    public void save(Producer producer) {
	producerRepository.save(producer);
    }

    @Override
    public Producer findByProducerName(String producerName) {
	return producerRepository.findByProducerName(producerName);
    }

    @Override
    public void deleteByProducerName(String producerName) {
	if ((producer = producerRepository.findByProducerName(producerName)) != null)
	    producerRepository.delete(producer);
    }

    @Override
    public List<Producer> findAll() {
	return producerRepository.findAll();
    }

    @Override
    public Producer findOne(int id) {
	return producerRepository.findOne(id);
    }

    @Override
    public void deleteById(int id) {
	producerRepository.delete(id);
    }
}
