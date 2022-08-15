package ufc.l22.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(4, 5);
        Rectangle r2 = new Rectangle(12, 15);
        Rectangle r3 = new Rectangle(42, 5);
        Rectangle r4 = new Rectangle(32, 15);

        List<Rectangle> arrRect = new ArrayList<>();
        Collections.addAll(arrRect, r1,  r2, r3, r4);

        List<Double> newArrRect = arrRect.stream().filter(x -> x.getArea() > 100).map(Rectangle::getHeight).collect(Collectors.toList());

        newArrRect.forEach(System.out::println);
    }
}
