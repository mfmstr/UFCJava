package ufc.l30.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Problem4 {
	public static void main(String[] args) {
		CreateXMLWithJDOM();
		findElementsWithXPath();
	}
	
	public static void CreateXMLWithJDOM() {
		try {
            Element recElement = new Element("circles");
            Document doc = new Document(recElement);

            for(int i = 0; i < 100; i++) {
            
            double radius = Math.round(Math.random() * 100 + 1);	
            	
            Element innerRecElement = new Element("circle");

            Element radiusElement = new Element("radius");
            radiusElement.setText(String.valueOf(radius));
            
            innerRecElement.addContent(radiusElement);
            
            doc.getRootElement().addContent(innerRecElement);
            }

            XMLOutputter xmlOutput = new XMLOutputter();

            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileOutputStream("src\\circles_with_jdom_out.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void findElementsWithXPath() {
		try {
            File inputFile = new File("src\\circles_with_jdom_out.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = dBuilder.parse(inputFile);
            
            ((org.w3c.dom.Document) doc).getDocumentElement().normalize();
            
            ArrayList<Circle> circleArrayList = new ArrayList<>();
            Circle firstCircleWithRadiusMoreOrEqualThanForty;
            
            XPath xPath = XPathFactory.newInstance().newXPath();

            XPathExpression xPathExpression = xPath.compile("/circles/circle[radius <= 30]");
            NodeList nodeList = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
            
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nNode = nodeList.item(i);
                double radius = Double.valueOf(nNode.getTextContent());
                circleArrayList.add(new Circle(radius));
            }   
            
            xPathExpression = xPath.compile("/circles/circle[radius >= 40]");
            nodeList = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
            
            firstCircleWithRadiusMoreOrEqualThanForty = new Circle(Double.valueOf(nodeList.item(0).getTextContent()));
            
            System.out.println("LWist of Circles with radius less or equal than 30:");
            System.out.println(circleArrayList);
            System.out.println("The first Circle with radius more than 40:");
            System.out.println(firstCircleWithRadiusMoreOrEqualThanForty);
            
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
	}
}