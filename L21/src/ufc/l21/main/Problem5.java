package ufc.l21.main

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        List<Figure> fList = new ArrayList<>();
        Constructor<Rectangle> rectangleConstructor = Rectangle.class.getDeclaredConstructor(double.class, double.class);
        rectangleConstructor.setAccessible(true);
        Rectangle r = rectangleConstructor.newInstance(3, 4);
        fList.add(r);

        Constructor<Triangle> tc = Triangle.class.getDeclaredConstructor(double.class, double.class, double.class);
        tc.setAccessible(true);
        Triangle t1 = tc.newInstance(3, 4, 5);
        Triangle t2 = tc.newInstance(6, 8, 10);
        fList.add(t1);
        fList.add(t2);
        System.out.println(countTriangle(fList));
    }

    public static int countTriangle(List<Figure> fList) {
        int countTri = 0;

        for (int i = 0; i < fList.size(); i++) {
            if (fList.get(i).getClass() == Triangle.class) {
                countTri++;
            }
        }

        return countTri;
    }
}
