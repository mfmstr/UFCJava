package ufc.l19.main;
// შემეძლო გამეწერა ჯენერიკი MinMaxTuple<E> - რომელსაც უკვე მეთოდში ჩავაწვდიდი ფიგურას, თუმცა ამ შემთხვევაში ეს მეთოდი სხვაგან არ მჭირდება და დავწერე კონკრეტულად ფიგურისთვის.
// ჯენერიკიანი კლასი გაწერილი მაქვს NumString - კლასში, სადაც რეალურად ვიყენებ მას სხვადასხვა ტიპის ცვლადებისთვის.
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
