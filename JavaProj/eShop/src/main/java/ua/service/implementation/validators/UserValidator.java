package ua.service.implementation.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.User;
import ua.service.UserService;

public class UserValidator implements Validator {

    private final UserService userService;

    public UserValidator(UserService userService) {
	this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> arg0) {
	return User.class.isAssignableFrom(arg0);
    }

    @Override
    public void validate(Object object, Errors errors) {
	User user = (User) object;
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "",
		"ϲ� ����������� �� ���� ���� �������");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "",
		"���� ����������� �� ���� ���� �������");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "",
		"������ ����������� �� ���� ���� �������");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail", "",
		"E-mail ����������� �� ���� ���� �������");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "",
		"������� ����������� �� ���� ���� �������");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "",
		"������ ����������� �� ���� ���� ���������");

	if (user.getFullName().length() < 5)
	    errors.rejectValue("fullName", "",
		    "ϲ� ����������� �� ���� ����� 5 �������");
	if (user.getFullName().split(" ").length < 2)
	    errors.rejectValue("fullName", "",
		    "ϲ� ����������� ������� �������� ��'� �� �������");
	if (!user.getFullName().matches("[a-zA-Z �-�����-߲��]+"))
	    errors.rejectValue("fullName", "",
		    "���������� ������� � ϲ� �����������");
	if (userService.findByUserFullName(user.getFullName()) != null
		&& userService.findByUserFullName(user.getFullName()).getId() != user
			.getId())
	    errors.rejectValue("fullName", "",
		    "���������� � ��� ϲ� ��� � � ���");

	if (user.getLogin().length() < 5)
	    errors.rejectValue("login", "",
		    "���� ����������� �� ���� ����� 5 �������");
	if (!user.getLogin().matches("[a-zA-Z�-�����-߲��0-9]+"))
	    errors.rejectValue("login", "",
		    "���������� ������� � ���� �����������");
	if (userService.findByUserLogin(user.getLogin()) != null
		&& userService.findByUserLogin(user.getLogin()).getId() != user
			.getId())
	    errors.rejectValue("login", "",
		    "���������� � ��� ������ ��� � � ���");

	if (user.getPassword().length() < 5)
	    errors.rejectValue("password", "",
		    "������ ����������� �� ���� ����� 5 �������");

	if (user.getMail().split("@").length != 2)
	    errors.rejectValue("mail", "", "����������� e-mail �����������");
	if (!user.getMail().matches("[a-zA-Z@.0-9�-�����-߲��]+"))
	    errors.rejectValue("mail", "",
		    "��������� ������� � e-mail �����������");
	if (userService.findByUserMail(user.getMail()) != null
		&& userService.findByUserMail(user.getMail()).getId() != user
			.getId())
	    errors.rejectValue("mail", "",
		    "���������� � ��� e-mail ��� � � ���");

	if (user.getPhone().length() != 12)
	    errors.rejectValue("phone", "",
		    "������� ����������� �� ���� 12 ���� � �������� ��� �����");
	if (!user.getPhone().matches("[0-9]+"))
	    errors.rejectValue("phone", "",
		    "����������� ������� �����������. ����� ���� ����� �����.");
    }

}
