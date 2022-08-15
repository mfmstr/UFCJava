package ufc.l21.main

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Problem7 {

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Constructor<Triangle> tc = Triangle.class.getDeclaredConstructor(double.class, double.class, double.class);
        tc.setAccessible(true);
        Triangle t1 = tc.newInstance(3, 4, 5);
        Triangle t2 = tc.newInstance(6, 8, 11);
        Method method = t1.getClass().getDeclaredMethod("isRightTriangle");
        Method method1 = t2.getClass().getDeclaredMethod("isRightTriangle");
        method.setAccessible(true);
        method1.setAccessible(true);
        System.out.println(method.invoke(t1));
        System.out.println(method1.invoke(t2));

        Constructor<Rectangle> rc = Rectangle.class.getDeclaredConstructor(double.class, double.class);
        rc.setAccessible(true);
        Rectangle r = rc.newInstance(4, 4);
        Rectangle r1 = rc.newInstance(4, 5);
        Method method2 = r.getClass().getDeclaredMethod("isSquare");
        Method method3 = r1.getClass().getDeclaredMethod("isSquare");
        method2.setAccessible(true);
        method3.setAccessible(true);
        System.out.println(method2.invoke(r));
        System.out.println(method3.invoke(r1));
    }
}
