package rectPracticeTask4;

public class Rectarea {
	
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

	public static int whichIsMore(Rectarea x, Rectarea y) {
		if(x.getArea() > y.getArea()) {
			return 1;
		}else if(y.getArea() > x.getArea()) {
			return -1;
		}else {
			return 0;
		}
	}
	
	public static void main(String[] args) {

		Rectarea obj1 = new Rectarea();
		Rectarea obj2 = new Rectarea();
		obj1.setHeight(10.3);
		obj1.setWidth(2.3);
		obj2.setHeight(15.6);
		obj2.setWidth(12.9);
		
		System.out.println(Rectarea.whichIsMore(obj1, obj2));
		
		

	}

}



