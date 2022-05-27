package l3.rect;

public class Rectangle {
	private double width;
	private double height;
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	double getArea() {
		return width * height;
	}
	
	// Sheidzleboda protectedis gamokenebac get metodebze
	
	double getPerimeter() {
		return (width + height) * 2;
	}
	
	public int wichIsMore(Rectangle that) {
		if(this.getArea() > that.getArea()) {
			return 1;
		}else if(this.getArea() < that.getArea()) {
			return -1;
		}else {
			return 0;
		}
	}
	
}
