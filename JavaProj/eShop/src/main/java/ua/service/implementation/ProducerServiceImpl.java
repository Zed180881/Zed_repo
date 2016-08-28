package ua.service.implementation;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Producer;
import ua.form.filter.ProducerFilter;
import ua.repository.ProducerRepository;
import ua.service.ProducerService;
import ua.service.implementation.specification.ProducerFilterSpecification;

@Service
@Transactional
public class ProducerServiceImpl implements ProducerService {
    private Producer producer;

    @Autowired
    private ProducerRepository producerRepository;

    @Override
    public void save(Producer producer) {
	producerRepository.saveAndFlush(producer);
	if (producer.getFile() != null && !producer.getFile().isEmpty()) {
	    int index = producer.getFile().getOriginalFilename()
		    .lastIndexOf(".");
	    String extension = producer.getFile().getOriginalFilename()
		    .substring(index);
	    String path = System.getProperty("catalina.home")
		    + "/images/producer/";
	    File file = new File(path);
	    if (!file.exists())
		file.mkdirs();
	    file = new File(file, producer.getId() + extension);
	    try {
		producer.getFile().transferTo(file);
	    } catch (IllegalStateException | IOException e) {		
	    }
	    producer.setPath(extension);
	    producer.setVersion(producer.getVersion() + 1);
	    producerRepository.save(producer);
	}
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

    @Override
    public Page<Producer> findAll(Pageable pageable) {
	return producerRepository.findAll(pageable);
    }

    @Override
    public Page<Producer> findAll(Pageable pageable, ProducerFilter filter) {
	return producerRepository.findAll(new ProducerFilterSpecification(
		filter), pageable);
    }
}
