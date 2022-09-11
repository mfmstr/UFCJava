package ufc.l28.main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Student s = new Student("Giorgi", "Kharebava", new Date(1997, Calendar.JULY, 31),
				4,
		new Address("Georgia", "Tbilisi", "Home str."), new University("UFC", new Address("Georgia", "Tbilisi", "UFC Str.")));
        System.out.println(s);
        Student cStudent = copyObject(s);
        System.out.println(cStudent);
        System.out.println();

        Person p = new Person("Giorgi", "Kharebava",  new Date(1997, Calendar.JULY, 31),
                new Address("Georgia", "Tbilisi", "Home str."));
        System.out.println(p);
        Person cPerson = copyObject(p);
        System.out.println(cPerson);
        
        String address = "C:\\\\Users\\\\User\\\\Desktop\\\\UFCL28\\\\UFCL28\\\\src\\\\ufc\\\\l28\\\\main\\base64res.txt";
        Person person = new Person("Giorgi", "Kharebava",  new Date(1997, Calendar.JULY, 31),
                new Address("Georgia", "Tbilisi", "Home str."));
        Base.base64Serialize(person, address);
        Person deserializedPerson = Base.base64Deserialize(address);
        System.out.println(deserializedPerson);
	}
	
	public static <T> byte[] serialize(T object) throws IOException {
        ByteArrayOutputStream inpB = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(inpB);
        oos.writeObject(object);
        oos.close();
        return inpB.toByteArray();
    }

    @SuppressWarnings("unchecked")
    public static <T> T copyObject(T object) throws IOException, ClassNotFoundException {
        ByteArrayInputStream inpB = new ByteArrayInputStream(serialize(object));
        ObjectInputStream inpObj = new ObjectInputStream(inpB);
        return (T) inpObj.readObject();
    }
	
}

class Base {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String ad = "C:\\Users\\User\\Desktop\\UFCL28\\UFCL28\\src\\ufc\\l28\\main";
        Person p = new Person("Giorgi", "Kharebava",  new Date(1997, Calendar.JULY, 31), new Address("Georgia", "Tbilisi", "Home str."));
        base64Serialize(p, ad);
        Person deserializedPerson = base64Deserialize(ad);
        System.out.println(deserializedPerson);
    }

    public static <T> void base64Serialize(T object, String address) throws IOException {
        ByteArrayOutputStream inpB = new ByteArrayOutputStream();
        ObjectOutputStream inpO = new ObjectOutputStream(inpB);
        inpO.writeObject(object);
        inpO.close();

        ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(address));
        String serializedString = Base64.getEncoder().encodeToString(inpB.toByteArray());
        objOut.writeObject(serializedString);
    }

    @SuppressWarnings("unchecked")
    public static <T> T base64Deserialize(String address) throws IOException, ClassNotFoundException {
        ObjectInputStream objOut = new ObjectInputStream(new FileInputStream(address));
        String res = (String) objOut.readObject();
        byte[] data = Base64.getDecoder().decode(res);
        ObjectInputStream inpObj = new ObjectInputStream(new ByteArrayInputStream(data));
        T object = (T) inpObj.readObject();
        inpObj.close();

        return object;
    }

}

