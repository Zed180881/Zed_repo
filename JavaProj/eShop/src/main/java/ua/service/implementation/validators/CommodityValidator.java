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
		"Category cann't be empty");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "model", "",
		"Model cann't be empty");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "producer", "",
		"Producer cann't be empty");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantity", "",
		"Quantity cann't be empty");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "",
		"Price cann't be empty");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "commodityStatus",
		"", "Commodity status cann't be empty");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "warranty", "",
		"Commodity status cann't be empty");

	if (!commodityForm.getModel().matches("[a-zA-Z 0-9]+"))
	    errors.rejectValue("model", "", "Illegal characters in model name");
	if (commodityService.findByCommodityModel(commodityForm.getModel()) != null
		&& commodityService.findByCommodityModel(commodityForm.getModel())
			.getId() != commodityForm.getId())
	    errors.rejectValue("model", "",
		    "Commodity with this model already exists");

	
	if (!commodityForm.getQuantity().matches("[0-9]+"))
	    errors.rejectValue("quantity", "", "Illegal characters in quantity field. Only digits are allowed!");
	if (!commodityForm.getWarranty().matches("[0-9]+"))
	    errors.rejectValue("warranty", "", "Illegal characters in warranty field. Only digits are allowed!");
	if (!commodityForm.getPrice().matches("[.0-9]+"))
	    errors.rejectValue("price", "", "Illegal characters in price field. Correct sample 12.11");
	
    }

}
