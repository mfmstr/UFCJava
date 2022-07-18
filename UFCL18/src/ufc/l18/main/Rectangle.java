package ufc.l18.main;

public class Rectangle extends Figure{
	
	private double a;
	private double b;
	
	public Rectangle(double a, double b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public double getLength() {
		return (a + b) * 2;
	}
	
	public boolean checkValidation() {
		if(a > 0 && b > 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return ((Double)a).hashCode() + ((Double)b).hashCode();
	}
	
	@Override
	public String toString() {
		return "Width: " + a +" Height: " + b + " Perimeter: " + getLength();
	}
	

}
