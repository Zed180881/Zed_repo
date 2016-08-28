package ua.service.implementation.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.entity.Producer;
import ua.form.filter.ProducerFilter;

public class ProducerFilterSpecification implements Specification<Producer> {

    private final ProducerFilter filter;

    public ProducerFilterSpecification(ProducerFilter filter) {
	this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<Producer> root, CriteriaQuery<?> query,
	    CriteriaBuilder cb) {
	if (filter != null && filter.getProducerName() != null
		&& !filter.getProducerName().isEmpty())
	    return cb.like(cb.lower(root.get("producerName")), "%"
		    + filter.getProducerName().toLowerCase() + "%");
	return null;
    }

}
