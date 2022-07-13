package ufc.l16.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {
		public static void main(String[] args) {
			
			String client = "ClientName: Mark Twain,  Address: London, Balance: 123.56";
			
			Pattern pattern = Pattern.compile("ClientName: (\\w+ \\w+),  Address: (\\w+), Balance: ([0-9]+.[0-9]+)");
			Matcher matcher = pattern.matcher(client);
			
			matcher.matches();
			System.out.println(matcher.group(1));
			System.out.println(matcher.group(2));
			System.out.println(matcher.group(3));
			
		}
}
