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
		"ПІБ користувача не може бути порожнім");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "",
		"Логін користувача не може бути порожнім");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "",
		"Пароль користувача не може бути порожнім");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail", "",
		"E-mail користувача не може бути порожнім");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "",
		"Телефон користувача не може бути порожнім");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "",
		"Адреса користувача не може бути порожньою");

	if (user.getFullName().length() < 5)
	    errors.rejectValue("fullName", "",
		    "ПІБ користувача має бути мінімум 5 символів");
	if (user.getFullName().split(" ").length < 2)
	    errors.rejectValue("fullName", "",
		    "ПІБ користувача повинно включати ім'я та прізвище");
	if (!user.getFullName().matches("[a-zA-Z а-яієїА-ЯІЇЄ]+"))
	    errors.rejectValue("fullName", "",
		    "Недопустимі символи в ПІБ користувача");
	if (userService.findByUserFullName(user.getFullName()) != null
		&& userService.findByUserFullName(user.getFullName()).getId() != user
			.getId())
	    errors.rejectValue("fullName", "",
		    "Користувач з цим ПІБ вже є в базі");

	if (user.getLogin().length() < 5)
	    errors.rejectValue("login", "",
		    "Логін користувача має бути мінімум 5 символів");
	if (!user.getLogin().matches("[a-zA-Zа-яієїА-ЯІЇЄ0-9]+"))
	    errors.rejectValue("login", "",
		    "Недопустимі символи в логіні користувача");
	if (userService.findByUserLogin(user.getLogin()) != null
		&& userService.findByUserLogin(user.getLogin()).getId() != user
			.getId())
	    errors.rejectValue("login", "",
		    "Користувач з цим логіном вже є в базі");

	if (user.getPassword().length() < 5)
	    errors.rejectValue("password", "",
		    "Пароль користувача має бути мінімум 5 символів");

	if (user.getMail().split("@").length != 2)
	    errors.rejectValue("mail", "", "Некоректний e-mail користувача");
	if (!user.getMail().matches("[a-zA-Z@.0-9а-яієїА-ЯІЇЄ]+"))
	    errors.rejectValue("mail", "",
		    "Некоректні символи в e-mail користувача");
	if (userService.findByUserMail(user.getMail()) != null
		&& userService.findByUserMail(user.getMail()).getId() != user
			.getId())
	    errors.rejectValue("mail", "",
		    "Користувач з цим e-mail вже є в базі");

	if (user.getPhone().length() != 12)
	    errors.rejectValue("phone", "",
		    "Телефон користувача має мати 12 цифр і включати код країни");
	if (!user.getPhone().matches("[0-9]+"))
	    errors.rejectValue("phone", "",
		    "Некоректний телефон користувача. Мають бути тільки цифри.");
    }

}
