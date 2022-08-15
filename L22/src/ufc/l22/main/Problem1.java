package ufc.l22.main;

import java.util.ArrayList;
import java.util.Collections;

public class Problem1 {

    public static void main(String[] args) {
        Circle c1 = new Circle(4);
        Circle c2 = new Circle(44);
        Circle c3 = new Circle(12);
        Circle c4 = new Circle(7);
        Circle c5 = new Circle(5);
        Circle c6 = new Circle(19);
        ArrayList<Circle> arrCircle = new ArrayList<>();
        Collections.addAll(arrCircle, c1, c2, c3, c4, c5, c6);

        double count = arrCircle.stream().filter(x -> x.getRadius() > 10).count();
        System.out.println((int) count);
    }
}
