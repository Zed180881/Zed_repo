package ua.service.implementation.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.OrderStatus;
import ua.service.OrderStatusService;

public class OrderStatusEditor extends PropertyEditorSupport {

    private final OrderStatusService orderStatusService;

    public OrderStatusEditor(OrderStatusService orderStatusService) {
	this.orderStatusService = orderStatusService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
	OrderStatus orderStatus = orderStatusService.findOne(Integer
		.valueOf(text));
	setValue(orderStatus);
    }
}
