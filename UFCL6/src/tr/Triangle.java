package tr;

import fig.Figure;

public class Triangle extends Figure {

	private double a;
	private double b;
	private double c;
	
	private double angle1;
	private double angle2;
	
	private double simagle;
	
	public Triangle(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public void setSimagle(double simagle) {
		this.simagle = simagle;
	}
	
	public void setAngles(double angle1, double angle2) {
		this.angle1 = angle1;
		this.angle2 = angle2;
	}
	
	public void setA(double a) {
		this.a = a;
	}
	
	public void setB(double b) {
		this.b = b;
	}
	
	public void setC(double c) {
		this.c = c;
	}
	
	@Override
	public String toString() {
		return "Triangle";
	}
	
	public double getPerimeter() {
		return a + b + c;
	}
	
	public boolean equals(Triangle x) {
		if(x instanceof Triangle) {
		Triangle z = (Triangle) x;
		return this.getPerimeter() == z.getPerimeter();
		}else {
			return false;
		}
	}
	
	public int getAngleForm() {
		double angle3 = 180 - angle1 - angle2;
		int ans = 0;
		if(angle1 < 90 && angle2 < 90 && angle3 < 90 ) {
			ans = 1;
		}
		if(angle1 == 90 || angle2 == 90 || angle3 == 90) {
			ans = 0;
		}
		if(angle1 > 90 || angle2 > 90 || angle3 > 90) {
			ans = -1;
		}
		
		return ans;	
	}
	
	public double getArea() {
		return (a * simagle) / 2;
	}
	
}
