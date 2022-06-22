package ufc.l13.files;

import java.io.*;
public class ReverseFile {
	public static void main(String[] args) {
		InputStream inp = null;
		try {
			// ფაილიდან ვკითხულობ ბიტებს ბუფერიზაციული მეთოდით, ვათავსებ მათ hello - ბიტების მასივში, შემდგომ FileOutputStream მეთოდით გადამაქვს ახალ ფაილში შებრუნებული სახით, რომელიც for-ციკლის გამოყენებით წავიკითხე ბოლოდან პირველის მიმართულებით.
			inp = new BufferedInputStream(new FileInputStream("d:\\Hello.txt"));
			int byteVal;
			byte[] hello = new byte [5];
			int i = 0;
			
			while (-1 != (byteVal = inp.read())) {
				System.out.print(byteVal + " ");
				hello[i] = (byte) byteVal;
				i++;
			}
			
			
			OutputStream reversed = new BufferedOutputStream(new FileOutputStream("d:\\Reversed.txt"));
			for(var j = hello.length - 1; j >= 0; j--) {
				reversed.write(hello[j]);
			}
			
			reversed.flush(); // ამ შემთხვევაში Close-ს დროს ავტომატურად ი-flush-ება;
			reversed.close();
			
			System.out.println("<-- warmatebit shemovida");
		} catch (FileNotFoundException e) {
			System.out.println("faili ar arsebobs");
		} catch (IOException e) {
			throw new RuntimeException("I/O Exception Occured", e);
		} finally {
			if (inp != null) {
				try { inp.close(); } catch (IOException e) {}
			}
		}
		
		
		// OutputStream reversed = new FileOutputStream("d:\\Reversed.txt"); <-- ბუფერული მეთოდის გარეშე ჩაწერისას ზემოთ(21 ხაზზე) მოცემულ კოდს ჩავანაცვლებდი ამ კოდით.
		// მსგავსად Input - ის დროს წავუშლიდი new BufferedInputStream-ს;
		
	}
}

