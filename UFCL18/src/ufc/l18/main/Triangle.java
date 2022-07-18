package ufc.l18.main;

public class Triangle extends Figure{
	
	private double a;
	private double b;
	private double c;
	
	public Triangle(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public double getLength() {
		return a + b + c;
	}
	
	public boolean checkValidation() {
		if((a + b > c && a + c > b && b + c > a) && (a > 0 && b > 0 && c > 0)) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return ((Double)a).hashCode() + ((Double)b).hashCode() + ((Double)c).hashCode();
	}
	
	@Override
	public String toString() {
		return "a: " + a + " b: " + b + " c: " + c + " Perimeter: " + getLength();
	}
	
}