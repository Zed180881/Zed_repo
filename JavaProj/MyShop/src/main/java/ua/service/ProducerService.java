package ua.service;

import java.util.List;

import ua.entity.Commodity;
import ua.entity.Producer;

public interface ProducerService {

    void save(String producerName);

    Producer findByProducerName(String producerName);

    void deleteByProducerName(String producerName);

    List<Producer> findAll();

    void updateProducer(String producerName, String newProducerName);

    List<Commodity> findCommoditiesByProducer(String producerName);

}
