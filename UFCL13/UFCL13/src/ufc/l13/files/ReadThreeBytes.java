package ufc.l13.files;

import java.io.*;
public class ReadThreeBytes {
	public static void main(String[] args) {
		InputStream inp = null;
		try {
			inp = new BufferedInputStream(new FileInputStream("d:\\Hello.txt"));
			int byteVal;
			byte[] hello = new byte [3];
			OutputStream reversed = new BufferedOutputStream(new FileOutputStream("d:\\ReversedThreeBytes.txt"));
			
			inp.read(hello, 0, 3); // ვკითხულობ 3-3 ბიტით;
			
			for(int i = 0; i < hello.length; i++) {
				reversed.write(hello[i]);
			} // ვახდენ ჩაწერას
			
			inp.read(hello, 0, 2); // შემდგომ ისევ ვკითხულობ
			
			
			
			// ვინაიდან hello - შედგება 5 სიმბოლოსგან, 3 ბიტს ავიღებ 1ხელ და შემდეგ 2 ბიტს გადავაწერ Hello მასივს და ისე წავიკითხავ.
			for(int i = 0; i < hello.length - 1; i++) {
				reversed.write(hello[i]);
			}
			
			// ზემოთ დაწერილი მაქვს დეტალური აღწერა, დიდი ტექსტის შემთხვევაში ჩავწერდი while loopit --> while (-1 != (byteVal = inp.read()))
			// -1 ნიშნავს, რომ ფაილის ბოლო წევრზე ვდგავართ და იმის იქით არაფერი წერია, ამიტომ აბრუნებს -1;
			//inp.read(hello, 0, 3); // ვკითხულობ 3-3 ბიტით;
			
			/*for(int i = 0; i < hello.length; i++) {
				reversed.write(hello[i]);
			} გავიმეორებდი იგივე კოდს. */
		
			
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
	}
}


