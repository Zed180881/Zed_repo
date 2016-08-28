package ua.service.implementation.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.CommodityStatus;
import ua.service.CommodityStatusService;

public class CommodityStatusValidator implements Validator {

    private final CommodityStatusService commodityStatusService;

    public CommodityStatusValidator(
	    CommodityStatusService commodityStatusService) {
	this.commodityStatusService = commodityStatusService;
    }

    @Override
    public boolean supports(Class<?> arg0) {
	return CommodityStatus.class.isAssignableFrom(arg0);
    }

    @Override
    public void validate(Object object, Errors errors) {
	CommodityStatus commodityStatus = (CommodityStatus) object;
	ValidationUtils.rejectIfEmptyOrWhitespace(errors,
		"commodityStatusName", "", "������ �� ���� ���� �������");
	if (!commodityStatus.getCommodityStatusName().matches(
		"[a-zA-Z �-�����-߲��]+"))
	    errors.rejectValue("commodityStatusName", "",
		    "���������� ������� � ���� �������");
	if (commodityStatusService.findByCommodityStatusName(commodityStatus
		.getCommodityStatusName()) != null
		&& commodityStatusService.findByCommodityStatusName(
			commodityStatus.getCommodityStatusName()).getId() != commodityStatus
			.getId())
	    errors.rejectValue("commodityStatusName", "",
		    "����� ������ ��� � � ���");
    }

}
