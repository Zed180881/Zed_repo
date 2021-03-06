package ua.service.implementation.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.entity.Category;
import ua.form.filter.CategoryFilter;

public class CategoryFilterSpecification implements Specification<Category> {

    private final CategoryFilter filter;

    public CategoryFilterSpecification(CategoryFilter filter) {
	this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<Category> root, CriteriaQuery<?> query,
	    CriteriaBuilder cb) {
	if (filter != null && filter.getCategoryName() != null
		&& !filter.getCategoryName().isEmpty()) {
	    return cb.like(cb.lower(root.get("categoryName")), "%"
		    + filter.getCategoryName().toLowerCase() + "%");
	}
	return null;
    }

}
