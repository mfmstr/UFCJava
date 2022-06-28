package ufc.l15;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleApp {
	
	public static void main(String[] args) {
		
		try {
		sumNumbers();
		}catch(FileNotFoundException e) {
			System.err.println("faili ar moidzebna");
		}catch(RuntimeException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	
	}
	
	private static boolean isInt(String num) {
		try {
			Integer.valueOf(num);
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}
	
		private static void sumNumbers() throws IOException {
	
		try(BufferedReader xbf = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\User\\Desktop\\UFCL15\\UFCL15\\src\\users.dat"), "UTF-8"));){
		
		Console console = System.console();
		if(console == null) {
		System.err.println("No Console Found!");
		System.exit(1);
		}	
			
		String username = console.readLine("Enter Username: ");
		
		char[] password = console.readPassword("Enter Password: ");
		
		String a = xbf.readLine();
		if(a == null || a == "") {
			console.printf("baza carielia");
			System.exit(1);
		}
		
		int userOrPassword = 1;
		boolean checkUser = false;
		boolean logIn = false;
		String loggedInUser = "";
		
		while(a != null) {
			if(userOrPassword % 2 == 1) {
				if(username.equals(a)) {
					checkUser = true;
					loggedInUser = a;
				}
				a = xbf.readLine();
				userOrPassword++;
			}else {
				if(checkUser == true) {
					if(new String(password).equals(a)) {
						logIn = true;
						break;
					}else {
						checkUser = false;
					}
				}
				a = xbf.readLine();
				userOrPassword++;
			}
			
		}
		
		if(logIn == false) {
			console.printf("username an paroli arasworia");
			System.exit(1);
		}else {
			console.printf("tkven warmatebit shemoxvedit sistemashi rogorc %s%n", loggedInUser);
			int sum = 0;
			String num;
			while((num = console.readLine("num: ")) != null) {
				if(isInt(num)) {
					if(Integer.valueOf(num)>=0) {
					sum += Integer.valueOf(num);
					console.printf("jami %s%n", sum);
					}else {
						console.printf("mteli ricxvi unda ikos 0 an dadebiti!%n");
					}
				}else {
					console.printf("shemoitanet mxolod mteli ricxvi!%n");
				}
			}
			
		}
	}
	}
	
}
