package ufc.l26.main;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class ReadFromRec implements Callable<ArrayList<Rectangle>> {
    public static ArrayList<Rectangle> recArray;

    @Override
    public ArrayList<Rectangle> call() throws Exception {
        InputStreamReader reader;
        try {
            reader = new InputStreamReader(new FileInputStream("src\\rectangles_in.dat"), StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader br = new BufferedReader(reader);

        String line;
        recArray = new ArrayList<>();
        while (true) {
            try {
                if ((line = br.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String[] nums = line.split("-");
            Rectangle r = new Rectangle(Double.parseDouble(nums[0]), Double.parseDouble(nums[1]));
            recArray.add(r);
        }
        try {
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return recArray;
    }
}
