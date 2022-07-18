package ufc.l18.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	
	public static void main(String[] args) {
		readCircles(args[0]);
		readCirclesUnique(args[0]);
		readRectangles(args[1]);
		readTriangles(args[2]);
	}
	


	public static void readCircles(String a){
		try(BufferedReader xbf = new BufferedReader(new InputStreamReader(new FileInputStream(a), "UTF-8"));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\Circles_out.dat")));){
			a = xbf.readLine();
			List<Circle> cir = new ArrayList<Circle>();
			while(a != null) {
				Circle x = new Circle(Double.valueOf(a));
				if(x.checkValidation()) {
					cir.add(x);
				}
				a = xbf.readLine();
			}		
			
			Collections.sort(cir);
			
			for(Circle c : cir) {
				out.write(c.toString());
				out.write(System.lineSeparator());
			}
			
		}catch(IOException e) {
			System.err.println("Failis wakitxvisas an failshi chawerisas dapiksirda shecdoma.");
		}
		}
	
	public static void readCirclesUnique(String a){
		try(BufferedReader xbf = new BufferedReader(new InputStreamReader(new FileInputStream(a), "UTF-8"));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\Circles_out_unique.dat")));){
			a = xbf.readLine();
			Set<Circle> uniqueCircles= new HashSet<Circle>();
			while(a != null) {
				Circle x = new Circle(Double.valueOf(a));
				if(x.checkValidation()) {
					uniqueCircles.add(x);
				}
				a = xbf.readLine();
			}		
			
			for(Circle c : uniqueCircles) {
				out.write(c.toString());
				out.write(System.lineSeparator());
			}
			
		}catch(IOException e) {
			System.err.println("Failis wakitxvisas an failshi chawerisas dapiksirda shecdoma.");
		}
		}
	
	public static void readRectangles(String a){
		try(BufferedReader xbf = new BufferedReader(new InputStreamReader(new FileInputStream(a), "UTF-8"));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\Rectangles_out.dat")));){
			a = xbf.readLine();
			Set<Rectangle> rect = new TreeSet<Rectangle>();
			
			while(a != null) {
				String splited[] = a.split("_");
				Rectangle x = new Rectangle(Double.valueOf(splited[0]), Double.valueOf(splited[1]));
				if(x.checkValidation()) {
					rect.add(x);
				}
				a = xbf.readLine();
			}		
			
			for(Rectangle r : rect) {
				out.write(r.toString());
				out.write(System.lineSeparator());
			}
			
		}catch(IOException e) {
			System.err.println("Failis wakitxvisas an failshi chawerisas dapiksirda shecdoma.");
		}
		}
	
	public static void readTriangles(String a){
		try(BufferedReader xbf = new BufferedReader(new InputStreamReader(new FileInputStream(a), "UTF-8"));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\Triangles_out.dat")));){
			a = xbf.readLine();
			Set<Triangle> tri = new TreeSet<Triangle>(new FigureComparator());
			
			while(a != null) {
				String splited[] = a.split("_");
				Triangle x = new Triangle(Double.valueOf(splited[0]), Double.valueOf(splited[1]), Double.valueOf(splited[2]));
				if(x.checkValidation()) {
					tri.add(x);
				}
				a = xbf.readLine();
			}		
			
			for(Triangle t : tri) {
				out.write(t.toString());
				out.write(System.lineSeparator());
			}
			
		}catch(IOException e) {
			System.err.println("Failis wakitxvisas an failshi chawerisas dapiksirda shecdoma.");
		}
		}
}

