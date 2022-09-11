package ufc.l28.main;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
    public String firstName;
    public String lastName;
    public java.util.Date birthdate;
    public Address address;
    
    public Person(String firstName, String lastName, Date birthdate, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.address = address;
    }

	@Override
	public String toString() {
		return "Name: " + firstName + " Lastname: " + lastName + "Birthday: " + birthdate + 
				" Adress:" + address;
	}

	
    
    
}
