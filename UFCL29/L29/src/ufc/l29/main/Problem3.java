package ufc.l29.main;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Problem3 {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        File inputFile = new File("src//rectangles_output.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        int count = 0;

        NodeList nodes = doc.getElementsByTagName("rectangle");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element rectangle = (Element) nodes.item(i);
            if (count == 0 || count == (nodes.getLength() - 1)) {
                rectangle.getParentNode().removeChild(rectangle);
            }

            count++;
        }

        Random ran = new Random();
        int a = ran.nextInt(1) + 2;
        int b = ran.nextInt(2) + 3;
        int c = ran.nextInt(3) + 5;
        int d = ran.nextInt(4) + 1;


        Rectangle r1 = new Rectangle(a, b);
        Rectangle r2 = new Rectangle(c, d);


        NodeList nodeList = doc.getElementsByTagName("rectangle");

        Text height = doc.createTextNode(String.valueOf(r1.getA()));
        Text width = doc.createTextNode(String.valueOf(r1.getB()));
        Element tr = doc.createElement("rectangle");
        Element height1 = doc.createElement("height");
        Element width1 = doc.createElement("width");
        tr.appendChild(height1);
        tr.appendChild(width1);
        height1.appendChild(height);
        width1.appendChild(width);

        Attr attrType = doc.createAttribute("id");
        attrType.setValue(String.valueOf(0));
        tr.setAttributeNode(attrType);

        nodeList.item(0).getParentNode().insertBefore(tr, nodes.item(0));

        Text height2 = doc.createTextNode(String.valueOf(r2.getA()));
        Text width2 = doc.createTextNode(String.valueOf(r2.getB()));
        Element tr2 = doc.createElement("rectangle");
        Element height3 = doc.createElement("height");
        Element width3 = doc.createElement("width");
        tr2.appendChild(height3);
        tr2.appendChild(width3);
        height3.appendChild(height2);
        width3.appendChild(width2);

        Attr attrType1 = doc.createAttribute("id");
        attrType1.setValue(String.valueOf(nodeList.getLength()));
        tr2.setAttributeNode(attrType1);

        nodeList.item(0).getParentNode().insertBefore(tr2, nodes.item(nodeList.getLength()));

        TransformerFactory tff = TransformerFactory.newInstance();
        Transformer transformer = tff.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("output_deleted.xml"));
        transformer.transform(source, result);

        StreamResult consoleResult = new StreamResult(System.out);
        transformer.transform(source, consoleResult);
    }
}