package ufc.l7.main;

public class Main {

	public static void main(String[] args) {
		
		Figure rec = new Rectangle(10, 15);
		Figure tr = new Triangle(10, 11, 12, 7); // პირველი 3 პარამეტრი გვერდებია, მეოთხე სიმაღლე;
		
		printInfo(rec); // გამოაქვს: Area: 150.0 - Perimeter: 50.0 | Width: 10.0 Height: 15.0
		printInfo(tr); // გამოაქვს: Area: 35.0 - Perimeter: 33.0 | A: 10.0 B: 11.0 C: 12.0
		
		printHelloIfValid(rec); // გამოაქვს: Hello Rectangle
		Figure rec2 = new Rectangle(-2, 15);
		printHelloIfValid(rec2); // გამოაქვს: Invalid Figure, რადგან მართკუთხედის რომელიმე გვერდი ნულია ან უარყოფითი;
		
		printHelloIfValid(tr); // გამოაქვს: Hello Triangle
		Figure tr2 = new Triangle(5, 10, 16, 8);
		printHelloIfValid(tr2); // გამოაქვს: Invalid Figure, რადგან გვერდების ჯამების წესი ირღვევა;
		Figure tr3 = new Triangle(5, 0, 13, -1); // გამოაქვს: Invalid Figure, რადგან სიმაღლე ან რომელიმე გვერდი ნოლია ან უარყოფითი;
		printHelloIfValid(tr3);
		
		System.out.println(rec); // გამოვასწორე toString()-მეთოდიც, გამოაქვს: Width: 10.0 | Height: 15.0| Perimeter: 50.0| Area: 150.0
		System.out.println(tr); // გამოაქვს: A: 10.0 | B: 11.0 | C: 12.0| Perimeter: 33.0| Area: 35.0

	}
	
	public static void printInfo(IFigure s) {
		s.printFigureAreaAndLength();
		s.printFigureData();
	}
	
	public static void printHelloIfValid(IFigureAnother s) {
		if(s.validateFigure()) {
			s.sayHelloToFigure();
		}else {
			System.out.println("Invalid Figure");
		}
	}

}
