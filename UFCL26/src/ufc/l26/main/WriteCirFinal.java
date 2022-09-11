package ufc.l26.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class WriteCirFinal implements Runnable {

    @Override
    public void run() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("src\\circles_out.dat");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter bw = new BufferedWriter(fw);

        int counter = 0;

        for (String num : ReadFromCircle.nums) {
            counter++;
            try {
                bw.write(num);
                if (counter != ReadFromCircle.nums.length) {
                    bw.write("#");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
