package ufc.l24.main;

import java.lang.reflect.InvocationTargetException;

public class Main {
		public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
			Triangle a = new Triangle(10, 11, 12);
			System.out.print(ObjectTuCustomStringConverter.convert(a));
		}
}
