package ufc.l26.main;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static  ufc.l26.main.MaxMinRes.rectArray;

public class MaxMinRes {

    static ExecutorService es = Executors.newFixedThreadPool(4);

    public static void start() {
        FindMaxPerimeter findMaxPerimeter = new FindMaxPerimeter();
        es.execute(findMaxPerimeter);

        FindMinPerimeter findMinPerimeter = new FindMinPerimeter();
        es.execute(findMinPerimeter);

        FindMaxArea findMaxArea = new FindMaxArea();
        es.execute(findMaxArea);

        FindMinArea findMinArea = new FindMinArea();
        es.execute(findMinArea);

        es.shutdown();
    }
    public static ArrayList<Rectangle> rectArray() {
        InputStreamReader reader;
        try {
        	reader = new InputStreamReader(new FileInputStream("src\\rectangles_in.dat"), StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader br = new BufferedReader(reader);

        String line;
        ArrayList<Rectangle> arrRects = new ArrayList<>();
        while (true) {
            try {
                if ((line = br.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String[] nums = line.split("-");
            Rectangle r = new Rectangle(Double.parseDouble(nums[0]), Double.parseDouble(nums[1]));
            arrRects.add(r);
        }


        try {
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Collections.sort(arrRects);
        return arrRects;
    }
}


class FindMaxPerimeter extends Thread {
    @Override
    public void run() {
        double maxPerRect = rectArray().get(rectArray().size() - 1).getLength();
        System.out.println("Max Perimeter: " + maxPerRect);
    }
}

class FindMinPerimeter extends Thread {

    @Override
    public void run() {
        double minPerRect = rectArray().get(0).getLength();
        System.out.println("Min Perimeter: " + minPerRect);
    }
}

class FindMaxArea extends Thread {

    @Override
    public void run() {
        double maxAreaRect = rectArray().get(rectArray().size() - 1).getArea();
        System.out.println("Max Area: " + maxAreaRect);
    }
}

class FindMinArea extends Thread {

    @Override
    public void run() {
        double minAreaRect = rectArray().get(0).getArea();
        System.out.println("Min Area: " + minAreaRect);
    }
}