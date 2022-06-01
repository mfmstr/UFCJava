package recAndMain;

import fig.Figure;
import squ.Square;


public class Main {
	
		public static void main(String[] args) {
		Figure fig = new Figure("Giorgi");
		Rectangle rec = new Rectangle();
		Square sq = new Square();
		
		System.out.println(fig.getArea()); // Figure კლასის მეთოდმა გამოიტანა "არარსებული რაიმე" მნიშვნელობა: -15.0
		System.out.println(fig.getPerimeter()); // Figure კლასის მეთოდმა გამოიტანა "არარსებული რაიმე" მნიშვნელობა: -10.0
		
		Figure.sayHello(); // გამოაქვს "Hello!", განსაზღვრულია Figure კლასში და არის Final.
		
		System.out.println(rec.getPerimeter()); // უპარამეტრო მეთოდს გამოაქვს 14.0, რადგან კონსტრუქტორი სიგრძეს და სიგანეს ანიჭებს შესაბამისად 4-ს და 3-ს;
		System.out.println(rec.getArea()); // უპარამეტრო მეთოდს გამოაქვს 12.0, რადგან კონსტრუქტორი სიგრძეს და სიგანეს ანიჭებს შესაბამისად 4-ს და 3-ს;
		
		System.out.println(rec.getPerimeter(12, 5)); // გადატვირთულ, ორპარამეტრიან პარამეტრიან მეთოდს გამოაქვს 34.0;
		System.out.println(rec.getArea(15, 8)); // გადატვირთულ, ორპარამეტრიან პარამეტრიან მეთოდს გამოაქვს 120.0;
		
		sq.setX(20); // განვსაზღვრე კვადრატის სიგრძე
		System.out.println(sq.getArea()); //  sq.getArea() --> იძახებს Rectangle კლასის ორპარამეტრიან getArea(double width, double height) მეთოდს და აბრუნებს ფართობს;
		System.out.println(sq.getPerimeter()); // sq.getPerimeter() --> იძახებს Rectangle კლასის ორპარამეტრიან getPerimeter(double width, double height) მეთოდს და აბრუნებს ფართობს;
		// ამ შემთხვევაში სიგრძის და სიგანის მნიშვნელობები ემთხვევა --> sq.setX(20);
		
		System.out.println(fig instanceof Figure); // True, რადგან ამ კლასში შეიქმნა;
		System.out.println(fig instanceof Rectangle); // False, რადგან Rectangle Figure-ის შთამომავალია და fig-ს Rectangle-ის თვისებები არ გააჩნია;
		System.out.println(fig instanceof Square); // False, რადგან Square Figure-ის შთამომავალია და fig-ს Square-ის თვისებები არ გააჩნია;
		
		System.out.println(rec instanceof Figure); // True, რადგან rec Figure-ის შვილია;
		System.out.println(rec instanceof Rectangle); // True, რადგან ამ კლასში შეიქმნა;
		System.out.println(rec instanceof Square); // False, რადგან Square Rectangle-ის შთამომავალია და rec-ს Square-ის თვისებები არ გააჩნია;
		
		System.out.println(sq instanceof Figure); // True, რადგან Figure sq-ს ბაბუაა;
		System.out.println(sq instanceof Rectangle); // True, რადგან Rectangle-ის მამაა;
		System.out.println(sq instanceof Square); // True, რადგან ამ კლასში შეიქმნა;
	}	
}
