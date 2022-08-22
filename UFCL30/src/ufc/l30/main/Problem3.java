package ufc.l30.main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import javanet.staxutils.IndentingXMLStreamWriter;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;


public class Problem3 {
	public static void main(String[] args) {
		CreateXMLWithStax();
		ReadXMLWithXPath();
	}
	
	public static void CreateXMLWithStax() {
		try {

            XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter xMLStreamWriter = xMLOutputFactory.createXMLStreamWriter(new FileOutputStream("src\\circles_out.xml"));
            IndentingXMLStreamWriter indenting = new IndentingXMLStreamWriter(xMLStreamWriter);
            
            indenting.writeStartDocument();
            indenting.writeStartElement("circles");

            
            for(int i = 0; i < 100; i++) {
            	
            	double a = Math.round(Math.random() * 100 + 1);
            	
            	indenting.writeStartElement("circle");
            	xMLStreamWriter.writeAttribute("radius", String.valueOf(a));
            	indenting.writeEndElement();
            }
            
            indenting.writeEndDocument();

            indenting.flush();
            indenting.close();

        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void ReadXMLWithXPath() {
        try {
            File inputFile = new File("src\\circles_out.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            
            doc.getDocumentElement().normalize();

            XPath xPath = XPathFactory.newInstance().newXPath();

            XPathExpression xPathExpression = xPath.compile("/circles/circle[@radius > '30']");
            NodeList nodeList = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
            
            ArrayList<Circle> circleArrayList = new ArrayList<>();
            Circle lastCircleLessThanForty;
            
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nNode = nodeList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    double radius = Double.valueOf(eElement.getAttribute("radius"));
                    	circleArrayList.add(new Circle(radius));
                    }
            }
            
            xPathExpression = xPath.compile("/circles/circle[@radius < '40']");
            nodeList = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
            Node nNode = nodeList.item(nodeList.getLength()-1);
            Element eElement = (Element) nNode;
            lastCircleLessThanForty = new Circle(Double.valueOf(eElement.getAttribute("radius")));
            
            System.out.println("List of Circles with radius more than 30:");
            System.out.println(circleArrayList);
            System.out.println("Last Circle with radius less than 40:");
            System.out.println(lastCircleLessThanForty);
            
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
