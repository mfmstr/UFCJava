package ufc.l26.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class WriteInCircle implements Runnable {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    @Override
    public void run() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("src\\circles_in.dat");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter br = new BufferedWriter(fw);

        for (int i = 0; i < 30_000; i++) {
            double radius = Math.random() * 100;
            try {
                br.write(df.format(radius));

                if (i != 29999) {
                    br.write("-");
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
