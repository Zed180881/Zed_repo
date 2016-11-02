package ua.service.implementation.editor;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;

public class DateEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
	if (text != null && !text.isEmpty())
	    setValue(LocalDate.parse(text));
	else
	    setValue(null);
    }
}
