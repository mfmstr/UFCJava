package ufc.l21.main

public class CircleWithoutConstructor extends Figure {
    private double radius;

    @Override
    public double getLength() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Radius: " + radius;
    }

    @Override
    public boolean equals(Object o) {
        Circle c = (Circle) o;
        return this.getLength() == c.getLength();
    }
}