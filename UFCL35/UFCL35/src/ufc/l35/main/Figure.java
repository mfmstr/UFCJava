package ufc.l35.main;

public abstract class Figure implements Comparable<Figure>{
	
	public abstract double getLength();

	public int compareTo(Figure another) {
		return Double.compare(this.getLength(), another.getLength());
	}
	
	public boolean equals(Object obj) {
		Figure a = (Figure) obj;
		return this.getLength() == a.getLength();
	}

}
