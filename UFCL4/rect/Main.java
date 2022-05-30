package rect;

public class Main {

	public static void main(String[] args) {
		
		Rectangle a = new Rectangle();
		System.out.println(a.getWidth()); // Result 0.0
		System.out.println(a.getHeight()); // Result 50.0
		
		Rectangle b = new Rectangle(50);
		System.out.println(b.getWidth()); // Result 50.0
		System.out.println(b.getHeight()); // Result 0.0
		
		Rectangle c = new Rectangle(200, 20);
		System.out.println(c.getWidth()); // Result 100.0
		System.out.println(c.getHeight()); // Result 20.0
		
		Rectangle d = new Rectangle(30, 200);
		System.out.println(d.getWidth()); // Result 30.0
		System.out.println(d.getHeight()); // Result 100.0
		
		Rectangle[] arr = {a, b, c, d};
		
		System.out.println(Rectangle.returnMax(arr).getArea()); // Result 3000.0
		
		Rectangle e = new Rectangle(500, 200);
		
		Rectangle[] arr2 = {a, b, c, d, e};
		
		System.out.println(Rectangle.returnMax(arr2).getArea()); // Result 10000.0
	}

}
