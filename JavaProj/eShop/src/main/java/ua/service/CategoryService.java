package ua.service;

import java.util.List;

import ua.entity.Category;

public interface CategoryService {

    void save(Category category);

    Category findByCategoryName(String categoryName);

    void deleteByCategoryName(String categoryName);

    void deleteById(int id);

    List<Category> findAll();

    Category findOne(int id);
}
