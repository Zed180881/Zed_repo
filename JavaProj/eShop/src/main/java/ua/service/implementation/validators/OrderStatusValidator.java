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
		"", "������ �� ���� ���� ��������");
	if (!orderStatus.getOrderStatusName().matches("[a-zA-Z �-�����-߲��]+"))
	    errors.rejectValue("orderStatusName", "",
		    "���������� ������� � ���� �������");
	if (orderStatusService.findByOrderStatusName(orderStatus
		.getOrderStatusName()) != null
		&& orderStatusService.findByOrderStatusName(
			orderStatus.getOrderStatusName()).getId() != orderStatus
			.getId())
	    errors.rejectValue("orderStatusName", "",
		    "����� ������ ��� � � ���");
    }
}