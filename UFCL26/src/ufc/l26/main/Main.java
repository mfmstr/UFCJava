package ufc.l26.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
	
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		
		start();
		maxPer.start();
		Problem3.start(args[0]);
		MaxMinRes.start();
		TrWithSES.start();
		StopIfMore.start();
		LastProblem.start();
		
	}
	
	
	public static void start() throws InterruptedException, ExecutionException {
    	final ExecutorService es = Executors.newFixedThreadPool(3);
    	WriteInCircle wic = new WriteInCircle();
        es.execute(wic);
    	WriteInRectangle wir = new WriteInRectangle();
        es.execute(wir);
        WriteInTriangle wit = new WriteInTriangle();
        es.execute(wit);

        es.shutdown();
        es.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    }	
}

class maxPer{
	static ExecutorService es = Executors.newFixedThreadPool(3);

    public static void start() throws ExecutionException, InterruptedException {

        ReadFromCircle rfc = new ReadFromCircle();
        Future<ArrayList<Circle>> futCir = es.submit(rfc);
        ArrayList<Circle> cirArray = futCir.get();
        Collections.sort(cirArray);
        System.out.println("Circle with maximum perimeter:: " + cirArray.get(cirArray.size() - 1));
        ReadFromRec rfr = new ReadFromRec();
        Future<ArrayList<Rectangle>> futRec = es.submit(rfr);
        ArrayList<Rectangle> rectArray = futRec.get();
        Collections.sort(rectArray);
        System.out.println("Rectangle with maximum perimeter: " + rectArray.get(rectArray.size() - 1));
        ReadFromTriangle rawt = new ReadFromTriangle();
        Future<ArrayList<Triangle>> futTri = es.submit(rawt);
        ArrayList<Triangle> triArray = futTri.get();
        Collections.sort(triArray);
        System.out.println("Triangle with maximum perimeter: " + triArray.get(triArray.size() - 1));
        es.shutdown();

    }
}

class Problem3 {
    static ExecutorService es = Executors.newFixedThreadPool(3);
    public static void start(final String pauseTime) {
        String inpCir = "src\\circles_in.dat";
        String outCir = "src\\circles_out.dat";
        String inpRec = "src\\rectangles_in.dat";
        String outRec = "src\\rectangles_out.dat";
        String inpTri = "src\\triangles_in.dat";
        String outTri = "src\\triangles_out.dat";
        es.execute(() -> {
            try {
                replace(inpCir, outCir);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        es.execute(() -> {
            try {
                replace(inpRec, outRec);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        es.execute(() -> {
            try {
                replace(inpTri, outTri);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        long wt = Long.parseLong(pauseTime);
        long startTime = System.currentTimeMillis();

        while (true) {
            long endTime = System.currentTimeMillis();
            long overPatienceTime = (endTime - startTime) * 1000;
            if (overPatienceTime > wt)
                break;
        }
        es.shutdownNow();
    }

    static void replace(String inp, String out) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(inp));
        BufferedWriter bw = new BufferedWriter(new FileWriter(out));
        String line = "";
        while ((line = br.readLine()) != null) {
            bw.write(line.replaceAll("-", "#").concat("\n"));
        }
    }
}

class TrWithSES {

    static ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();

    public static void start() throws ExecutionException, InterruptedException {
        Future<Triangle> ft = ses.schedule(TrWithSES::max, 5, TimeUnit.SECONDS);
        Triangle t = ft.get();
        System.out.println(t);
        ses.shutdown();
    }

    static Triangle max() {
        Triangle res = new Triangle(0, 0, 0);
        res = getArrayOfTriangles().get(getArrayOfTriangles().size() - 1);
        return res;
    }

    static ArrayList<Triangle> getArrayOfTriangles() {
        InputStreamReader reader;
        try {
        	reader = new InputStreamReader(new FileInputStream("src\\triangles_in.dat"), StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader br = new BufferedReader(reader);

        String line;
        ArrayList<Triangle> triArray = new ArrayList<>();
        while (true) {
            try {
                if ((line = br.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String[] nums = line.split("-");
            Triangle t = new Triangle(Double.parseDouble(nums[0]), Double.parseDouble(nums[1]), Double.parseDouble(nums[2]));
            triArray.add(t);
        }
        try {
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Collections.sort(triArray);
        return triArray;
    }
}

class StopIfMore {
    static ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();

    static AtomicInteger c = new AtomicInteger(0);

    public static void start() throws ExecutionException {
        ScheduledFuture<?> sf = ses.scheduleAtFixedRate(StopIfMore::printCircles, 0, 2, TimeUnit.SECONDS);
        try {
            sf.get();
        } catch (ExecutionException | InterruptedException e) {
            System.out.println("End");
        }
        ses.shutdown();
    }

    static void printCircles() {
        for (int i = 0; i < 150; i++) {
            if (c.get() >= 500) {
                throw new RuntimeException();
            }
            System.out.println(c.get() + 1);
            c.incrementAndGet();
            System.out.println(arrayOfCircles().get(i));
        }
    }

    static ArrayList<Circle> arrayOfCircles() {
        InputStreamReader reader;
        try {
        	reader = new InputStreamReader(new FileInputStream("src\\circles_in.dat"), StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader br = new BufferedReader(reader);

        String line;
        ArrayList<Circle> cirArray = new ArrayList<>();

        try {
            if ((line = br.readLine()) == null) {
                throw new RuntimeException();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] nums = line.split("-");
        for (int i = 0; i < nums.length; i++) {
            Circle c = new Circle(Double.parseDouble(nums[i]));
            cirArray.add(c);
        }

        try {
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return cirArray;
    }
}

class LastProblem {

    static ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
    static AtomicInteger c = new AtomicInteger(0);
    public static void start() throws ExecutionException {
        ScheduledFuture<?> sf = ses.scheduleWithFixedDelay(LastProblem::printCircles, 0, 3, TimeUnit.SECONDS);
        try {
            sf.get();
        } catch (ExecutionException | InterruptedException e) {
            System.out.println("End");
        }
        ses.shutdown();
    }

    static void printCircles() {
        for (int i = 0; i < 250; i++) {
            if (c.get() >= 700) {
                throw new RuntimeException();
            }
            System.out.println(c.get() + 1);
            c.incrementAndGet();
            System.out.println(cirArray().get(i));
        }
    }

    static ArrayList<Circle> cirArray() {
        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader(new FileInputStream("src\\circles_in.dat"), StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader br = new BufferedReader(isr);

        String line;
        ArrayList<Circle> arrCircles = new ArrayList<>();

        try {
            if ((line = br.readLine()) == null) {
                throw new RuntimeException();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] nums = line.split("-");
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
    
	
    
