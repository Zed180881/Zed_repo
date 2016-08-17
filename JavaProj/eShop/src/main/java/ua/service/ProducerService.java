package ua.service;

import java.util.List;

import ua.entity.Producer;

public interface ProducerService {

    void save(Producer producer);

    Producer findByProducerName(String producerName);

    void deleteByProducerName(String producerName);
    
    void deleteById(int id);

    List<Producer> findAll();

    Producer findOne(int id);
}
