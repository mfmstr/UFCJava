package ufc.l26.main;

import java.util.ArrayList;
import java.util.Iterator;

public class Triangle extends Figure implements Comparable<Triangle> {
    private double sideA;
    private double sideB;
    private double sideC;
    public static ArrayList<Triangle> triangleArray;
    public static int size;

    Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public static void printTriangles() {
        RightTriangleIterator iter = new RightTriangleIterator();
        while (iter.hasNext()) {
            Triangle t = iter.next();
            if (t == null) {
                continue;
            }

            System.out.println(t);
        }
    }

    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public double getLength() {
        return sideA + sideB + sideC;
    }

    @Override
    public double getArea() {
        double perHalf = getLength() / 2;
        return Math.sqrt(perHalf * (perHalf-sideA) * (perHalf-sideB) * (perHalf-sideC));
    }



    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    @Override
    public int compareTo(Triangle tri) {
        return Double.compare(this.getLength(), tri.getLength());
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                '}';
    }

    private boolean isRightTriangle() {
        if ((this.sideA * this.sideA) + (this.sideB * this.sideB) == this.sideC * this.sideC) {
            return true;
        }

        return false;
    }

    static class RightTriangleIterator implements Iterator<Triangle> {
        private int nextIndex = 0;

        @Override
        public boolean hasNext() {
            return (nextIndex <= Triangle.size - 1);
        }

        @Override
        public Triangle next() {

            Triangle t = triangleArray.get(nextIndex);

            if ((t.sideA * t.sideA) + (t.sideB * t.sideB) == t.sideC * t.sideC) {
                nextIndex++;
                return t;
            } else {
                nextIndex++;
                return null;
            }
        }
    }
}
