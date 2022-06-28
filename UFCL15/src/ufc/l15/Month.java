package ufc.l15;

public class Month {
	
	public static void main(String[] args) {
		
		
		try {
		String month = args[0];
		switch (month) {   
		   case "January": System.out.println("kenti - 1"); break;
		   case "February": System.out.println("luwi - 2"); break;
		   case "March": System.out.println("kenti - 3"); break;
		   case "Arpil": System.out.println("luwi - 4"); break;
		   case "May": System.out.println("kenti - 5"); break;
		   case "June": System.out.println("luwi - 6"); break;
		   case "July": System.out.println("kenti - 7"); break;
		   case "August": System.out.println("luwi - 8"); break;
		   case "September": System.out.println("kenti - 9"); break;
		   case "Octomber": System.out.println("luwi - 10"); break;
		   case "November": System.out.println("kenti - 11"); break;
		   case "December": System.out.println("luwi - 12"); break;
		   default: System.err.println("msgavsi tve ar arsebobs");
		}
		}catch(ArrayIndexOutOfBoundsException e){
			System.err.println("aucileblad sheikvanet mxolod erti mnishvneloba!");
		}
		
	}

}
