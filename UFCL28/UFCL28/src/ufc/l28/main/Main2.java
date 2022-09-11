package ufc.l28.main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Main2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person1 person = new Person1("Giorgi", "Kharebava",  new Date(1997, Calendar.JULY, 31),
                new Address1("Georgia", "Tbilisi", "Home str."));
        Person1 p = copyObject(person);
        System.out.println(p);
        System.out.println();

        University1 u1 = new University1("UFC1", new Address1("Georgia", "Tbilisi", "UFC Str."));
        University1 u1Copy = copyObject(u1);
        System.out.println(u1Copy);
    }

    public static <T> byte[] serialize(T object) throws IOException {
        ByteArrayOutputStream outB = new ByteArrayOutputStream();
        ObjectOutputStream outObj = new ObjectOutputStream(outB);
        outObj.writeObject(object);
        outObj.close();

        return outB.toByteArray();
    }

    @SuppressWarnings("unchecked")
    public static <T> T copyObject(T object) throws IOException, ClassNotFoundException {
        ByteArrayInputStream inpB = new ByteArrayInputStream(serialize(object));
        ObjectInputStream inpObj = new ObjectInputStream(inpB);

        return (T) inpObj.readObject();
    }
}



class Person1 implements Serializable {
    String firstName;
    String lastName;
    java.util.Date birthdate;

    public Address1 getAddress() {
        return address;
    }

    public void setAddress(Address1 address) {
        this.address = address;
    }

    transient Address1 address;


    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", address=" + address +
                '}';
    }
    public Person1(String firstName, String lastName, Date birthdate, Address1 address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.address = address;
    }



    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(address);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        Address1 ad = (Address1) ois.readObject();
        this.setAddress(ad);
    }
}

class University1 implements Serializable {
    String name;

    public Address1 getAddress() {
        return address;
    }

    public void setAddress(Address1 address) {
        this.address = address;
    }

    transient Address1 address;

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    public University1(String name, Address1 address) {
        this.name = name;
        this.address = address;
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(address);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        Address1 ad = (Address1) ois.readObject();
        this.setAddress(ad);
    }
}

class Address1 implements Serializable {
    String country;
    String city;
    String street;

    public Address1(String country, String city, String street) {
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


class Student1 extends Person1 {
    int course;
    University1 university;

    public Student1(String firstName, String lastName, Date birthdate, Address1 address, int course, University1 university) {
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


