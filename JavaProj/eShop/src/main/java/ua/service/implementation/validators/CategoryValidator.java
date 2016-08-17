package ua.service.implementation.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.Category;
import ua.service.CategoryService;

public class CategoryValidator implements Validator {

    private final CategoryService categoryService;

    public CategoryValidator(CategoryService categoryService) {
	this.categoryService = categoryService;
    }

    @Override
    public boolean supports(Class<?> arg0) {
	return Category.class.isAssignableFrom(arg0);
    }

    @Override
    public void validate(Object object, Errors errors) {
	Category category = (Category) object;
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoryName", "",
		"Category name cann't be empty");
	if (!category.getCategoryName().matches("[a-zA-Z ]+"))
	    errors.rejectValue("categoryName", "",
		    "Illegal characters in category name");
	if (categoryService.findByCategoryName(category.getCategoryName()) != null)
	    errors.rejectValue("categoryName", "",
		    "Category with this name already exists");
    }
}
