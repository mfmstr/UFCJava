package ufc.main;

public class Rectangle extends Figure{
	
	private double width;
	private double height;
	
	public static int counter = 0;
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
		
		counter++;
		
		if(counter > 5) {
			throw new LimitException("martkutxedta raodenobam 5s gadaacharba");
		}
	}

	
	public double getPerimeter() {
		return (width + height) * 2;
	}
	
	public double getArea() {
		return width * height;
	}
	
	@Override
	public String toString() {
		return "Rectangle - Width: " + width + " Height: " + height + " Area: " + getArea() + " Perimeter: " + getPerimeter();
	}
	
	public boolean equals(Rectangle x) {
		if(x instanceof Rectangle) {
			Rectangle z = (Rectangle) x;
			return this.getArea() == z.getArea();
	}else {
		return false;
	}
	}


	@Override
	public void validate() throws RectangleValidateException {
		if(width <= 0 || height <= 0) {
			throw new RectangleValidateException("martkudxedis orive aucileblad meti unda ikos 0-ze!!!");
		}else {
			System.out.println("martkutxedi warmatebit sheikmna");
		}
	}
	
	
	
}


