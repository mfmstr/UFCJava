package ufc.l21.main;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class Problem1 {

    public static void main(String[] args) throws IOException, FigureValidatorException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String addForCircle = "src\\Circles_in.dat";
        System.out.println(readCircles(addForCircle));

        String addForRect = "src\\Rectangles_in.dat";
        readRectangles(addForRect);

        String addForTri = "src\\Triangles_in.dat";
        readTriangle(addForTri);
    }

    public static Tuple<TreeSet<Circle>, Result> readCircles(String address) {

        TreeSet<Circle> treeCircle = null;
        Tuple<TreeSet<Circle>, Result> t = new Tuple<>();

        try(InputStreamReader isr = new InputStreamReader(new FileInputStream(address), "UTF-8");
            BufferedReader br = new BufferedReader(isr)) {
            Comparator<Circle> cmp = new Comparator<Circle>() {
                @Override
                public int compare(Circle o1, Circle o2) {
                    return Double.compare(o1.getLength(), o2.getLength());
                }
            };

            treeCircle = new TreeSet<>(cmp);
            String line;
            double radius = 0;

            while ((line = br.readLine()) != null) {
                if (!(isDouble(line))) {
                    continue;
                }

                radius = Double.parseDouble(line);

                Constructor<Circle> circleConstructor = Circle.class.getDeclaredConstructor(double.class);
                circleConstructor.setAccessible(true);
                Circle c = circleConstructor.newInstance(radius);
                treeCircle.add(c);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            t.setTreeSet(treeCircle);
            t.setResult(Result.FILE_NOT_FOUND);

            return t;
        } catch (IOException ioException) {
            t.setTreeSet(treeCircle);
            t.setResult(Result.IO_ERROR);

            return t;
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        t.setTreeSet(treeCircle);
        t.setResult(Result.OK);
        return t;
    }

    public static void readRectangles(String address) throws IOException, FigureValidatorException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(address), "UTF-8");
        BufferedReader br = new BufferedReader(isr);

        class RectangleValidator extends FigureValidator {

            @Override
            public void validate(Figure f) throws FigureValidatorException {
                Rectangle r = null;
                if (f instanceof Rectangle) {
                    r = (Rectangle) f;
                }
                if (r.getWidth() <= 0 || r.getHeight() <= 0) {
                    throw new FigureValidatorException("Validation Failed!");
                }
            }
        }

        RectangleValidator rv = new RectangleValidator();
        String line;
        ArrayList<Rectangle> arrRects = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            String[] nums = line.split("#");
            if (!(isDouble(nums[0]) && isDouble(nums[1]))) {
                continue;
            }

            Constructor<Rectangle> rectangleConstructor = Rectangle.class.getDeclaredConstructor(double.class, double.class);
            rectangleConstructor.setAccessible(true);
            Rectangle r = rectangleConstructor.newInstance(Double.parseDouble(nums[0]), Double.parseDouble(nums[1]));
            rv.validate(r);
            arrRects.add(r);
        }
        br.close();
        System.out.println(arrRects);
    }

    public static void readTriangle(String fileAddress) throws IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(fileAddress), "UTF-8");
        BufferedReader br = new BufferedReader(isr);

        String line;
        ArrayList<Triangle> triangleArray = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            String[] nums = line.split("-");
            if (!(isDouble(nums[0]) && isDouble(nums[1]) && isDouble(nums[2]))) {
                continue;
            }
            Constructor<Triangle> tc = Triangle.class.getDeclaredConstructor(double.class, double.class, double.class);
            tc.setAccessible(true);
            Triangle t = tc.newInstance(Double.parseDouble(nums[0]), Double.parseDouble(nums[1]), Double.parseDouble(nums[2]));
            triangleArray.add(t);
        }
        br.close();
        Triangle.size = triangleArray.size();
        Triangle.triangleArray = triangleArray;
        Triangle.printTriangles();
    }


    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}