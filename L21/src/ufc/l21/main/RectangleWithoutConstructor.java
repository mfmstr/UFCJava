package ufc.l21.main

public class RectangleWithoutConstructor extends Figure implements Comparable<Rectangle> {
    private double height;
    private double width;

    @Override
    public String toString() {
        return "Rectangle{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }

    @Override
    public double getLength() {
        return 2 * (width + height);
    }

    @Override
    public double getArea() {
        return width * height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    private boolean isSquare() {
        if (this.width == this.height) {
            return true;
        }

        return false;
    }

    @Override
    public int compareTo(Rectangle rect) {
        return Double.compare(this.getLength(), rect.getLength());
    }
}
