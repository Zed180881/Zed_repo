package ua.service.implementation.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.form.CommodityForm;
import ua.service.CommodityService;

public class CommodityValidator implements Validator {

    private final CommodityService commodityService;

    public CommodityValidator(CommodityService commodityService) {
	this.commodityService = commodityService;
    }

    @Override
    public boolean supports(Class<?> arg0) {
	return CommodityForm.class.isAssignableFrom(arg0);
    }

    @Override
    public void validate(Object object, Errors errors) {
	CommodityForm commodityForm = (CommodityForm) object;
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category", "",
		"Потрібно вибрати категорію товару");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "model", "",
		"Назва товару не може бути порожньою");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "producer", "",
		"Потрібно вибрати виробника товару");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantity", "",
		"Потрібно вказати кількість товару");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "",
		"Потрібно вказати ціну товару");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "commodityStatus",
		"", "Потрібно вибрати статус товару");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "warranty", "",
		"Потрібно вказати гарантію на товар");

	if (!commodityForm.getModel().matches("[a-zA-Zа-яієїА-ЯІЇЄ 0-9]+"))
	    errors.rejectValue("model", "", "Недопустимі символи в назві товару");
	if (commodityService.findByCommodityModel(commodityForm.getModel()) != null
		&& commodityService.findByCommodityModel(commodityForm.getModel())
			.getId() != commodityForm.getId())
	    errors.rejectValue("model", "",
		    "Товар з цією назвою вже є в базі");

	
	if (!commodityForm.getQuantity().matches("[0-9]+"))
	    errors.rejectValue("quantity", "", "Недопустимі символи в полі Кількість. Мають бути тільки цифри.");
	if (!commodityForm.getWarranty().matches("[0-9]+"))
	    errors.rejectValue("warranty", "", "Недопустимі символи в полі Гарантія. Мають бути тільки цифри.");
	if (!commodityForm.getPrice().matches("[.0-9]+"))
	    errors.rejectValue("price", "", "Недопустимі символи в полі Ціна. Мають бути тільки цифри.");	
    }

}
