package ufc.l28.main;

import java.io.Serializable;

public class University implements Serializable {
    public String name;
    public Address address;

    public University(String name, Address address) {
        this.name = name;
        this.address = address;
    }

	@Override
	public String toString() {
		return "Name: " + name + " Address: " + address;
	}

	
    
    
}
