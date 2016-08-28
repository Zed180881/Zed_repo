package ua.service.implementation.editor;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;

public class DateEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
	String[] tmp = text.split("-");
	LocalDate date = LocalDate.of(Integer.valueOf(tmp[0]),
		Integer.valueOf(tmp[1]), Integer.valueOf(tmp[2]));
	setValue(date);
    }
}
