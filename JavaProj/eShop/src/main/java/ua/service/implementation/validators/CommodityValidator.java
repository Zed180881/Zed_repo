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
		"������� ������� �������� ������");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "model", "",
		"����� ������ �� ���� ���� ���������");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "producer", "",
		"������� ������� ��������� ������");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantity", "",
		"������� ������� ������� ������");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "",
		"������� ������� ���� ������");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "commodityStatus",
		"", "������� ������� ������ ������");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "warranty", "",
		"������� ������� ������� �� �����");

	if (!commodityForm.getModel().matches("[a-zA-Z�-�����-߲�� 0-9]+"))
	    errors.rejectValue("model", "", "���������� ������� � ���� ������");
	if (commodityService.findByCommodityModel(commodityForm.getModel()) != null
		&& commodityService.findByCommodityModel(commodityForm.getModel())
			.getId() != commodityForm.getId())
	    errors.rejectValue("model", "",
		    "����� � ���� ������ ��� � � ���");

	
	if (!commodityForm.getQuantity().matches("[0-9]+"))
	    errors.rejectValue("quantity", "", "���������� ������� � ��� ʳ������. ����� ���� ����� �����.");
	if (!commodityForm.getWarranty().matches("[0-9]+"))
	    errors.rejectValue("warranty", "", "���������� ������� � ��� �������. ����� ���� ����� �����.");
	if (!commodityForm.getPrice().matches("[.0-9]+"))
	    errors.rejectValue("price", "", "���������� ������� � ��� ֳ��. ����� ���� ����� �����.");	
    }

}
