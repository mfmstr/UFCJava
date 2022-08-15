package ufc.l22.main;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Problem6 {

    public static void main(String[] args) {
        Triangle t1 = new Triangle(3, 4, 5);
        Triangle t2 = new Triangle(2, 7, 8);
        Triangle t3 = new Triangle(6, 8, 10);
        Triangle t4 = new Triangle(12, 8, 15);

        Set<Triangle> tris = new TreeSet<>();
        Collections.addAll(tris, t1, t2, t3, t4);

        Set<Double> newTrisSet = tris.stream().filter(x -> x.getLength() <= 29.5).map(x -> x.getLength()).collect(Collectors.toSet());
        System.out.println(newTrisSet);
    }
}
