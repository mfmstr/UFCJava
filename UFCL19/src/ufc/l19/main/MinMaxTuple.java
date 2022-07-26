package ufc.l19.main;

public class MinMaxTuple {
	private Figure minFigure;
	private Figure maxFigure;
	
	public void setMinFigure(Figure a) {
		this.minFigure = a;
	}
	
	public void setMaxFigure(Figure a) {
		this.maxFigure = a;
	}
	
	public Figure getMinFigure() {
		return minFigure;
	}
	
	public Figure getMaxFigure() {
		return maxFigure;
	}

	@Override
	public String toString() {
		return "MinMaxTuple [minFigure=" + minFigure + ", maxFigure=" + maxFigure + "]";
	}
	
	
}
