package ufc.l22.main;

import java.util.*;
import java.util.stream.Collectors;

public class Problem4 {

    public static void main(String[] args) {
        Circle c1 = new Circle(4);
        Circle c2 = new Circle(44);
        Circle c3 = new Circle(12);
        Circle c4 = new Circle(7);
        Circle c5 = new Circle(5);
        Circle c6 = new Circle(7);

        Comparator<Circle> cmp = new Comparator<Circle>() {
            @Override
            public int compare(Circle o1, Circle o2) {
                return Double.compare(o1.getLength(), o2.getLength());
            }
        };
        Set<Circle> arrCircle = new TreeSet<>(cmp);
        Collections.addAll(arrCircle, c1, c2, c3, c4, c5, c6);

        double maxArea
                = arrCircle.stream().collect(Collectors.maxBy(Comparator.comparingDouble(x -> x.getArea()))).get().getArea();

        double minArea =
                arrCircle.stream().min(Comparator.comparingDouble(x -> x.getArea())).get().getArea();

        System.out.println("Max: " + maxArea);
        System.out.println("Min: " + minArea);
    }
}
