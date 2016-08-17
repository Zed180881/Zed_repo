package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Category;
import ua.repository.CategoryRepository;
import ua.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private Category category;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void save(Category category) {
	categoryRepository.save(category);
    }

    @Override
    public Category findByCategoryName(String categoryName) {
	return categoryRepository.findByCategoryName(categoryName);
    }

    @Override
    public void deleteByCategoryName(String categoryName) {
	if ((category = categoryRepository.findByCategoryName(categoryName)) != null)
	    categoryRepository.delete(category);
    }

    @Override
    public List<Category> findAll() {
	return categoryRepository.findAll();
    }

    @Override
    public Category findOne(int id) {
	return categoryRepository.findOne(id);
    }

    @Override
    public void deleteById(int id) {
	categoryRepository.delete(id);
	
    }

}
