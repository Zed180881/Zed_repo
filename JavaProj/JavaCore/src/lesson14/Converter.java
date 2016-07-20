package lesson14;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Converter<T> {

    private Class<T> dtoClass;

    private final Map<String, String> settings = new HashMap<String, String>();

    public T convert(Object object) {
	T dto = null;
	try {
	    dto = dtoClass.newInstance();
	    Class<?> paramClass = object.getClass();
	    for (String fieldName : settings.keySet()) {
		rewriteField(fieldName, paramClass, dto, object);
	    }
	} catch (InstantiationException | IllegalAccessException
		| NoSuchFieldException | SecurityException e) {
	    e.printStackTrace();
	}
	return dto;
    }
    
    private void rewriteField(String fieldName, Class<?> paramClass, T dto, Object object) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
	Field field = paramClass.getDeclaredField(fieldName);
	if (!field.isAnnotationPresent(Ignore.class)) {
	    field.setAccessible(true);
	    Object value = field.get(object);
	    Field dtoField = dtoClass.getDeclaredField(settings
		    .get(fieldName));
	    dtoField.setAccessible(true);
	    dtoField.set(dto, value);
	}
    }

    public List<T> convert(List<?> objects) {
	List<T> list = new ArrayList<T>();
	for (Object object : objects) {
	    list.add(convert(object));
	}
	return list;
    }

    public static class Builder<T> {

	private final Converter<T> converter = new Converter<>();

	public Builder<T> setClass(Class<T> dtoClass) {
	    converter.dtoClass = dtoClass;
	    return this;
	}

	public Builder<T> addSetting(String from, String to) {
	    converter.settings.put(from, to);
	    return this;
	}

	public Converter<T> build() {
	    return converter;
	}
    }

}
