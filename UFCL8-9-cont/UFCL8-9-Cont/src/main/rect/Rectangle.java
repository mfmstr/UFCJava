package main.rect;

import java.util.ArrayList;
import java.util.Collections;

public class Rectangle extends Figure implements Comparable {
	
	private double width;
	private double height;
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
	
	@Override
	public double getPerimeter() {
		return (width + height) * 2;
	}
	
	@Override
	public double getArea() {
		return width * height;
	}
	
	@Override
	public String toString() {
		return "Rectangle - Width: " + width + " | Height: " + height + "| Perimeter: " + getPerimeter() + "| Area: " + getArea();
	}

	@Override
	public boolean equals(Object a) {
		if(a instanceof Rectangle) {
			Rectangle x = (Rectangle) a;
			if(this.width == x.width && this.height == x.height) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		// ჰეშკოდში ორივე პარამეტრი(სიგრძე, სიგანე) გადამყავს სტრინგში და ვაქცევ ერთ მთლიან დიდ რიცხვად, რომელიც ინტეჯერში შეიძლება არც ჩაეტიოს. ვიღებ უნიკალურ რიცხვს, რომელიც წერია სტრინგში და ვაბრუნებ ამ სტრინგის ჰეშკოდს.
		String a = ((Double) width).toString();
		String b = ((Double) height).toString();
		String c = a + b;
		return c.hashCode();
	}
	
	@Override
	public int compareTo(Object a) {
		
		if(a instanceof Rectangle) {
		Rectangle x = (Rectangle) a;
		if(this.getWidth() == x.getWidth() && this.getHeight() == x.getHeight()) {
			return 0;
		}
		return Double.compare(this.getArea(), x.getArea());
		}else {
			return 1; // თუ შესადარებელი ობიექტი არ არის Rectangle ტიპის, მაშინ მეტად ვაბრუნებ Rectangle-ობიექტს.
		}
	
	}
	
}


