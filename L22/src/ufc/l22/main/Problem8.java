package ufc.l22.main;

import java.util.*;
import java.util.stream.Collectors;

public class Problem8 {

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(4, 5);
        Rectangle r2 = new Rectangle(12, 15);
        Rectangle r3 = new Rectangle(12, 7);
        Rectangle r4 = new Rectangle(12, 2);
        Rectangle r5 = new Rectangle(32, 15);
        Rectangle r6 = new Rectangle(4, 15);

        List<Rectangle> arrRect = new ArrayList<>();
        Collections.addAll(arrRect, r1,  r2, r3, r4, r5, r6);

        Map<Double, Double> rms;
        rms = arrRect.stream().collect(Collectors.groupingBy
        (Rectangle::getHeight, Collectors.collectingAndThen(Collectors.minBy(new RectangleWidthComparator()), x -> x.get().getWidth())));

        System.out.println(rms);
    }

    static class RectangleWidthComparator implements Comparator<Rectangle> {

        @Override
        public int compare(Rectangle o1, Rectangle o2) {

            return Double.compare(o1.getWidth(), o2.getWidth());
        }
    }
}
