package ufc.l26.main;

public class Circle extends Figure implements Comparable<Circle> {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

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

	@Override
	public int compareTo(Circle o) {
		return Double.compare(this.getLength(), o.getLength());
	}
}
