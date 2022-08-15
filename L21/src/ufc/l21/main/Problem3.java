package ufc.l21.main

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class Problem3 {


    public static void main(String[] args) throws FigureValidatorException, IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String addForCircle = "src\\Circles_in.dat";
        System.out.println(readCircles(addForCircle));

        String addForRect = "src\\Rectangles_in.dat";
        readRectangles(addForRect);

        String addForTri = "src\\Triangles_in.dat";
        readTriangle(addForTri);
    }

    public static Tuple<TreeSet<CircleWithoutConstructor>, Result> readCircles(String address) {

        TreeSet<CircleWithoutConstructor> treeCircle = null;
        Tuple<TreeSet<CircleWithoutConstructor>, Result> t = new Tuple<>();

        try(InputStreamReader isr = new InputStreamReader(new FileInputStream(address), "UTF-8");
            BufferedReader br = new BufferedReader(isr)) {
            Comparator<CircleWithoutConstructor> cmp = new Comparator<CircleWithoutConstructor>() {
                @Override
                public int compare(CircleWithoutConstructor o1, CircleWithoutConstructor o2) {
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
                Field f = CircleWithoutConstructor.class.getDeclaredField("radius");
                f.setAccessible(true);
                CircleWithoutConstructor c = new CircleWithoutConstructor();
                f.set(c, radius);
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
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }

        t.setTreeSet(treeCircle);
        t.setResult(Result.OK);
        return t;
    }

    public static void readRectangles(String address) throws IOException, FigureValidatorException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(address), "UTF-8");
        BufferedReader br = new BufferedReader(isr);


        class RectangleValidator extends FigureValidator {

            @Override
            public void validate(Figure f) throws FigureValidatorException {
                RectangleWithoutConstructor r = null;
                if (f instanceof RectangleWithoutConstructor) {
                    r = (RectangleWithoutConstructor) f;
                }
                if (r.getWidth() <= 0 || r.getHeight() <= 0) {
                    throw new FigureValidatorException("Validation Failed!");
                }
            }
        }

        RectangleValidator rv = new RectangleValidator();
        String line;
        ArrayList<RectangleWithoutConstructor> arrRects = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            String[] nums = line.split("#");
            if (!(isDouble(nums[0]) && isDouble(nums[1]))) {
                continue;
            }
            double height = Double.parseDouble(nums[0]);
            double width = Double.parseDouble(nums[1]);

            RectangleWithoutConstructor r = new RectangleWithoutConstructor();
            Field h = RectangleWithoutConstructor.class.getDeclaredField("height");
            Field w = RectangleWithoutConstructor.class.getDeclaredField("width");

            h.setAccessible(true);
            w.setAccessible(true);

            h.set(r, height);
            w.set(r, width);

            rv.validate(r);
            arrRects.add(r);
        }
        br.close();
        System.out.println(arrRects);
    }

    public static void readTriangle(String fileAddress) throws IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(fileAddress), "UTF-8");
        BufferedReader br = new BufferedReader(isr);

        String line;
        ArrayList<TriangleWithoutConstructor> triangleArray = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            String[] nums = line.split("-");
            if (!(isDouble(nums[0]) && isDouble(nums[1]) && isDouble(nums[2]))) {
                continue;
            }

            Field a =  TriangleWithoutConstructor.class.getDeclaredField("sideA");
            Field b =  TriangleWithoutConstructor.class.getDeclaredField("sideB");
            Field c =  TriangleWithoutConstructor.class.getDeclaredField("sideC");

            a.setAccessible(true);
            b.setAccessible(true);
            c.setAccessible(true);

            TriangleWithoutConstructor tw = new TriangleWithoutConstructor();
            a.set(tw, Double.parseDouble(nums[0]));
            b.set(tw, Double.parseDouble(nums[1]));
            c.set(tw, Double.parseDouble(nums[2]));
            triangleArray.add(tw);
        }
        br.close();
        TriangleWithoutConstructor twc = new TriangleWithoutConstructor();
        twc.setSize(triangleArray.size());
        twc.setTriangleArray(triangleArray);
        twc.printTriangles();
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
