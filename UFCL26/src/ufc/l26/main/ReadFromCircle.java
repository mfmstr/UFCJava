package ufc.l26.main;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class ReadFromCircle implements Callable<ArrayList<Circle>> {
    public static String[] nums;

    @Override
    public ArrayList<Circle> call() {
        InputStreamReader reader;
        try {
        	reader = new InputStreamReader(new FileInputStream("src\\circles_in.dat"), StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader br = new BufferedReader(reader);

        String line;
        ArrayList<Circle> arrCircles = new ArrayList<>();

        try {
            if ((line = br.readLine()) == null) {
                throw new RuntimeException();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        nums = line.split("-");
        for (int i = 0; i < nums.length; i++) {
            Circle c = new Circle(Double.parseDouble(nums[i]));
            arrCircles.add(c);
        }

        try {
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return arrCircles;
    }
}
