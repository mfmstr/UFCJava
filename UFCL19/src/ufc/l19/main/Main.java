package ufc.l19.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		readCircles("src\\Circles_in.dat");
		readRectangles("src\\\\Rectangles_in.dat");
		readTriangles("src\\Triangles_in.dat");
	}
	
	
	public static void readCircles(String f){
		try(BufferedReader xbf = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-8"));){
			TreeMap<Integer, Circle> circleTreeMap = new TreeMap<>();
			TreeSet<Circle> circleTreeSet= new TreeSet<>();
			ArrayList<Circle> circleArrList = new ArrayList<>();
			String a = xbf.readLine();
			while(a != null) {
				Circle x = new Circle(Double.valueOf(a));
				if(x.checkValidation()) {
					circleTreeSet.add(x);
					circleArrList.add(x);
				}
				a = xbf.readLine();
			}
			
			int counter = 1;
			
			for(int i = 0; i < circleArrList.size(); i++) {
				circleTreeMap.put(counter, circleArrList.get(i));
				counter++;
			}
		
			System.out.println(getMinMax(circleTreeSet));
			System.out.println(getMinMax(circleArrList));
			
			int line = 1;
			
			for(int i = 1; i < circleTreeMap.size(); i++) {
				if(getMinMax(circleArrList).getMaxFigure().equals(circleTreeMap.get(i))) {
					line = i;
				}
			}
			
			System.out.println("Maximum Circle is on line: " + line);
			
		}catch(IOException e) {
			System.err.println("Failis wakitxvisas an failshi chawerisas dapiksirda shecdoma.");
		}
		}
	
	public static void readRectangles(String f){
		try(BufferedReader xbf = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-8"));){
			
			TreeMap<Integer,Rectangle> rectTreeMap = new TreeMap<>();
			TreeSet<Rectangle> rectTreeSet = new TreeSet<>();
			ArrayList<Rectangle> rectArrList = new ArrayList<>();
			String a = xbf.readLine();
			while(a != null) {
				String splited[] = a.split("_");
				Rectangle x = new Rectangle(Double.valueOf(splited[0]), Double.valueOf(splited[1]));
				if(x.checkValidation()) {
					rectTreeSet.add(x);
					rectArrList.add(x);
				}
				a = xbf.readLine();
			}		
			int counter = 1;
			for(int i = 0; i < rectArrList.size(); i++) {
				rectTreeMap.put(counter, rectArrList.get(i));
				counter++;
			}
			
			System.out.println(getMinMax(rectTreeSet));
			System.out.println(getMinMax(rectArrList));
			
			int line = 1;
			
			for(int i = 1; i <= rectTreeMap.size(); i++) {
				if(getMinMax(rectArrList).getMaxFigure().equals(rectTreeMap.get(i))) {
					line = i;
				}
			}
			
			System.out.println("Maximum Rectangle is on line: " + line);
			
			
			
			
		}catch(IOException e) {
			System.err.println("Failis wakitxvisas an failshi chawerisas dapiksirda shecdoma.");
		}
		}
	
	public static void readTriangles(String f){
		try(BufferedReader xbf = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-8"));){
			
			TreeMap<Integer,Triangle> triTreeMap = new TreeMap<>();
			TreeSet<Triangle> triTreeSet = new TreeSet<>();
			ArrayList<Triangle> triArrList = new ArrayList<>();
			String a = xbf.readLine();
			while(a != null) {
				String splited[] = a.split("_");
				Triangle x = new Triangle(Double.valueOf(splited[0]), Double.valueOf(splited[1]), Double.valueOf(splited[2]));
				if(x.checkValidation()) {
					triTreeSet.add(x);
					triArrList.add(x);
				}
				a = xbf.readLine();
			}		
			
			int counter = 1;
			for(int i = 0; i < triArrList.size(); i++) {
				triTreeMap.put(counter, triArrList.get(i));
				counter++;
			}
			

			System.out.println(triTreeMap);
			System.out.println(getMinMax(triTreeSet));
			System.out.println(getMinMax(triArrList));
			
			int line = 1;
			for(int i = 1; i <= triTreeMap.size(); i++) {
				if(getMinMax(triArrList).getMaxFigure().equals(triTreeMap.get(i))){
					line = i;
				}
			}
			System.out.println("Maximum Triangle is on line: " + line);
			System.out.println(triTreeMap);
			
		}catch(IOException e) {
			System.err.println("Failis wakitxvisas an failshi chawerisas dapiksirda shecdoma.");
		}
		}
	
	public static MinMaxTuple getMinMax(TreeSet<? extends Figure> u) {
		MinMaxTuple x = new MinMaxTuple();
		x.setMinFigure(u.first());
		x.setMaxFigure(u.last());
		return x;
	}
	
	public static MinMaxTuple getMinMax(ArrayList<? extends Figure> u) {
		MinMaxTuple x = new MinMaxTuple();
		Collections.sort(u);
		x.setMinFigure(u.get(0));
		x.setMaxFigure(u.get(u.size()-1));
		return x;
	}
}



