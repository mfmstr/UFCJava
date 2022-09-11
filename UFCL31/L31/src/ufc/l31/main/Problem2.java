package ufc.l31.main;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Problem2 {

    public static void main(String[] args) throws JAXBException {
        List<Rectangle> rectanglesList = new ArrayList<>();
        
        for (int i = 0; i < 1000; i++) {
            Random rndm = new Random();
            double a = round(rndm.nextDouble() * 10, 2);
            double b = round(rndm.nextDouble() * 20, 2);

            Rectangle r;
            r = new Rectangle();
            r.setA(a);
            r.setB(b);
            rectanglesList.add(r);
        }
        Rectangles rectangles = new Rectangles();
        rectangles.setRectangleList(rectanglesList);

        JAXBContext jaxbContext = JAXBContext.newInstance(Rectangles.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(rectangles, new File("rectangles_output.xml "));
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
class Rectangles {
    List<Rectangle> rectangleList;

    public List<Rectangle> getRectangleList() {
        return rectangleList;
    }

    @XmlElement(name = "rectangle")
    public void setRectangleList(List<Rectangle> rectangleList) {
        this.rectangleList = rectangleList;
    }

    @Override
    public String toString() {
        return "Rectangle List" + rectangleList;
    }
}
