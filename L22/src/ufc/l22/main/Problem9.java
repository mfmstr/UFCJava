package ufc.l22.main;

import java.util.*;
import java.util.stream.Collectors;

public class Problem9 {

    public static void main(String[] args) {
        Triangle t1 = new Triangle(3, 4, 5);
        Triangle t2 = new Triangle(2, 7, 8);
        Triangle t3 = new Triangle(3, 8, 10);
        Triangle t4 = new Triangle(12, 8, 15);

        List<Triangle> tris = new ArrayList<>();
        Collections.addAll(tris, t1, t2, t3, t4);

        Map<Double, DoubleSummaryStatistics> tm
                = tris.stream().collect(Collectors.groupingBy(Triangle::getSideA, Collectors.summarizingDouble(Triangle::getLength)));
        System.out.println(tm);
    }
}
