package ufc.l26.main;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class ReadFromTriangle implements Callable<ArrayList<Triangle>> {
    public static ArrayList<Triangle> triangleArray;

    @Override
    public ArrayList<Triangle> call() {
        InputStreamReader reader = null;
        try {
        	reader = new InputStreamReader(new FileInputStream("src\\triangles_in.dat"), StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader br = new BufferedReader(reader);

        String line;
        triangleArray = new ArrayList<>();
        while (true) {
            try {
                if ((line = br.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String[] nums = line.split("-");
            Triangle t = new Triangle(Double.parseDouble(nums[0]), Double.parseDouble(nums[1]), Double.parseDouble(nums[2]));
            triangleArray.add(t);
        }
        try {
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return triangleArray;
    }
}
