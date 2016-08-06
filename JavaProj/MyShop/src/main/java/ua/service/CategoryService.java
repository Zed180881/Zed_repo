package ua.service;

import java.util.List;

import ua.entity.Category;
import ua.entity.Commodity;

public interface CategoryService {

    void save(String categoryName);

    Category findByCategoryName(String categoryName);

    void deleteByCategoryName(String categoryName);

    List<Category> findAll();

    void updateCategory(String categoryName, String newCategoryName);

    List<Commodity> findCommoditiesByCategory(String categoryName);

}
