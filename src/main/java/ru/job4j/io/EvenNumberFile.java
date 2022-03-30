package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream input = new FileInputStream("even.txt")) {
            int read;
            int number;
            while ((read = input.read()) != -1) {
                Character myChar = (char) read;
                number = Character.getNumericValue(myChar);
                if (number % 2 == 0) {
                    System.out.println("Number = " + number + " Is Even!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
