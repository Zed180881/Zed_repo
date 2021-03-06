package ua.service.implementation.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.form.CommodityOrderForm;
import ua.service.CommodityOrderService;

public class CommodityOrderValidator implements Validator {

    @SuppressWarnings("unused")
    private final CommodityOrderService commodityOrderService;

    public CommodityOrderValidator(CommodityOrderService commodityOrderService) {
	this.commodityOrderService = commodityOrderService;
    }

    @Override
    public boolean supports(Class<?> arg0) {
	return CommodityOrderForm.class.isAssignableFrom(arg0);
    }

    @Override
    public void validate(Object object, Errors errors) {
	@SuppressWarnings("unused")
	CommodityOrderForm commodityOrderForm = (CommodityOrderForm) object;
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user", "",
		"User cann't be empty");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "orderStatus", "",
		"Order status cann't be empty");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "orderDate", "",
		"Order date cann't be empty");
	
    }

}
