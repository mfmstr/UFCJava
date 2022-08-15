package ufc.l21.main

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Task6 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Method m = Circle.class.getMethod("hashCode");
        Constructor<Circle> cc = Circle.class.getDeclaredConstructor(double.class);
        cc.setAccessible(true);
        Circle c = cc.newInstance(10);
        System.out.println(m.invoke(c));
    }
}
