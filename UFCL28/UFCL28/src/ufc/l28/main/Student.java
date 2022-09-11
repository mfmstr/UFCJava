package ufc.l28.main;

import java.util.Date;

public class Student extends Person {
    public int course;
    public University university;

    public Student(String firstName, String lastName, Date birthdate, int course, Address address, University university) {
        super(firstName, lastName, birthdate, address);
        this.course = course;
        this.university = university;
    }
    
    @Override
    public String toString() {
    	return "Course:" + course + " University: " + university;
    }

}
