package ua.service.implementation.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.entity.OrderStatus;
import ua.form.filter.OrderStatusFilter;

public class OrderStatusFilterSpecification implements
	Specification<OrderStatus> {

    private final OrderStatusFilter filter;

    public OrderStatusFilterSpecification(OrderStatusFilter filter) {
	this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<OrderStatus> root,
	    CriteriaQuery<?> query, CriteriaBuilder cb) {
	if (filter != null && filter.getOrderStatusName() != null
		&& !filter.getOrderStatusName().isEmpty())
	    return cb.like(cb.lower(root.get("orderStatusName")), "%"
		    + filter.getOrderStatusName().toLowerCase() + "%");
	return null;
    }
}
