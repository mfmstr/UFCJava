package ufc.l26.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTrFinal implements Runnable {
    @Override
    public void run() {
        FileWriter fw;
        try {
            fw = new FileWriter("src\\triangles_out.dat");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter bw = new BufferedWriter(fw);

        int counter = 0;

        for (Triangle tri : ReadFromTriangle.triangleArray) {
            counter++;
            try {
                bw.write(tri.getSideA() + "#" + tri.getSideB() + "#" + tri.getSideC());
                if (counter != ReadFromTriangle.triangleArray.size()) {
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
