package ufc.l7.main;

public class Rectangle extends Figure{
	
	private double width;
	private double height;
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void printFigureData() {
		System.out.println("Width: " + width + " Height: " + height);
	}
	
	@Override
	public void sayHelloToFigure() {
		System.out.println("Hello Rectangle");
	}
	
	@Override
	public boolean validateFigure() {
		if(width > 0 && height > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public double getPerimeter() {
		return (width + height) * 2;
	}
	
	@Override
	public double getArea() {
		return width * height;
	}
	
	@Override
	public String toString() {
		return "Width: " + width + " | Height: " + height + "| Perimeter: " + getPerimeter() + "| Area: " + getArea();
	}
}


