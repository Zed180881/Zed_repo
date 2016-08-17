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
		"User name cann't be empty");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "",
		"Login cann't be empty");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "",
		"Password cann't be empty");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail", "",
		"Mail cann't be empty");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "",
		"Phone cann't be empty");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "",
		"Address cann't be empty");

	if (user.getFullName().length() < 5)
	    errors.rejectValue("fullName", "",
		    "User full name can be at least 5 characters");
	if (user.getFullName().split(" ").length < 2)
	    errors.rejectValue("fullName", "",
		    "User full name must contain at least name and surname");
	if (!user.getFullName().matches("[a-zA-Z ]+"))
	    errors.rejectValue("fullName", "",
		    "Illegal characters in user full name");
	if (userService.findByUserFullName(user.getFullName()) != null
		&& userService.findByUserFullName(user.getFullName()).getId() != user
			.getId())
	    errors.rejectValue("fullName", "",
		    "User with this name already exists");

	if (user.getLogin().length() < 5)
	    errors.rejectValue("login", "",
		    "User login can be at least 5 characters");
	if (!user.getLogin().matches("[a-zA-Z0-9]+"))
	    errors.rejectValue("login", "", "Illegal characters in user login");
	if (userService.findByUserLogin(user.getLogin()) != null
		&& userService.findByUserLogin(user.getLogin()).getId() != user
			.getId())
	    errors.rejectValue("login", "",
		    "User with this login already exists");

	if (user.getPassword().length() < 5)
	    errors.rejectValue("password", "",
		    "User password can be at least 5 characters");

	if (user.getMail().split("@").length != 2)
	    errors.rejectValue("mail", "", "Incorrect user mail");
	if (!user.getMail().matches("[a-zA-Z@.0-9]+"))
	    errors.rejectValue("mail", "", "Illegal characters in user mail");
	if (userService.findByUserMail(user.getMail()) != null
		&& userService.findByUserMail(user.getMail()).getId() != user
			.getId())
	    errors.rejectValue("mail", "", "User with this mail already exists");

	if (user.getPhone().length() != 12)
	    errors.rejectValue("phone", "",
		    "User phone must be 12 digits with country code");
	if (!user.getPhone().matches("[0-9]+"))
	    errors.rejectValue("phone", "",
		    "Incorrect phone. Must be digits only.");
    }

}
