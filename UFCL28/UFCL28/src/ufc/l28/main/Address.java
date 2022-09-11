package ufc.l28.main;

import java.io.Serializable;

public class Address implements Serializable {
    public String country;
    public String city;
    public String street;

    public Address(String country, String city, String street) {
        this.country = country;
        this.city = city;
        this.street = street;
    }

	@Override
	public String toString() {
		return "Country: " + country + " City: " + city + " Street:" + street;
	}

}
