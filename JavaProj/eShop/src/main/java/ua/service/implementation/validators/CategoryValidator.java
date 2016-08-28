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
		"Назва категорії не може бути порожньою!");
	if (!category.getCategoryName().matches("[a-zA-Z а-яієїА-ЯІЇЄ]+"))
	    errors.rejectValue("categoryName", "",
		    "Недопустимі символи в назві категорії!");
	if (categoryService.findByCategoryName(category.getCategoryName()) != null
		&& categoryService.findByCategoryName(
			category.getCategoryName()).getId() != category.getId())
	    errors.rejectValue("categoryName", "",
		    "Така категорія вже є в базі!");
    }
}
