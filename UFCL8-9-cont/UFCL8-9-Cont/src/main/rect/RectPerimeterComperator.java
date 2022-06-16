package main.rect;

import java.util.Comparator;

public class RectPerimeterComperator implements Comparator {

	@Override
	public int compare(Object a, Object b) {
		
		if(a instanceof Rectangle & b instanceof Rectangle) {
		
		Rectangle x = (Rectangle) a;
		Rectangle y =  (Rectangle) b;
		
		return - Double.compare(x.getPerimeter(), y.getPerimeter());
	}else {
		return -1;
	}

}
}