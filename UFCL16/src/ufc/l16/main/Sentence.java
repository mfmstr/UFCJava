package ufc.l16.main;

public class Sentence {
		public static void main(String[] args) {
			String sent = "This is a  dog.";
			sent = sent.replaceAll("[^\\w\\d]", " ");
			sent = sent.replaceAll("\\s+", " ");
			String[] ans = sent.split(" ");
			
			for(String a : ans) {
				System.out.println(a);
			}
			
		}
}
