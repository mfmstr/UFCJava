package ufc.l21.main

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Problem {


    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Constructor<Circle> circleConstructor = Circle.class.getDeclaredConstructor(double.class);
        circleConstructor.setAccessible(true);
        Circle c = circleConstructor.newInstance(10);

        System.out.println(method(c, FigureMethod.GET_AREA));
        System.out.println(method(c, FigureMethod.GET_LENGTH));

        Constructor<Rectangle> rectangleConstructor = Rectangle.class.getDeclaredConstructor(double.class, double.class);
        rectangleConstructor.setAccessible(true);
        Rectangle r = rectangleConstructor.newInstance(4, 5);

        System.out.println(method(r, FigureMethod.GET_AREA));
        System.out.println(method(r, FigureMethod.GET_LENGTH));
    }

    public static double method(Figure f, FigureMethod m) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String str = m.toString().toLowerCase();
        String[] strArr = str.split("_");

        String getMethod = strArr[0];

        String capFirst = capitalize(strArr[1]);

        getMethod += capFirst;

        Method method = f.getClass().getMethod(getMethod);

        return (double) method.invoke(f);
    }

    public static String capitalize(String str) {
        if(str == null || str.length()<=1) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
