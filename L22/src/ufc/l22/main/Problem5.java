package ufc.l22.main;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Task5 {

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(4, 5);
        Rectangle r2 = new Rectangle(12, 15);
        Rectangle r3 = new Rectangle(43, 5);
        Rectangle r4 = new Rectangle(32, 15);
        Rectangle r5 = new Rectangle(50,60);

        Set<Rectangle> setRects = new TreeSet<>();
        Collections.addAll(setRects, r1, r2, r3, r4, r5);

        Set<Rectangle> newSetRects
                = setRects.stream().filter(x -> (x.getHeight()*x.getHeight()) + (x.getWidth()*x.getWidth()) > 2500).collect(Collectors.toSet());
        System.out.println(newSetRects);
    }
}
