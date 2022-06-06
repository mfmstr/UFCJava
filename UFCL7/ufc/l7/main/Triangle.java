package ufc.l7.main;

public class Triangle extends Figure {

	private double a;
	private double b;
	private double c;
	
	private double simagle;
	
	public Triangle(double a, double b, double c, double simagle) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.simagle = simagle;
	}
	
	@Override
	public void printFigureData() {
		System.out.println("A: " + a + " B: " + b + " C: " + c);
	}
	
	@Override
	public void sayHelloToFigure() {
		System.out.println("Hello Triangle");
	}
	
	@Override
	public boolean validateFigure() {
		if(simagle > 0 && a > 0 && b > 0 && c > 0 && (a + b) > c && (b + c) > a && (a + c) > b) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "A: " + a + " | B: " + b + " | C: " + c + "| Perimeter: " + getPerimeter() + "| Area: " + getArea();
	}
	
	@Override
	public double getPerimeter() {
		return a + b + c;
	}
	
	@Override
	public double getArea() {
		return (a * simagle) / 2;
	}
	
}