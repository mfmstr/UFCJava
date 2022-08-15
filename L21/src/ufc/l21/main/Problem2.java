package ufc.l21.main

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem2 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<Rectangle> rc = Rectangle.class.getDeclaredConstructor(double.class, double.class);
        rc.setAccessible(true);
        Figure r = rc.newInstance(12, 15);
        System.out.println(printGetterMethods(r));
        System.out.println();

        Constructor<Triangle> tc = Triangle.class.getDeclaredConstructor(double.class, double.class, double.class);
        tc.setAccessible(true);
        Triangle t = tc.newInstance(3, 4, 5);
        System.out.println(printGetterMethods(t));
    }

    public static Map<String, Double> printGetterMethods(Figure f) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Map<String, Double> map = new HashMap<>();
        Method[] methods = f.getClass().getDeclaredMethods();

        for (Method method : methods) {
            method.setAccessible(true);
            String methodName = method.getName();

            if (methodName.startsWith("get") && (method.getReturnType() == Double.TYPE)) {
                map.put(methodName, (Double) method.invoke(f));
            }
        }

        return map;
    }
}
