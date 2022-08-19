package ufc.l29.main;

import java.io.BufferedReader;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem1 {
	
	public static void main(String[] args) throws TransformerException, ParserConfigurationException {
		readCircles("src//Circles_in.dat");
		readRectangles("src//Rectangles_in.dat");
		readTriangles("src//Triangles_in.dat");
	}
	


	public static void readCircles(String a) throws TransformerException{
		try(BufferedReader xbf = new BufferedReader(new InputStreamReader(new FileInputStream(a), "UTF-8"));){
			
			
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("circles");
            doc.appendChild(rootElement);
			
			a = xbf.readLine();
			List<Circle> cir = new ArrayList<Circle>();
			while(a != null) {
				Circle x = new Circle(Double.valueOf(a));
				if(x.checkValidation()) {
					
					Element circle = doc.createElement("circle");
		            rootElement.appendChild(circle);
		            
		            Element radius = doc.createElement("radius");
		            circle.appendChild(radius);
		            
		            radius.appendChild(doc.createTextNode(String.valueOf(x.getRadius())));
		            
					cir.add(x);
				}
				a = xbf.readLine();
			}		
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src//circles_output.xml"));
            transformer.transform(source, result);
			
		}catch(IOException e) {
			System.err.println("Failis wakitxvisas an failshi chawerisas dapiksirda shecdoma.");
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	public static void readRectangles(String a) throws ParserConfigurationException, TransformerException{
		try(BufferedReader xbf = new BufferedReader(new InputStreamReader(new FileInputStream(a), "UTF-8"));){
			a = xbf.readLine();
			List<Rectangle> rect = new ArrayList<Rectangle>();
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("rectangles");
            doc.appendChild(rootElement);
			
			while(a != null) {
				String splited[] = a.split("_");
				Rectangle x = new Rectangle(Double.valueOf(splited[0]), Double.valueOf(splited[1]));
				if(x.checkValidation()) {
					
					Element rectangle = doc.createElement("rectangle");
		            rootElement.appendChild(rectangle);
		            
		            Element width = doc.createElement("width");
		            rectangle.appendChild(width);
		            width.appendChild(doc.createTextNode(String.valueOf(x.getA())));
		            
		            Element height = doc.createElement("height");
		            rectangle.appendChild(height);
		            height.appendChild(doc.createTextNode(String.valueOf(x.getB())));
		            
					
					rect.add(x);
				}
				a = xbf.readLine();
			}		
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src//rectangles_output.xml"));
            transformer.transform(source, result);
			
		}catch(IOException e) {
			System.err.println("Failis wakitxvisas an failshi chawerisas dapiksirda shecdoma.");
		}
		}
	
	public static void readTriangles(String a) throws ParserConfigurationException, TransformerException{
		try(BufferedReader xbf = new BufferedReader(new InputStreamReader(new FileInputStream(a), "UTF-8"));){
			a = xbf.readLine();
			List<Triangle> tri = new ArrayList<Triangle>();
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("triangles");
            doc.appendChild(rootElement);
			
			while(a != null) {
				String splited[] = a.split("_");
				Triangle x = new Triangle(Double.valueOf(splited[0]), Double.valueOf(splited[1]), Double.valueOf(splited[2]));
				if(x.checkValidation()) {
					
					Element triangle = doc.createElement("triangle");
		            rootElement.appendChild(triangle);
		            
		            Element aSide = doc.createElement("a");
		            triangle.appendChild(aSide);
		            aSide.appendChild(doc.createTextNode(String.valueOf(x.getA())));
		            
		            Element bSide = doc.createElement("b");
		            triangle.appendChild(bSide);
		            bSide.appendChild(doc.createTextNode(String.valueOf(x.getB())));
		            
		            Element cSide = doc.createElement("c");
		            triangle.appendChild(cSide);
		            cSide.appendChild(doc.createTextNode(String.valueOf(x.getC())));
		            
		            
					
					tri.add(x);
				}
				a = xbf.readLine();
			}		
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src//triangles_output.xml"));
            transformer.transform(source, result);
			
		}catch(IOException e) {
			System.err.println("Failis wakitxvisas an failshi chawerisas dapiksirda shecdoma.");
		}
		}
}

