package ufc.main;

public class Main {
		public static void main(String[] args) {
			
			
			
			try{ // ამოწმებს მართკუთხედს
				try { // მართვა რჩება მთავარ TRY-ში
				Figure rec1 = new Rectangle(210, 20);
				rec1.validate();
				}catch (RectangleValidateException e) {
					System.out.println("martkudxedis orive aucileblad meti unda ikos 0-ze!!!");
				}
				Figure rec2 = new Rectangle(-3, 20);
				rec2.validate("Validation Finished Unsuccessfully"); // Figure კლასში გადავტვირთე validate მეთოდი, შემდეგ გადმოვიტანე რექთსა და Tri-ში, სტრიქონიანი validate მეთოდი ბეჭდავს შესაბამის შეტყობინებას, ამ შემთხვევაში Validation Finished Unsuccessfully-ს. 
				
				Figure rec3 = new Rectangle(3, 20); //;
				rec3.validate();
				
				
				Figure rec4 = new Rectangle(4, 20);
				rec4.validate();
				
				Figure rec5 = new Rectangle(5, 20);
				rec5.validate();
				
				Figure rec6 = new Rectangle(6, 20);
				rec6.validate();
				
				Figure rec7 = new Rectangle(7, 20);
				rec7.validate();
				
			}catch(RectangleValidateException e){
				
				System.out.print("martkudxedis orive aucileblad meti unda ikos 0-ze!!!");
			
			} catch (ValidateException e) {
			
				System.out.println("figura arasworadaa shekmnili");
			
			}  finally { // Finally Block
				System.out.println("Good Bye Figures.");
			}
			
			
			try { // ამოწმებს სამკუთხედს
				Triangle tr = new Triangle(10, 11 ,11);
				tr.validate();
				
				Triangle tr2 = new Triangle(10, 11 ,200);
				tr2.validate();
				
			}catch(TriagleValidateException e){
				System.out.println("samkutxedis nebismieri ori gverdis jami aucileblad meti unda ikos mesameze!!!");
				
			}catch (ValidateException e) {
			
				System.out.println("figura arasworadaa shekmnili");
			
			}
			
			try{ // ამოწმებს ფიგურების რაოდენობას
				checkLimit();
			}catch (LimitException e) {
				System.out.println("Figurebis raodenobam 10-s gadaacharba");
				throw new RuntimeException("gtxovt imushaot 10 figuris farglebshi");
			}
			
			
			try { // ამოწმებს ფართობის ლიმიტს;
				Rectangle x = new Rectangle(10, 20);
				x.checkArea();
			}catch(AreaTooLargeException e) {
				System.out.println("Martkutxedis fartobi ar unda agematebodes 10 000 - s");
				throw e;
			}
			
		}
		
		public static void checkLimit() { // 
			if(Rectangle.counter + Triangle.counter > 10) {
				throw new LimitException("");
			}
		}
}
