package ufc.l7.main;

public abstract class Figure implements IFigure, IFigureAnother {
		
	public abstract double getPerimeter();
	
	public abstract double getArea();
	
	@Override
	public void printFigureAreaAndLength() {
		System.out.println("Area: " + getArea() + " - Perimeter: " + getPerimeter());
	}
	
}


