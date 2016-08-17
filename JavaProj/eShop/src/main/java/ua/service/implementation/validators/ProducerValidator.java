package ua.service.implementation.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.Producer;
import ua.service.ProducerService;

public class ProducerValidator implements Validator {

    private final ProducerService producerService;

    public ProducerValidator(ProducerService producerService) {
	this.producerService = producerService;
    }

    @Override
    public boolean supports(Class<?> arg0) {
	return Producer.class.isAssignableFrom(arg0);
    }

    @Override
    public void validate(Object object, Errors errors) {
	Producer producer = (Producer) object;
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "producerName", "",
		"Producer name cann't be empty");
	if (!producer.getProducerName().matches("[a-zA-Z ]+"))
	    errors.rejectValue("producerName", "",
		    "Illegal characters in producer name");
	if (producerService.findByProducerName(producer.getProducerName()) != null)
	    errors.rejectValue("producerName", "",
		    "Producer with this name already exists");
    }

}
