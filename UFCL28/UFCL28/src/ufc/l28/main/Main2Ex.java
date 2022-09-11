package ufc.l28.main;

import java.io.*;
import java.util.Calendar;
import java.util.Date;

public class Main2Ex {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person2 person = new Person2("Giorgi", "Kharebava",  new Date(1997, Calendar.JULY, 31),
                new Address2("Georgia", "Tbilisi", "Home Str."));
        Person2 per = copyObject(person);
        System.out.println(per);
        System.out.println();

        University2 u2 = new University2("UFC", new Address2("Georgia", "Tbilisi", "UFC Str."));
        University2 cu2 = copyObject(u2);
        System.out.println(cu2);
    }

    public static <T> byte[] serialize(T object) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(object);
        oos.close();

        return baos.toByteArray();
    }

    @SuppressWarnings("unchecked")
    public static <T> T copyObject(T object) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bais = new ByteArrayInputStream(serialize(object));
        ObjectInputStream ois = new ObjectInputStream(bais);

        return (T) ois.readObject();
    }
}



class Person2 implements Externalizable {
    String firstName;
    String lastName;
    java.util.Date birthdate;

    public Person2() {
    }

    public Address2 getAddress() {
        return address;
    }

    public void setAddress(Address2 address) {
        this.address = address;
    }

    transient Address2 address;


    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", address=" + address +
                '}';
    }
    public Person2(String firstName, String lastName, Date birthdate, Address2 address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.address = address;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(firstName);
        out.writeUTF(lastName);
        out.writeObject(birthdate);
        out.writeObject(address);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.firstName = in.readUTF();
        this.lastName = in.readUTF();
        this.birthdate = (Date) in.readObject();
        this.address = (Address2) in.readObject();
    }
}

class University2 implements Externalizable {
    String name;
    transient Address2 address;

    public University2(){}

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    public University2(String name, Address2 address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.writeObject(address);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = in.readUTF();
        this.address = (Address2) in.readObject();
    }
}

class Address2 implements Serializable {
    String country;
    String city;
    String street;

    public Address2(String country, String city, String street) {
        this.country = country;
        this.city = city;
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}


class Student2 extends Person2 {
    int course;
    University2 university;

    public Student2(String firstName, String lastName, Date birthdate, Address2 address, int course, University2 university) {
        super(firstName, lastName, birthdate, address);
        this.course = course;
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student{" +
                "course=" + course +
                ", university=" + university +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", address=" + address +
                '}';
    }
}