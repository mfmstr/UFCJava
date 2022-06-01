package squ;

import recAndMain.Rectangle;

public final class Square extends Rectangle{
	
	private double x;
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getPerimeter() {
		return getPerimeter(x, x);
	}
	
	public double getArea() {
		return getArea(x,x);
	}
	
}
