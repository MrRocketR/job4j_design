package ru.job4j.io;

import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(source));
        PrintWriter log = new PrintWriter(new FileOutputStream(target));
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
        in.close();
        log.close();

    }

    public static void main(String[] args) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Analizy analizy = new Analizy();
        analizy.unavailable("source.csv", "target.csv");
    }
}
