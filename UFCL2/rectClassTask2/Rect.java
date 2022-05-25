package rectClassTask2;

public class Rect {
	
	private double width;
	private double height;
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getArea() {
		return width * height;
	}
	
	public double getPerimeter() {
		return (width + height) * 2;
	}
	

	public static void main(String[] args) {
		
		Rect obj = new Rect();
		
		obj.setWidth(10);
		obj.setHeight(5);
		
		System.out.println(obj.getArea());
		System.out.println(obj.getPerimeter());

	}

}
