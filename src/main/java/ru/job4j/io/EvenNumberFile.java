package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        String[] lines;
        try (FileInputStream input = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            int number = 0;
            while ((read = input.read()) != -1) {
                text.append((char) read);
                }
            lines = text.toString().split("\\s+");
            for (String line : lines) {
                number = Integer.parseInt(line);
                   if (number % 2 == 0) {
                    System.out.println("Number = " + number + " Is Even!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
