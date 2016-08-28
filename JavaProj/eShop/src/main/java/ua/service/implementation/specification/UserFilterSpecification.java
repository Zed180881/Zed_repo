package ua.service.implementation.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import ua.entity.User;
import ua.form.filter.UserFilter;

public class UserFilterSpecification implements Specification<User> {

    private final UserFilter filter;

    private final List<Specification<User>> list = new ArrayList<>();

    public UserFilterSpecification(UserFilter filter) {
	this.filter = filter;
    }

    private void findByFullName() {
	if (filter.getFullName() != null) {
	    list.add((root, cq, cb) -> cb.like(cb.lower(root.get("fullName")),
		    "%" + filter.getFullName().toLowerCase() + "%"));
	}
    }

    private void findByMail() {
	if (filter.getMail() != null) {
	    list.add((root, cq, cb) -> cb.like(cb.lower(root.get("mail")), "%"
		    + filter.getMail().toLowerCase() + "%"));
	}
    }

    private void findByPhone() {
	if (filter.getPhone() != null) {
	    list.add((root, cq, cb) -> cb.like(cb.lower(root.get("phone")), "%"
		    + filter.getPhone().toLowerCase() + "%"));
	}
    }

    private void findByAddress() {
	if (filter.getAddress() != null) {
	    list.add((root, cq, cb) -> cb.like(cb.lower(root.get("address")),
		    "%" + filter.getAddress().toLowerCase() + "%"));
	}
    }

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query,
	    CriteriaBuilder cb) {
	query.distinct(true);
	if (filter != null) {
	    findByFullName();
	    findByMail();
	    findByPhone();
	    findByAddress();
	}
	if (list.size() == 0)
	    return null;
	Specifications<User> spec = Specifications.where(list
		.get(0));
	for (int i = 1; i < list.size(); i++) {
	    spec = spec.and(list.get(i));
	}
	return spec.toPredicate(root, query, cb);
    }

}
