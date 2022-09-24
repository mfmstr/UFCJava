package ge.ufc.figures;

public class Circle extends Figure{
	
	private double radius;
	
	public Circle(double radius) {
		this.radius = radius;
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
		return "Radius: " + radius + " Perimeter: " + getLength();
	}
	
	
	

}
