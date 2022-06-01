package recAndMain;

import fig.Figure;

public class Rectangle extends Figure {
	
	private double width;
	private double height;
	
	public Rectangle() {
		this(3, 4); 
	}
	
	public Rectangle(double width, double height) {
		super("Giorgi");
		this.width = width;
		this.height = height;
	}
	
	public double getPerimeter() {
		return (this.width + this.height) * 2;
	}
	
	public double getArea() {
		return this.width * this.height;
	}

	
	protected double getPerimeter(double width, double height) {
		return (width + height) * 2;
	}
	
	protected double getArea(double width, double height) {
		return width * height;
	}
	
	//	public static final void sayHello() {
	//		System.out.println("Hello!"); -------------> Cannot override the final method from Figure;
	//	}

	
}
