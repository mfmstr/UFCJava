package ufc.l16.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileNumber {
	
		public static void main(String[] args){
		
			
		String number = "(+995)[599]12-34-56";
		
		validate(number);
		
		}
		
		private static void validate(String num){
			
			
			try(BufferedReader xbf = new BufferedReader(new InputStreamReader(new FileInputStream("src\\regex.properties")));){
			


			String regex = xbf.readLine();
			
			num = num.replaceAll("\\D", "");
			
			num = num.substring(3, num.length());
			
			
			System.out.println(num);
			
			Pattern pattern = Pattern.compile(regex);
			
			Matcher matcher = pattern.matcher(num);
			
			if(matcher.matches()) {
				System.out.println("Validated");
			}else {
				System.out.println("Not Validated");
			}
		}catch(IOException e) {
			String msg = "Error Detected";
			if(msg.length()>100) {
				System.err.println(msg.substring(0, 100));
			}else {
				System.err.println(msg);
			}
		}
		}
		}	
}
