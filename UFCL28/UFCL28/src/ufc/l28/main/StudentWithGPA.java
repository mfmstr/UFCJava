package ufc.l28.main;

import java.util.Date;

public class StudentWithGPA extends Person {
    private static final long serialVersionUID = 2L; 

    public int course;
    public University university;
    public Double gpa;


    public StudentWithGPA(String firstName, String lastName, Date birthdate, Address address, int course, University university, Double gpa) {
        super(firstName, lastName, birthdate, address);
        this.course = course;
        this.university = university;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student3{" +
                "course=" + course +
                ", university=" + university +
                ", gpa=" + gpa +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", address=" + address +
                '}';
    }
}

