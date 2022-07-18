package ufc.l18.main;

import java.util.Comparator;

public class FigureComparator implements Comparator<Figure>{

	@Override
	public int compare(Figure o1, Figure o2) {
		return -Double.compare(o1.getLength(), o2.getLength());
	}

}
