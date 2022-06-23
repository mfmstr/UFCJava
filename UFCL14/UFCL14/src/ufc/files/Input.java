package ufc.files;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Input {

	public static void main(String[] args){
		
		try {
			
		System.out.println(ReadAllLines(new FileInputStream("src/ufc/files/Source.txt"), "UTF-8"));
		
		}catch(FileNotFoundException e) {
		
			System.err.println("Faili ar moidzebna!");
		
		}catch(UnsupportedEncodingException e) {
			
			System.err.println("Encodingi arasworadaa mititebuli!");
		
		}catch(IOException e) {
		
			System.err.println("Failis wakitxvisas dapiksirda shecdoma!");
		
		}
	
	}
	
	public static String ReadAllLines(InputStream is, String encoding) throws IOException {
		
		InputStreamReader x = new InputStreamReader(is, encoding);
		BufferedReader xbf = new BufferedReader(x);
		
		String txt = "";
		String ans = "";
		
		txt = xbf.readLine(); // პირველ ხაზს ვკითხულობ while - ციკლის გარეთ, რადგან do-ში შევძლო txt-ს ორჯერ შემოწმება. 
		if(txt != null && txt != "") {
		
		do { // do-თი ვწერ პირველ ხაზს სტრინგში, რომელსაც დაემატება ყველა სხვა ხაზი. რათქმაუნდა ვამოწმებ რომ null არ იყოს.
			 // მხოლოდ ამის შემდეგ ვკითხულობ შემდეგ ხაზს, და თუ არსებობს, მაშინ line.seperator-ით ჩამაქვს ქვედა ხაზზე ტექსტი, ხოლო თუ შემდეგი ხაზი null-ია, მაშინ არა.
			if(txt != null) {
				ans += txt;
				txt = xbf.readLine();
			}
			
			if(txt != null) {
				ans += System.getProperty("line.separator");
			}
		}
		while(txt != null);
		}else {
			System.err.println("Faili carielia");
		}
		
		xbf.close();
		
		return ans;
		
	}

}
