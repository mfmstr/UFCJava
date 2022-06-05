package rect;

import fig.Figure;

public class Rectangle extends Figure{
	
	private double width;
	private double height;
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getPerimeter() {
		return (width + height) * 2;
	}
	
	public double getArea() {
		return width * height;
	}
	
	@Override
	public String toString() {
		return "Rectangle";
	}
	
	public boolean equals(Rectangle x) {
		if(x instanceof Rectangle) {
			Rectangle z = (Rectangle) x;
			return this.getArea() == z.getArea();
	}else {
		return false;
	}
	}
	
	public double calculateDiagonal() {
		return Math.sqrt(width * width + height * height);
	}
	
}

