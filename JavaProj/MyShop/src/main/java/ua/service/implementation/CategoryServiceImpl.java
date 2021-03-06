package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Category;
import ua.entity.Commodity;
import ua.repository.CategoryRepository;
import ua.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void save(String categoryName) {
	if (categoryRepository.findByCategoryName(categoryName) == null)
	    categoryRepository.save(new Category(categoryName));
    }

    @Override
    public Category findByCategoryName(String categoryName) {
	return categoryRepository.findByCategoryName(categoryName);
    }

    @Override
    public void deleteByCategoryName(String categoryName) {
	if (categoryRepository.findByCategoryName(categoryName) != null)
	    categoryRepository.delete(findByCategoryName(categoryName));
    }

    @Override
    public List<Category> findAll() {
	return categoryRepository.findAll();
    }

    @Override
    public void updateCategory(String categoryName, String newCategoryName) {
	if (categoryRepository.findByCategoryName(categoryName) != null
		&& !newCategoryName.equals(""))
	    categoryRepository.findByCategoryName(categoryName)
		    .setCategoryName(newCategoryName);

    }

    @Override
    public List<Commodity> findCommoditiesByCategory(String categoryName) {
	return categoryRepository.findByCategoryName(categoryName)
		.getCommodities();
    }

}
