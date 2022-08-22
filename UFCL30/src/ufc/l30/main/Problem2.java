package ufc.l30.main;

import java.io.IOException;
import java.util.ArrayList;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;



public class Problem2 {
	public static void main(String[] args) {
		CreateXMLWithJDOM();
		System.out.println(ReadXMLWithStax());
	}
	
	public static void CreateXMLWithJDOM() {
		try {
            Element recElement = new Element("rectangles");
            Document doc = new Document(recElement);

            for(int i = 0; i < 100; i++) {
            
            double width = Math.round(Math.random() * 100 + 1);
            double height = Math.round(Math.random() * 100 + 1);	
            	
            Element innerRecElement = new Element("rectangle");

            Element widthElement = new Element("width");
            widthElement.setText(String.valueOf(width));
            
            Element heightElement = new Element("height");
            heightElement.setText(String.valueOf(height));
            
            innerRecElement.addContent(widthElement);
            innerRecElement.addContent(heightElement);
            
            doc.getRootElement().addContent(innerRecElement);
            }

            XMLOutputter xmlOutput = new XMLOutputter();

            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileOutputStream("src\\rectangles_out.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	@SuppressWarnings("finally")
	public static ArrayList<Rectangle> ReadXMLWithStax() {
        
		boolean bWidth = false;
        boolean bHeight = false;
        Rectangle res = new Rectangle();
        ArrayList<Rectangle> resArrayList = new ArrayList<>();
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader = factory.createXMLEventReader(new FileReader("src\\rectangles_out.xml"));
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                
                switch (event.getEventType()) {

                case XMLStreamConstants.START_ELEMENT:
                    StartElement startElement = event.asStartElement();
                    String qName = startElement.getName().getLocalPart();

                    if (qName.equalsIgnoreCase("width")) {
                        bWidth = true;
                    } else if (qName.equalsIgnoreCase("height")) {
                        bHeight = true;
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    Characters characters = event.asCharacters();
                    if (bWidth) {
                        res.setA(Double.valueOf(characters.getData()));
                        bWidth = false;
                    }
                    if (bHeight) {
                    	res.setB(Double.valueOf(characters.getData()));
                        bHeight = false;
                    }
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    EndElement endElement = event.asEndElement();

                    if (endElement.getName().getLocalPart().equalsIgnoreCase("rectangle")) {
                    	if(res.getLength() > 20) {
                    	resArrayList.add(res);
                    	}
                    	res = new Rectangle();
                    }
                    break;
                }
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } finally {
        	return resArrayList;
        }

	}
	
}
