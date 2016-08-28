package ua.service.implementation.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.OrderStatus;
import ua.service.OrderStatusService;

public class OrderStatusValidator implements Validator {

    private final OrderStatusService orderStatusService;

    public OrderStatusValidator(OrderStatusService orderStatusService) {
	this.orderStatusService = orderStatusService;
    }

    @Override
    public boolean supports(Class<?> arg0) {
	return OrderStatus.class.isAssignableFrom(arg0);
    }

    @Override
    public void validate(Object object, Errors errors) {
	OrderStatus orderStatus = (OrderStatus) object;
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "orderStatusName",
		"", "Статус не може бути порожнім");
	if (!orderStatus.getOrderStatusName().matches("[a-zA-Z а-яієїА-ЯІЇЄ]+"))
	    errors.rejectValue("orderStatusName", "",
		    "Недопустимі символи в назві статусу");
	if (orderStatusService.findByOrderStatusName(orderStatus
		.getOrderStatusName()) != null
		&& orderStatusService.findByOrderStatusName(
			orderStatus.getOrderStatusName()).getId() != orderStatus
			.getId())
	    errors.rejectValue("orderStatusName", "",
		    "Такий статус вже є в базі");
    }
}