package ufc.files;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Output {
	
		public static void main(String[] args){
			
			String readyText = "Dog!" + System.getProperty("line.separator");
			readyText += "Собака " + System.getProperty("line.separator");
			readyText += "ძაღლი";
			
			try {
				
			WriteInByLines(new PrintStream(System.out), readyText, "UTF-8" );
			
			}catch(UnsupportedEncodingException e) {
				
				System.err.println("Encodingi arasworadaa mititebuli!");
			
			}catch(IOException e) {
			
				System.err.println("Stringis gatanisas dapiksirda shecdoma!");
			
			}
			
		}
		
		public static void WriteInByLines(OutputStream os, String text, String  encoding) throws IOException {
			
			if(text != null && text != "") {
			
			OutputStreamWriter x = new OutputStreamWriter(os, encoding);
			BufferedWriter xbf = new BufferedWriter(x);
			
			xbf.write(text);
			
			xbf.close();
			}else {
				System.err.println("Teksti carielia");
			}
			
		}
	
}
