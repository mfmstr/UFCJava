package ufc.l31.main;


import javax.xml.bind.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Problem1 {

    public static void main(String[] args) throws JAXBException, IOException {
        /* generate XSD files
        JAXBContext context = JAXBContext.newInstance(Circle.class);

        context.generateSchema(new SchemaOutputResolver() {

            @Override
            public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
                StreamResult result = new StreamResult(new File("circle.xsd"));
                result.setSystemId("circle.xsd");
                return result;
            }

        });

        context = JAXBContext.newInstance(Circles.class);

        context.generateSchema(new SchemaOutputResolver() {

            @Override
            public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
                StreamResult result = new StreamResult(new File("circles.xsd"));
                result.setSystemId("circles.xsd");
                return result;
            }

        });
         */

        Circles circles = new Circles();
        List<Circle> circleList = circles.getCircle();


        for (int i = 0; i < 1000; i++) {
            Random ran = new Random();
            double radius = round(ran.nextDouble() * 10, 2);

            Circle circle = new Circle();
            circle.setRadius(radius);
            circleList.add(circle);
        }



        JAXBContext jaxbContext = JAXBContext.newInstance(Circles.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(new JAXBElement<>(new QName("","circles"), Circles.class, circles), new File("circles_output.xml"));

    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}

/* Classes for generate XSD files
@XmlRootElement(name = "circles")
class Circles {

    @XmlElement
    public void setCircle(List<Circle> circle) {
        this.circle = circle;
    }

    private List<Circle> circle;

    public List<Circle> getCircleList() {
        return circle;
    }

    @Override
    public String toString() {
        return "Circles{" +
                "circleList=" + circle +
                '}';
    }

}
class Circle {
    private Double radius;

    public Double getRadius() {
        return radius;
    }

    @XmlAttribute
    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "CircleModel{" +
                "radius='" + radius + '\'' +
                '}';
    }
}
*/