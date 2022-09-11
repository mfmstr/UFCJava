package ufc.l26.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;

public class WriteRecFinal implements Runnable {
    @Override
    public void run() {
        FileWriter fw;
        try {
            fw = new FileWriter("src\\rectangles_out.dat");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter bw = new BufferedWriter(fw);

        int counter = 0;

        for (Rectangle rect : ReadFromRec.recArray) {
            counter++;
            try {
                bw.write(rect.getHeight() + "#" + rect.getWidth());
                if (counter != ReadFromRec.recArray.size()) {
                    bw.write("\n");
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
