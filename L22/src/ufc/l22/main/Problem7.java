package ufc.l22.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem7 {

    public static void main(String[] args) {
        Circle c1 = new Circle(4);
        Circle c2 = new Circle(4);
        Circle c3 = new Circle(12);
        Circle c4 = new Circle(7);
        Circle c5 = new Circle(12);
        Circle c6 = new Circle(19);
        List<Circle> arrCircle = new ArrayList<>();
        Collections.addAll(arrCircle, c1, c2, c3, c4, c5, c6);

        Map<Double, Long> cm
                = arrCircle.stream().collect(Collectors.groupingBy(Circle::getRadius, Collectors.counting()));
        System.out.println(cm);
    }
}
