package ua.service.implementation.specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import ua.entity.Commodity;
import ua.entity.CommodityOrder;
import ua.form.filter.CommodityOrderFilter;

public class CommodityOrderFilterSpecification implements
	Specification<CommodityOrder> {

    private final CommodityOrderFilter filter;

    private final List<Specification<CommodityOrder>> list = new ArrayList<>();

    public CommodityOrderFilterSpecification(CommodityOrderFilter filter) {
	this.filter = filter;
    }

    private void findByUserId() {
	if (filter.getUserId() > 0) {
	    list.add((root, cq, cb) -> root.get("user").in(filter.getUserId()));
	}
    }

    private void findByOrderStatusId() {
	if (filter.getOrderStatusId() > 0) {
	    list.add((root, cq, cb) -> root.get("orderStatus").in(
		    filter.getOrderStatusId()));
	}
    }

    private void findByCommodityId() {
	if (filter.getCommodityId() > 0) {
	    list.add((root, cq, cb) -> {
		Join<Commodity, CommodityOrder> join = root.join("commodities");
		return join.get("id").in(filter.getCommodityId());
	    });
	}
    }

    private void findByMaxMinSum() {
	if (filter.getMaxSum() > 0 && filter.getMinSum() > 0) {
	    list.add((root, cq, cb) -> {
		Expression<Double> exp = root.get("sum");
		return cb.between(exp, filter.getMinSum(), filter.getMaxSum());
	    });
	} else if (filter.getMaxSum() > 0) {
	    list.add((root, cq, cb) -> {
		Expression<Double> exp = root.get("sum");
		return cb.lessThan(exp, filter.getMaxSum());
	    });
	} else if (filter.getMinSum() > 0) {
	    list.add((root, cq, cb) -> {
		Expression<Double> exp = root.get("sum");
		return cb.greaterThan(exp, filter.getMinSum());
	    });
	}
    }

    private void findByMaxMinOrderDate() {
	if (filter.getMaxOrderDate() != null
		&& filter.getMinOrderDate() != null) {
	    list.add((root, cq, cb) -> {
		Expression<LocalDate> exp = root.get("orderDate");
		return cb.between(exp, filter.getMinOrderDate(),
			filter.getMaxOrderDate());
	    });
	} else if (filter.getMaxOrderDate() != null) {
	    list.add((root, cq, cb) -> {
		Expression<LocalDate> exp = root.get("orderDate");
		return cb.lessThan(exp, filter.getMaxOrderDate());
	    });
	} else if (filter.getMinOrderDate() != null) {
	    list.add((root, cq, cb) -> {
		Expression<LocalDate> exp = root.get("orderDate");
		return cb.greaterThan(exp, filter.getMinOrderDate());
	    });
	}
    }

    private void findByMaxMinPayDate() {
	if (filter.getMaxPayDate() != null && filter.getMinPayDate() != null) {
	    list.add((root, cq, cb) -> {
		Expression<LocalDate> exp = root.get("payDate");
		return cb.between(exp, filter.getMinPayDate(),
			filter.getMaxPayDate());
	    });
	} else if (filter.getMaxPayDate() != null) {
	    list.add((root, cq, cb) -> {
		Expression<LocalDate> exp = root.get("payDate");
		return cb.lessThan(exp, filter.getMaxPayDate());
	    });
	} else if (filter.getMinPayDate() != null) {
	    list.add((root, cq, cb) -> {
		Expression<LocalDate> exp = root.get("payDate");
		return cb.greaterThan(exp, filter.getMinPayDate());
	    });
	}
    }

    private void findByMaxMinDeliveryDate() {
	if (filter.getMaxDeliveryDate() != null
		&& filter.getMinDeliveryDate() != null) {
	    list.add((root, cq, cb) -> {
		Expression<LocalDate> exp = root.get("deliveryDate");
		return cb.between(exp, filter.getMinDeliveryDate(),
			filter.getMaxDeliveryDate());
	    });
	} else if (filter.getMaxDeliveryDate() != null) {
	    list.add((root, cq, cb) -> {
		Expression<LocalDate> exp = root.get("deliveryDate");
		return cb.lessThan(exp, filter.getMaxDeliveryDate());
	    });
	} else if (filter.getMinDeliveryDate() != null) {
	    list.add((root, cq, cb) -> {
		Expression<LocalDate> exp = root.get("deliveryDate");
		return cb.greaterThan(exp, filter.getMinDeliveryDate());
	    });
	}
    }

    @Override
    public Predicate toPredicate(Root<CommodityOrder> root,
	    CriteriaQuery<?> query, CriteriaBuilder cb) {
	if (query.getResultType() != Long.class
		&& query.getResultType() != long.class) {
	    root.fetch("user", JoinType.LEFT);
	    root.fetch("orderStatus", JoinType.LEFT);
	    root.fetch("commodities", JoinType.LEFT);
	    query.orderBy(cb.asc(root.get("id")));
	}
	if (filter != null) {
	    findByUserId();
	    findByOrderStatusId();
	    findByCommodityId();
	    findByMaxMinSum();
	    findByMaxMinOrderDate();
	    findByMaxMinPayDate();
	    findByMaxMinDeliveryDate();
	}
	if (list.size() == 0)
	    return null;
	Specifications<CommodityOrder> spec = Specifications.where(list.get(0));
	for (int i = 1; i < list.size(); i++) {
	    spec = spec.and(list.get(i));
	}
	return spec.toPredicate(root, query, cb);
    }

}
