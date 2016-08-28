package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Producer;
import ua.form.filter.ProducerFilter;

public interface ProducerService {

    void save(Producer producer);

    Producer findByProducerName(String producerName);

    void deleteByProducerName(String producerName);

    void deleteById(int id);

    List<Producer> findAll();

    Producer findOne(int id);

    Page<Producer> findAll(Pageable pageable);

    Page<Producer> findAll(Pageable pageable, ProducerFilter filter);
}
