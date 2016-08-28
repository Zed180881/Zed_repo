package ua.service.implementation.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.entity.CommodityStatus;
import ua.form.filter.CommodityStatusFilter;

public class CommodityStatusFilterSpecification implements
	Specification<CommodityStatus> {

    private final CommodityStatusFilter filter;

    public CommodityStatusFilterSpecification(CommodityStatusFilter filter) {
	this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<CommodityStatus> root,
	    CriteriaQuery<?> query, CriteriaBuilder cb) {
	if (filter != null && filter.getCommodityStatusName() != null
		&& !filter.getCommodityStatusName().isEmpty())
	    return cb.like(cb.lower(root.get("commodityStatusName")), "%"
		    + filter.getCommodityStatusName().toLowerCase() + "%");
	return null;
    }
}
