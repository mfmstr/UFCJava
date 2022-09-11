package ufc.l31.main;

import javax.xml.bind.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Problem3 {

    public static void main(String[] args) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Triangles.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();
        Triangles unmarshalTriangles = (Triangles) unmarshaller.unmarshal(new File("triangles_input.xml"));
        unmarshalTriangles.getTriangleList().remove(0);
        Triangle triangle = unmarshalTriangles.getTriangleList().get(1);
        triangle.setA(3);
        triangle.setB(4);
        triangle.setC(5);

        Triangle newTriangle = new Triangle();
        newTriangle.setA(6);
        newTriangle.setB(8);
        newTriangle.setC(10);
        unmarshalTriangles.getTriangleList().add(newTriangle);

        JAXBContext jaxbContext = JAXBContext.newInstance(Triangles.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(unmarshalTriangles, new File("triangles_output.xml "));

        context.generateSchema(new SchemaOutputResolver() {

            @Override
            public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
                StreamResult result = new StreamResult(new File("triangles.xsd"));
                result.setSystemId("triangles.xsd");
                return result;
            }

        });

        context = JAXBContext.newInstance(Triangle.class);

        context.generateSchema(new SchemaOutputResolver() {

            @Override
            public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
                StreamResult result = new StreamResult(new File("triangle.xsd"));
                result.setSystemId("triangle.xsd");
                return result;
            }

        });
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}

@XmlRootElement
class Triangles {
    List<Triangle> triangleList;

    public List<Triangle> getTriangleList() {
        return triangleList;
    }

    @XmlElement(name = "triangle")
    public void setTriangleList(List<Triangle> triangleList) {
        this.triangleList = triangleList;
    }

    @Override
    public String toString() {
        return "Triangles{" +
                "triangleList=" + triangleList +
                '}';
    }
}