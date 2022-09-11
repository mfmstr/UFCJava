package ufc.l28.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.Date;

public class StudentWithGPAClass {

    public static void main(String[] args) throws FileNotFoundException {
        StudentWithGPA student = new StudentWithGPA("Giorgi", "Kharebava", new Date(1997, Calendar.JULY, 31),
                new Address("Georgia", "Tbilisi", "Home"), 5,
                new University("UFC", new Address("Georgia", "Tbilisi", "UFC Str.")), 4.00);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("res.txt"))) {
            out.writeObject(student);
            System.out.println("Student successfully added");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("res.txt"))) {
            StudentWithGPA deserializedStudent = (StudentWithGPA) in.readObject();
            System.out.println(deserializedStudent);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Anonther Type");
        }
    }
}