package ufc.l24.main;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.StringJoiner;

public class ObjectTuCustomStringConverter {
	
	public static String convert(Object a) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		if(!a.getClass().isAnnotationPresent(CustomStringSerializable.class)) {
			throw new CustomStringSerializationException("Sheudzlebelia gadakvana!");
		}
		
		StringJoiner res = new StringJoiner(";", "[", "]");
		
		Field[] x = a.getClass().getDeclaredFields();
		for(int i = 0; i < x.length; i++) {
			x[i].setAccessible(true);
			if(x[i].isAnnotationPresent(SkipSerialization.class)) {
				continue;
			}
			
			if(x[i].isAnnotationPresent(Validator.class)) {
				double val = (Double) x[i].get(a);
				Validator valid = x[i].getAnnotation(Validator.class);
				
				if(valid.min() == -1 && valid.max() == -1) {
					res.add(x[i].getName() + "=" + val);
					continue;
				}
				
				if(!(val >= valid.min() && val <= valid.max())) {
					continue;
				}
			
				res.add(x[i].getName() + "=" + val);
			
			}
			
		}
		
		Method[] met = a.getClass().getDeclaredMethods();
		for(int i = 0; i < met.length; i++) {
			met[i].setAccessible(true);
			if(met[i].isAnnotationPresent(Validator.class)) {
				boolean ans = (Boolean) met[i].invoke(a);
				if(ans == false) {
					throw new CustomStringSerializationException("Metodi ar aris validuri");
				}
			}
		}
		
		return res.toString();
	}
	
}
