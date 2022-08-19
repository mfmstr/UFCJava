package ufc.l29.main;

import java.io.File;
import java.util.Random;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Problem2Sax {
	public static void main(String[] args) {
		readCircles();
		readRectangles();
	}
	
	public static void readCircles() {
		        try {
		            File inputFile = new File("src//circles_output.xml");
		            SAXParserFactory factory = SAXParserFactory.newInstance();
		            SAXParser saxParser = factory.newSAXParser();
		            UserHandler userhandler = new UserHandler();
		            saxParser.parse(inputFile, userhandler);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
	
	public static void readRectangles() {
        try {
            File inputFile = new File("src//rectangles_output.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public static void readTriangles() {
        try {
            File inputFile = new File("src//triangles_output.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

		class hello extends DefaultHandler{
	
}

		class UserHandler extends DefaultHandler {

		    boolean bradius = false;
		    boolean bwidth = false;
		    boolean bheight = false;
		    boolean bA = false;
		    boolean bB = false;
		    boolean bC = false;

		    @Override
		    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		        if (qName.equalsIgnoreCase("radius")) {
		            bradius = true;
		        }else if(qName.equalsIgnoreCase("width")) {
		        	bwidth = true;
		        }else if(qName.equalsIgnoreCase("height")) {
		        	bheight = true;
		        }else if(qName.equalsIgnoreCase("a")) {
		        	bA = true;
		        }else if(qName.equalsIgnoreCase("b")) {
		        	bB = true;
		        }else if(qName.equalsIgnoreCase("c")) {
		        	bC = true;
		        }
		    }

		    @Override
		    public void endElement(String uri, String localName, String qName) throws SAXException {

		        if (qName.equalsIgnoreCase("circles")) {
		            
		        }else if(qName.equalsIgnoreCase("rectangles")) {
		        	
		        }else if(qName.equalsIgnoreCase("triangles")){
		        	
		        }
		    }

		    @Override
		    public void characters(char ch[], int start, int length) throws SAXException {
		    	
		        if (bradius) {
		            System.out.println(new Circle(Double.valueOf(new String(ch, start, length))));
		            bradius = false;
		        }
		        if (bwidth) {
		            Rectangle a = new Rectangle();
		            a.setA(Double.valueOf((new String(ch, start, length))));
		            a.setB(3.1); // ერთ კლასში მაქვს სამივე ფიგურის გვერდები, ამ მეთოდში შემოსვლისას ტოვებს მხოლოდ 1 გვერდს, 2-ს ხელით ვუსეტავ, რადგან 1 გვერდით New Rectangle()-ს ვერ შევქმნი.
		            System.out.println(a);
		        	bwidth = false;
		        }
		        if (bheight) {
		        	Rectangle a = new Rectangle();
		            a.setB(Double.valueOf((new String(ch, start, length))));
		            a.setA(2.2);
		            System.out.println(a);
		            bheight = false;
		        }
		        if (bA) {
		        	Triangle t = new Triangle();
		        	t.setA(Double.valueOf((new String(ch, start, length))));
		        	t.setB(2.3);
		        	t.setC(3.1);
		        	System.out.println(t);
		            bA = false;
		        }
		        if (bB) {
		        	Triangle t = new Triangle();
		        	t.setB(Double.valueOf((new String(ch, start, length))));
		        	t.setA(6);
		        	t.setC(7);
		        	System.out.println(t);
		        	bB = false;
		        }
		        if (bC) {
		        	Triangle t = new Triangle();
		        	t.setC(Double.valueOf((new String(ch, start, length))));
		        	t.setA(10.2);
		        	t.setB(11.9);
		        	System.out.println(t);
		            bC = false;
		        }
		        
		    }
	}

