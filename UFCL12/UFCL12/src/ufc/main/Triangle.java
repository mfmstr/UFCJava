package ufc.main;

public class Triangle extends Figure {

	private double a;
	private double b;
	private double c;
	
	public static int counter = 0;
	
	public Triangle(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
		
		counter++;
	}
	
	@Override
	public String toString() {
		return "Triangle - A: " + a + " B: " + b + " C: " + c + " Perimeter: " + getPerimeter();
	}
	
	
	public double getPerimeter() {
		return a + b + c;
	}
	
	public boolean equals(Triangle x) {
		if(x instanceof Triangle) {
		Triangle z = (Triangle) x;
		return this.getPerimeter() == z.getPerimeter();
		}else {
			return false;
		}
	}

	@Override
	public void validate() throws TriagleValidateException {
		if(a + b <= c || a + c <= b || b + c <= a) {
			throw new TriagleValidateException("samkutxedis nebismieri ori gverdis jami aucileblad meti unda ikos mesameze!!!");
		}else {
			System.out.println("samkutxedi warmatebit sheikmna");
		}
	}

	@Override
	public void validate(String msg) throws TriagleValidateException {
		if(a + b <= c || a + c <= b || b + c <= a) {
			System.out.println(msg);
			throw new TriagleValidateException("samkutxedis nebismieri ori gverdis jami aucileblad meti unda ikos mesameze!!!");
		}else {
			System.out.println("samkutxedi warmatebit sheikmna");
		}
	}
	
}

