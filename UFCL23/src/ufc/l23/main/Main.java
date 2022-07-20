package ufc.l23.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	@SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
	public static void main(String[] args) {
		
		// Tast 8
		
		Sum sPer = (a, b) -> {
			return a.getLength() + b.getLength();
		};
		
		Sum sArea = (a,b) ->{
			return a.getArea() + b.getArea();
		};
		
		// Task 6
		
		Rectangle r = new Rectangle(0.2, 0.4);
		List<Figure> abc = new ArrayList<>();
		abc.add(r);
		lFig(abc);
		
		// Task 5
		Rectangle x = new Rectangle(10, 2.2);
		Rectangle.getLengthStatic(x);
		
		String a;
		
		List rectList = new ArrayList<>();
		
		try(BufferedReader xbf = new BufferedReader(new InputStreamReader(new FileInputStream("src\\Rectangle_in.dat"), "UTF-8"));){
				a = xbf.readLine();
				
				while(a != null) {
					String splited[] = a.split("_");
					Rectangle y = new Rectangle(Double.valueOf(splited[0]), Double.valueOf(splited[1]));
					if(y.checkValidation()) {
						rectList.add(y);
					}
					a = xbf.readLine();
				}
		}catch(IOException e) {
			System.err.println("Error while reading from file");
		}
		
		
		
}
	
	//Tast 6-7
	@SafeVarargs 
    private static void lFig(List<Figure>... figures) {
        for (List<Figure> figure : figures) {
            System.out.println(figure);
        }
        
        //BUG-iani kodi
//        Object[] array = figures; 
//        List<Integer> intList = Arrays.asList(10);
//        array[0] = intList;
//        Figure s = figures[0].get(0); //artkams ClassCastException-ს SafeVarargs-is gareshe gashvebisas;
//        System.out.println(s);
        
        //Kodi bugis gareshe
        
        Figure s = figures[0].get(0); 
        System.out.println(s);
        
    }
	
	@FunctionalInterface
	interface Sum{
		double doSum(Figure a, Figure b);
	}

}
