package ufc.l22.main;

import java.io.*;
import java.util.ArrayList;

public class IOTask {

    public static void main(String[] args) throws IOException {

        InputStreamReader  fis = new InputStreamReader(new FileInputStream(args[0]));
        BufferedReader br = new BufferedReader(fis);
        ArrayList<String> arr = new ArrayList<>();
        int count = 0;

        try(br) {
            String line;

            while ((line = br.readLine()) != null) {
                String outStr = line.toUpperCase().replaceAll("\\s+", "_");
                arr.add(outStr);
            }
        }

        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(args[1]));
        BufferedWriter bw = new BufferedWriter(osw);

        try(bw) {
            for (String str : arr) {
                bw.write(str);
                count++;

                if (!(count == arr.size())) {
                    bw.write(System.getProperty("line.separator"));
                }
            }
        }
    }
}
