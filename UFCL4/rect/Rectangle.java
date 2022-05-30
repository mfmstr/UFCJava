package rect;

public class Rectangle {
	
	private double width;
	private double height;
	
	public static final double maxWidth;
	public static final double maxHeight;
	
	public void setWidth(double width) {
		checkWidth(width);
	}
	
	public void setHeight(double height) {
		checkHeight(height);
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public Rectangle() {
		checkHeight(50);
	}
	
	public Rectangle(double width) {
		checkWidth(width);
	}
	
	public Rectangle(double width, double height) {
		checkWidth(width);
		checkHeight(height);
	}
	
	private void checkWidth(double width) {
		if(width > maxWidth) {
			this.width = maxWidth;
		}else {
			this.width = width;
		}
	}
	
	private void checkHeight(double height) {
		if(height > maxHeight) {
			this.height = maxHeight;
		}else {
			this.height = height;
		}
	}
	
	static {
		maxWidth = 100;
		maxHeight = 100;
	}
	
	double getArea() {
		return width * height;
	}
	
	public static Rectangle returnMax(Rectangle[] arr) {
		Rectangle result = new Rectangle();
		double maxArea = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].getArea() > maxArea) {
				maxArea = arr[i].getArea();
				result = arr[i];
			}
		}
		return result;
	}
}
