package ufc.main;

public class Rectangle extends Figure{
	
	private double width;
	private double height;
	
	public static int counter = 0;
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
		
		counter++;
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
	
	
	public void checkArea() {
		if(this.getArea() > 10000) {
			throw new AreaTooLargeException("Martkutxedis fartobi ar unda agematebodes 10 000-s");
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
	
	@Override
	public void validate(String msg) throws RectangleValidateException {
		if(width <= 0 || height <= 0) {
			System.out.println(msg);
			throw new RectangleValidateException("martkudxedis orive aucileblad meti unda ikos 0-ze!!!");
		}else {
			System.out.println("martkutxedi warmatebit sheikmna");
		}
	}
	
	
}


