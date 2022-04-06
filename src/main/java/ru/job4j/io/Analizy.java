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
                if (!isOffline &&  (arr[0].equals("500") || arr[0].equals("400"))) {
                    isOffline = true;
                    log.write(arr[1]);
                    log.write(";");
                }
                if (isOffline &&  arr[0].equals("200")) {
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
        analizy.unavailable("source.csv", "target.csv");
    }
}
