package main;

import fig.Figure;
import rect.Rectangle;
import tr.Triangle;

public class Main {
		public static void printFigure(Figure x) {
			
			System.out.println(x);
			System.out.println(x.getPerimeter());
			
			
			if(x instanceof Rectangle) {
				Rectangle y = (Rectangle) x;
				System.out.println(x.getArea());
				System.out.println(y.calculateDiagonal());
			}else if(x instanceof Triangle) {
				Triangle y = (Triangle) x;
				y.setSimagle(2.5);
				System.out.println(x.getArea());
				y.setAngles(90, 45);
				System.out.println(y.getAngleForm());
			}
		}
		
		public static boolean compareFigure(Figure a, Figure b) {
			boolean ans = false;
			if(a instanceof Rectangle && b instanceof Rectangle) {
				
				Rectangle c = (Rectangle) a;
				Rectangle d = (Rectangle) b;
				
				ans = c.getArea() == d.getArea();
				
				
			}else if(a instanceof Triangle && b instanceof Triangle) {
				
				Triangle c = (Triangle) a;
				Triangle d = (Triangle) b;
				
				ans = c.getPerimeter() == d.getPerimeter();
			}
			
			return ans;
		}
		
		public static void main(String[] args) {
			
			Figure rect = new Rectangle(9, 11);
			Figure rect2 = new Rectangle(10, 11);
			
			Figure tr = new Triangle(5, 6, 7);
			Figure tr2 = new Triangle(5, 6, 7);
			
			System.out.println(Main.compareFigure(rect, rect2)); // False
			System.out.println(Main.compareFigure(tr, tr2)); // True
			
			printFigure(rect); // OUTPUT: Rectangle, 40.0, 99.0, 14.212670403551895
			printFigure(tr); // OUTPUT: Triangle, 18.0, 6.25, 0
		}
}
