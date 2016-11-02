package ua.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Category;
import ua.form.filter.CategoryFilter;

public interface CategoryService {

    void save(Category category);

    Category findByCategoryName(String categoryName);

    void deleteByCategoryName(String categoryName);

    void deleteById(int id) throws DataIntegrityViolationException;

    List<Category> findAll();

    Category findOne(int id);

    Page<Category> findAll(Pageable pageable);

    Page<Category> findAll(Pageable pageable, CategoryFilter filter);
}
