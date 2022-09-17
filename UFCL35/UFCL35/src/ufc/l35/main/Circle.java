package ufc.l35.main;

public class Circle extends Figure{
	
	private double radius;
	
	public Circle() {
		
	}
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public double getArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public double getLength() {
		return 2 * Math.PI * radius;
	}
	
	public boolean checkValidation() {
		if(radius > 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return ((Double)radius).hashCode();
	}
	
	@Override
	public String toString() {
		return "Radius: " + radius + " Perimeter: " + getLength() + " Area: " + getArea();
	}
	
	
	

}
