package l3.rect.insiderect;

public class Rectangle {
	private double width;
	private double height;
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	protected double getPerimeter() {
		return (width + height) * 2;
	}
	
	public int whichIsMore(Rectangle a, Rectangle b) {
		if(a.getPerimeter() > b.getPerimeter()) {
			return 1;
		}else if(a.getPerimeter() < b.getPerimeter()) {
			return -1;
		}else {
			return 0;
		}
	}
	
	
	
}
