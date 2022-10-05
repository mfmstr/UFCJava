package ge.ufc.webapps.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "person", propOrder = { "name", "lastName", "age" })

public class Person {
	
	@XmlAttribute
	protected String id;
    protected String name;
    protected String lastName;
    protected int age;

    public Person(String id, String name, String lastName, int age) {
    	this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getId() {
    	return id;
    }
    
    public int getAge() {
    	return age;
    }
    
    public void setAge(int age) {
    	this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Person p = (Person) o;

        if (id != null ? !id.equals(p.id) : p.id != null)
            return false;
        return name != null ? name.equals(p.name) : p.name == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{ID: " + id + ", Name: " + name + ", Last Name: " + lastName + ", Age: " + age +"}";
    }

}
