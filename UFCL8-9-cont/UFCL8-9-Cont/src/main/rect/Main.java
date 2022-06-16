package main.rect;

import java.util.ArrayList;	
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		ArrayList col = new ArrayList();
		Rectangle a = new Rectangle(10, 20);
		col.add(a);
		col.add(new Rectangle(5, 10));
		col.add(new Rectangle(20, 4));
		col.add(new Rectangle(20, 4));
		col.add(new Rectangle(3, 4));
		col.add(new Rectangle(5, 4));
		col.add(new Rectangle(5, 20));
		col.add(new Rectangle(5, 20));
		col.add(new Rectangle(40, 220));
		col.add(new Rectangle(4, 3.5));
		
		Collections.sort(col); // ალაგებს ფართობების მიხედვით ზრდით(Comparable).
		
		for(int i = 0; i < col.size(); i++) {
			System.out.println(col.get(i));
		}
		
		System.out.println();
		
		Collections.sort(col, new RectAreaComperator()); // ალაგებს ასევე ფართობების მიხედვით ზრდით(Comparator).
		
		for(int i = 0; i < col.size(); i++) {
			System.out.println(col.get(i));
		}
		
		int index = Collections.binarySearch(col, new Rectangle(2, 10), new RectAreaComperator());
		
		System.out.println();
		
		System.out.println("20-is toli fartobis mkone martkutxedis indeqsi: " + index); // გამოაქვს 2, რადგან 20 ფართობის მნიშვნელობად აქვს ფართობებით ზრდადობით დალაგებულ მასივში მესამე ელემენტს;
		
		System.out.println();
		
		Collections.sort(col, new RectPerimeterComperator()); // ალაგებს პერიმეტრების მიხედვით, კლებადობით(Comparator).
		
		for(int i = 0; i < col.size(); i++) {
			System.out.println(col.get(i));
		}
		
		System.out.println();
		
		int nextIndex = Collections.binarySearch(col, new Rectangle(5, 2.5), new RectPerimeterComperator()); // ვეძებ მართკუთხედს, რომლის პერიმეტრიც არის 15;
		
		System.out.println("Rectangle's, with perimeter of 15, index is: " + nextIndex); // გამოაქვს 8, რადგან პერიმეტრების კლებადობით დასორტირებულ მასივში 15 მნიშვნელობის მქონე ელემენტია არის მეცხრე;
		
		
		
		int oneMoreIndex = Collections.binarySearch(col, new Rectangle(3, 4), Collections.reverseOrder()); // ვეძებ მართკუთხედს, რომლის სიგრძეც უდრის აუცილებლად 3-ს, ხოლო სიგანე აუცილებლად 4-ს.
		System.out.println();
		System.out.println("Width: 3, Height: 4 Rectangle --> Index: " + oneMoreIndex);
	
		System.out.println();
		
		Iterator iter = col.iterator();
		
		
		// ვბეჭდავ მასივს იტერატორით
		while(iter.hasNext()) {
			
			System.out.println("Iterator: " + iter.next());

		}
		
		System.out.println();
		
		col.forEach(rect -> System.out.println("forEach: " + rect)); // ვბეჭდავ მასივს forEach ოპერატორით;
		
		System.out.println("TreeSet----------------------------------------------------");
		
		TreeSet tr = new TreeSet();
		
		
		// TreeSet-ში გადავიტანე col-ის ელემენტები. tr-ში col-იდან გადავიდა მხოლოდ უნიკალური წევრები, რომლებიც დასორტირდა Comparable მეთოდით.
		for(var i = 0; i < col.size(); i++) {
			tr.add(col.get(i));
		}
		
		System.out.println(tr);
		
		TreeSet trPer = new TreeSet(new RectPerimeterComperator());
		
		// trPer-ში col-იდან ასევე გადავიდა მხოლოდ უნიკალური წევრები, თუმცა ამჯერად სორტირება გაიარა პერიმეტრის Comperator-ით.
		for(var i = 0; i < col.size(); i++) {
			trPer.add(col.get(i));
		}
		
		System.out.println("TreeSet2----------------------------------------------------");
		System.out.println(trPer);
		
		HashSet hs = new HashSet();
		
		for(var i = 0; i < col.size(); i++) {
			hs.add(col.get(i));
		}
		
		// HashSet hs-ში, Equals და hashCode მეთოდების გადაფარვით გადმოვიტანეთ შესაბამისი ტოლობის გათვალისწინებით უნიკალური მართკუთხედები.
		System.out.println("HashSet----------------------------------------------------");
		System.out.println(hs);
		

		System.out.println("TreeMap-------------------------------------------------------");
		
		
		// შევქმენით TreeMap, რომელსაც Key-დ გადაეცემა Rectangle ტიპის ობიექტები, ხოლო მნიშვნელობებად სტრიქონები. Key-ების მიხედვით დასორტირდა ბუნებრივი შედარების საფუძველზე.
		TreeMap tm = new TreeMap();
		tm.put(new Rectangle(10, 12),  "Hello");
		tm.put(new Rectangle(5, 12),  "How");
		tm.put(new Rectangle(10, 13),  "Are");
		tm.put(new Rectangle(4, 2),  "You");
		tm.put(new Rectangle(10, 12),  "?"); 
		
		String changed = (String) tm.put(new Rectangle(10, 13), "I've changed some string");
		
		String deleted = (String) tm.remove(new Rectangle(10, 12));
		
		
		System.out.println("changed: " + changed); // changed-ში შევინახეთ ჩანაცვლებული სტრიქონი, რომელიც ამ შემთხვევაში არის: "Are".

		System.out.println("deleted: " + deleted); // deleted-ში შევინახეთ წაშლილი სტრიქონი, რომელიც ამ შემთხვევაში არის: "?".
		
		System.out.println(tm);
		
		System.out.println("HashMap------------------------------------------------------------");
		
		// შევქმენი HashMap, რომელსაც გადაეცემა შესაბამისი equals, hashCode-ის გადაფარული მეთოდები და ახდენს მსგავსების დადგენას ორ Key-ს შორის. სორტირება HashMap-ში არ გვაქვს.
		// ამ შემთხვევაში დაიტოვა ბოლო მნიშვნელობა;
		HashMap hm = new HashMap();
		hm.put(new Rectangle(10, 12),  10);
		hm.put(new Rectangle(5, 12),  100);
		hm.put(new Rectangle(10, 13),  44);
		hm.put(new Rectangle(4, 2),  200);
		hm.put(new Rectangle(10, 12), 12);
		hm.put(new Rectangle(10, 12), 15);
		hm.put(new Rectangle(10, 12), 14);
		hm.put(new Rectangle(10, 12), 13);
		
		System.out.println(hm);
		
		System.out.println("Gamogvakvs mxolod key--------------------------------------");
		System.out.println(hm.keySet());
		System.out.println("Gamogvakvs mxolod valuebi--------------------------------------");
		System.out.println(hm.values());
		System.out.println("Gamogvakvs orive While da iteratorit--------------------------------------");
		
		Set entrySet = hm.entrySet();
		Iterator iterat = entrySet.iterator();
		while(iterat.hasNext()) {
			Map.Entry entry = (Map.Entry) iterat.next();
			System.out.println("[" + entry.getKey()+ "] ---> " + entry.getValue());
		}
		
		System.out.println("Gamogvakvs orive for da Map.Entryt--------------------------------------");
		for(Object obj : hm.entrySet()) {
			Map.Entry entry = (Map.Entry) obj;
			System.out.println("[" + entry.getKey()+ "] ---> " + entry.getValue());
		}
	}

}
