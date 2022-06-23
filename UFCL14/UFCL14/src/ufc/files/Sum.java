package ufc.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Sum {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Hello Sum!");
		
		InputStream is = System.in;
		
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		
		BufferedReader br = new BufferedReader(isr);
		
		String name;
		
		int sum = 0;
		
		System.out.println("Enter whole number: ");
		
		while(!(name = br.readLine()).equals("end")) {
			
			try {
				
			checkInt(name);
			
			// აქ კიდევ ერთხელ ვიზღვევ თავს, იმ შემთხვევაში თუ ექსეფშენი არ გავარდება.(ალბათ არ არსებობს ეგეთი შემთხვევა, მაგრამ მაინც).
			if(checkInt(name) == true) {
				
			sum = sum + Integer.parseInt(name);
			
			System.out.println("Total SUM: " + sum);
			
			}else {
			
				System.out.println("Incorrect whole number value");
			
			}
			
			}catch(NumberFormatException e) {
				
				System.err.println("Incorrect whole number value");
			
			}
			
			System.out.println("Enter whole number: ");
		
		}
		
		System.out.println("Bye SUM");
		
	}
	
	public static boolean checkInt(String name) {
		
		// დავწერე მეთოდი, რომლითაც სტრინგი ინტეჯერში გადამყავს, შემდგომ კი თავის დაზღვევის მიზნით კიდევ ერთხელ ვამოწმებ.
		// თუ სტრინგი ინტეჯერი არ იქნება, ისვრის ექსეფშენს, რომელიც მეინ მეთოდში მაქვს დაჭერილი და აგდებს შესაბამის მითითებას.
		
		int x = Integer.parseInt(name);
		
		if(x == (int) x) {
		
			return true;
		
		}else {
		
			return false;
		}
	}

}
