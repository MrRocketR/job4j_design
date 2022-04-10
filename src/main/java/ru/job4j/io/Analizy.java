package ru.job4j.io;

import java.io.*;

public class Analizy {
    public void unavailable(String source, String target)  {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter log = new PrintWriter(new FileOutputStream(target))) {
            String line;
            boolean isOffline = false;
            while ((line = in.readLine()) != null) {
                String[] arr = line.split("\\s");
                if (!isOffline &&  ("500".equals(arr[0]) || "400".equals(arr[0]))) {
                    isOffline = true;
                    log.write(arr[1]);
                    log.write(";");
                }
                if (isOffline && "200".equals(arr[0])) {
                    isOffline = false;
                    log.write(arr[1]);
                    log.write(";");
                    log.println();
                }
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Analizy analizy = new Analizy();
    }
}
