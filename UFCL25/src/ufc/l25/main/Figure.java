package ufc.l25.main;

public abstract class Figure implements Comparable<Figure>{
	
	public abstract double getLength();

	public int compareTo(Figure another) {
		return Double.compare(this.getLength(), another.getLength());
	}
	
	public boolean equals(Object obj) {
		Circle a = (Circle) obj;
		return this.getLength() == a.getLength();
	}

}
