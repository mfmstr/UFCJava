package ufc.l26.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class WriteInRectangle implements Runnable {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    @Override
    public void run() {
        FileWriter fw = null;
        try {
        	fw = new FileWriter("src\\rectangles_in.dat");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter br = new BufferedWriter(fw);

        for (int i = 0; i < 30_000; i++) {
            double height = Math.random() * 100;
            double width = Math.random() * 100;
            try {
                br.write(df.format(height) + "-" + df.format(width));

                if (i != 29999) {
                    br.write("\n");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
