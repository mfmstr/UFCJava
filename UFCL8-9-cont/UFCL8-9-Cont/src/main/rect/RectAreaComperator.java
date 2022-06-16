package main.rect;

import java.util.Comparator;

public class RectAreaComperator implements Comparator {

	@Override
	public int compare(Object a, Object b) {
		
		if(a instanceof Rectangle & b instanceof Rectangle) {
		
		Rectangle x = (Rectangle) a;
		Rectangle y =  (Rectangle) b;
		
		return Double.compare(x.getArea(), y.getArea());
	}else {
		return -1;
	}

}
}
