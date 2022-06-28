package ufc.l15;

import java.util.Scanner;

public class SumWithScanner {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		
		System.out.print("Shemoitanet mteli ricxvi: ");
		
		while(sc.hasNext()) {
			if(!sc.hasNextInt()) {
				if("end".equals(sc.next())) {
					break;
				}else {
					System.err.println("Incorrect  whole number value(sheikvanet mteli ricxvi)");
					System.out.print("Sheikvanet axlidan: ");
				}
			}else {
				int a = sc.nextInt();
				if(a < 0) {
					System.err.println("Incorrect  whole number value(shekvanili ricxvi aucileblad unda ikos dadebiti an 0)");
					System.out.print("Sheikvanet axlidan: ");
				}else {
					sum += a;
					System.out.println("Jami: " + sum);
					System.out.print("Sheikvanet shemdegi ricxvi: ");
				}
			}
		}
		
		sc.close();
	}
	
}
