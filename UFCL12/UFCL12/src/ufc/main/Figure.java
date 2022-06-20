package ufc.main;

public abstract class Figure {
	
	public Figure() {
		
	}
	
	public abstract void validate(String string) throws ValidateException;
	
	public abstract void validate() throws ValidateException;
		
	public double getPerimeter() {
		return -10;
	}
	
	public double getArea() {
		return -15;
	}
}
