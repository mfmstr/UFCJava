package ufc.l33.main;

import java.util.Arrays;
import java.util.Optional;

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
	
	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	public boolean checkValidation() {
		if((a + b > c && a + c > b && b + c > a) && (a > 0 && b > 0 && c > 0)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean isRightTriangle(Triangle t){
        double a2 = t.getA() * t.getA();
        double b2 = t.getB() * t.getB();
        double c2 = t.getC() * t.getC();
        
        if(a2 + b2 == c2 || a2 + c2 == b2 || b2 + c2 == a2) {
        	return true;
        }
        return false;
    }
	
	public static Optional<Triangle> makeTriangle(String trInfo) {
        Double[] sides = Arrays.stream(trInfo
                .split("-"))
                .map(Double::valueOf)
                .toArray(Double[]::new);
        return Optional.of(new Triangle(sides[0], sides[1], sides[2]));
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
