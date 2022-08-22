package ufc.l30.main;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


import javanet.staxutils.IndentingXMLStreamWriter;

public class Problem1 {
	public static void main(String[] args) {
		CreateXMLWithStax();
		System.out.println(ReadXMLWithJDOM());
	}
	
	public static void CreateXMLWithStax() {

		        try {

		            XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();
		            XMLStreamWriter xMLStreamWriter = xMLOutputFactory.createXMLStreamWriter(new FileOutputStream("src\\triangles_out.xml"));
		            IndentingXMLStreamWriter indenting = new IndentingXMLStreamWriter(xMLStreamWriter);
		            
		            
		            indenting.writeStartDocument();
		            indenting.writeStartElement("triangles");

		            
		            for(int i = 0; i < 100; i++) {
		            	
		            	double a = Math.round(Math.random() * 100 + 1);
		            	double b = Math.round(Math.random() * 100 + 1);
		            	double c = Math.round(Math.random() * 100 + 1);
		            	
		            	indenting.writeStartElement("triangle");
		            	indenting.writeStartElement("a");
		            	indenting.writeCharacters(String.valueOf(a));
		            	indenting.writeEndElement();
			            
		            	indenting.writeStartElement("b");
		            	indenting.writeCharacters(String.valueOf(b));
		            	indenting.writeEndElement();
			            
		            	indenting.writeStartElement("c");
			            indenting.writeCharacters(String.valueOf(c));
			            indenting.writeEndElement();
			            
			         
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
	
	
	@SuppressWarnings("finally")
	public static ArrayList<Triangle> ReadXMLWithJDOM() {
		ArrayList<Triangle> resTriangles = new ArrayList<>();
		try {
            File inputFile = new File("src\\triangles_out.xml");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputFile);
            Element classElement = document.getRootElement();

            List<Element> triangleList = classElement.getChildren();

            for (int i = 0; i < triangleList.size(); i++) {
                Element tr = triangleList.get(i);
                double a = Double.valueOf(tr.getChild("a").getText());
                double b = Double.valueOf(tr.getChild("b").getText());
                double c = Double.valueOf(tr.getChild("c").getText());
                
                Triangle res = new Triangle(a, b, c);
                
                if(res.getLength() > 20) {
                	resTriangles.add(res);
                }
            }
            return resTriangles;
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }finally {
        	return resTriangles;
        }
    }
}