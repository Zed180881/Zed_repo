package ua.service.implementation.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import ua.entity.Commodity;
import ua.form.filter.CommodityFilter;

public class CommodityFilterSpecification implements Specification<Commodity> {

    private final CommodityFilter filter;

    private final List<Specification<Commodity>> list = new ArrayList<>();

    public CommodityFilterSpecification(CommodityFilter filter) {
	this.filter = filter;
    }

    private void findByModel() {
	if (filter.getModel() != null) {
	    list.add((root, cq, cb) -> cb.like(cb.lower(root.get("model")), "%"
		    + filter.getModel().toLowerCase() + "%"));
	}
    }

    private void findByCategoryId() {
	if (filter.getCategoryId() > 0) {
	    list.add((root, cq, cb) -> root.get("category").in(
		    filter.getCategoryId()));
	}
    }

    private void findByProducerId() {
	if (filter.getProducerId() > 0) {
	    list.add((root, cq, cb) -> root.get("producer").in(
		    filter.getProducerId()));
	}
    }

    private void findByCommodityStatusId() {
	if (filter.getCommodityStatusId() > 0) {
	    list.add((root, cq, cb) -> root.get("commodityStatus").in(
		    filter.getCommodityStatusId()));
	}
    }

    private void findByMaxMinQuantity() {
	if (filter.getMaxQuantity() > 0 && filter.getMinQuantity() > 0) {
	    list.add((root, cq, cb) -> {
		Expression<Integer> exp = root.get("quantity");
		return cb.between(exp, filter.getMinQuantity(),
			filter.getMaxQuantity());
	    });
	} else if (filter.getMaxQuantity() > 0) {
	    list.add((root, cq, cb) -> {
		Expression<Integer> exp = root.get("quantity");
		return cb.lessThan(exp, filter.getMaxQuantity());
	    });
	} else if (filter.getMinQuantity() > 0) {
	    list.add((root, cq, cb) -> {
		Expression<Integer> exp = root.get("quantity");
		return cb.greaterThan(exp, filter.getMinQuantity());
	    });
	}
    }

    private void findByMaxMinPrice() {
	if (filter.getMaxPrice() > 0 && filter.getMinPrice() > 0) {
	    list.add((root, cq, cb) -> {
		Expression<Double> exp = root.get("price");
		return cb.between(exp, filter.getMinPrice(),
			filter.getMaxPrice());
	    });
	} else if (filter.getMaxPrice() > 0) {
	    list.add((root, cq, cb) -> {
		Expression<Double> exp = root.get("price");
		return cb.lessThan(exp, filter.getMaxPrice());
	    });
	} else if (filter.getMinPrice() > 0) {
	    list.add((root, cq, cb) -> {
		Expression<Double> exp = root.get("price");
		return cb.greaterThan(exp, filter.getMinPrice());
	    });
	}
    }

    private void findByMaxMinWarranty() {
	if (filter.getMaxWarranty() > 0 && filter.getMinWarranty() > 0) {
	    list.add((root, cq, cb) -> {
		Expression<Integer> exp = root.get("warranty");
		return cb.between(exp, filter.getMinWarranty(),
			filter.getMaxWarranty());
	    });
	} else if (filter.getMaxWarranty() > 0) {
	    list.add((root, cq, cb) -> {
		Expression<Integer> exp = root.get("warranty");
		return cb.lessThan(exp, filter.getMaxWarranty());
	    });
	} else if (filter.getMinWarranty() > 0) {
	    list.add((root, cq, cb) -> {
		Expression<Integer> exp = root.get("warranty");
		return cb.greaterThan(exp, filter.getMinWarranty());
	    });
	}
    }

    @Override
    public Predicate toPredicate(Root<Commodity> root, CriteriaQuery<?> query,
	    CriteriaBuilder cb) {
	if (query.getResultType() != Long.class
		&& query.getResultType() != long.class) {
	    root.fetch("category");
	    root.fetch("producer");
	    root.fetch("commodityStatus");
	    query.distinct(true);
	}
	if (filter != null) {
	    findByModel();
	    findByCategoryId();
	    findByProducerId();
	    findByCommodityStatusId();
	    findByMaxMinQuantity();
	    findByMaxMinPrice();
	    findByMaxMinWarranty();
	}
	if (list.size() == 0)
	    return null;
	Specifications<Commodity> spec = Specifications.where(list.get(0));
	for (int i = 1; i < list.size(); i++) {
	    spec = spec.and(list.get(i));
	}
	return spec.toPredicate(root, query, cb);
    }

}
