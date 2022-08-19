package ufc.l29.main;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class Problem2DOM {

		public static void main(String[] args){
			System.out.println("Circles -------------------------------");
			readCircles();
			System.out.println("Rectangles -------------------------------");
			readRectangles();
			System.out.println("Triangles -------------------------------");
			readTriangles();
		}
	
public static void readCircles() {
			
	try {
        File inputFile = new File("src//circles_output.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("circle");
        
        for (int temp = 0; temp < nList.getLength(); temp++) {
           Node nNode = nList.item(temp);
           if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               NodeList radiusList = eElement.getElementsByTagName("radius");
               
               for (int count = 0; count < radiusList.getLength(); count++) {
                  Node node1 = radiusList.item(count);
                  
                  if (node1.getNodeType() == Node.ELEMENT_NODE) {
                     Element cirRad = (Element) node1;
                     System.out.println(new Circle(Double.valueOf(cirRad.getTextContent())));
                  }
               }
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}


public static void readRectangles() {
	
	try {
        File inputFile = new File("src//rectangles_output.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("rectangle");
        
        for (int temp = 0; temp < nList.getLength(); temp++) {
           Node nNode = nList.item(temp);
           if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               NodeList recWList = eElement.getElementsByTagName("width");
               NodeList recHList = eElement.getElementsByTagName("height");
               Node node1 = recWList.item(0);
               Node node2 = recHList.item(0);
               Element recWidth = (Element) node1;
               Element recHeight = (Element) node2;
               double recA = Double.valueOf(recWidth.getTextContent());
               double recB = Double.valueOf(recHeight.getTextContent());
               
               System.out.println(new Rectangle(recA, recB));
                  
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static void readTriangles() {
	
	try {
        File inputFile = new File("src//triangles_output.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("triangle");
        
        for (int temp = 0; temp < nList.getLength(); temp++) {
           Node nNode = nList.item(temp);
           if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               NodeList triAList = eElement.getElementsByTagName("a");
               NodeList triBList = eElement.getElementsByTagName("b");
               NodeList triCList = eElement.getElementsByTagName("c");
               Node node1 = triAList.item(0);
               Node node2 = triBList.item(0);
               Node node3 = triCList.item(0);
               Element trA = (Element) node1;
               Element trB = (Element) node2;
               Element trC = (Element) node3;
               double tA = Double.valueOf(trA.getTextContent());
               double tB = Double.valueOf(trB.getTextContent());
               double tC = Double.valueOf(trC.getTextContent());
               
               System.out.println(new Triangle(tA, tB, tC));
                  
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

		
	
}

