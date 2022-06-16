package ufc.main;

public class Main {
		public static void main(String[] args) throws RectangleValidateException, TriagleValidateException {
			
			Rectangle x = new Rectangle(10, 20);
			x.validate(); // გამოაქვს: "martkutxedi warmatebit sheikmna";
			
			
			//Rectangle y = new Rectangle(10, 0);
			
			//y.validate(); გამოაქვს ქვემოთ ნაჩვენები ტექსტი;
			
			
			//Exception in thread "main" ufc.main.RectangleValidateException: martkudxedis orive aucileblad meti unda ikos 0-ze!!!
			//at ufc.main.Rectangle.validate(Rectangle.java:40)
			//at ufc.main.Main.main(Main.java:9)
			
			Triangle a = new Triangle(4, 5, 6);
			a.validate(); // გამოაქვს: samkutxedi warmatebit sheikmna
			
			Triangle b = new Triangle(4, 10, 6);
			
			
			//b.validate(); გამოაქვს ქვემოთ ნაჩვენები ტექსტი;
			
			
			// Exception in thread "main" ufc.main.TriagleValidateException: samkutxedis nebismieri ori gverdis jami aucileblad meti unda ikos mesameze!!!
			// at ufc.main.Triangle.validate(Triangle.java:37)
			// at ufc.main.Main.main(Main.java:20)
			
			Rectangle rec1 = new Rectangle(10, 20);
			Rectangle rec2 = new Rectangle(10, 20);
			Rectangle rec3 = new Rectangle(10, 20);
			Rectangle rec4 = new Rectangle(10, 20);
			
			// აქამდე შემაქმნევინა ყველა მართკუთხედი ახლა ჯამში ხუთია, ზემოთ x-იც განსაზღვრულია.
			
			System.out.println(Rectangle.counter); // აქ ბეჭდავს 5-ს;
			
			Rectangle rec5 = new Rectangle(10, 20); // ეს მეექვსე მართკუთხედი გამოდის.
			
			// აგდებს ქვემოთ მოცემულ კოდს. LimitException შეგვიძლია ჩავწეროთ ზედა ორთან ერთად მეინ მეთოდის ტანში, თუმცა აუცილებელი არ არის.
			
			// Exception in thread "main" ufc.main.LimitException: martkutxedta raodenobam 5s gadaacharba
			// at ufc.main.Rectangle.<init>(Rectangle.java:17)
			// at ufc.main.Main.main(Main.java:41)

			
		}
}
