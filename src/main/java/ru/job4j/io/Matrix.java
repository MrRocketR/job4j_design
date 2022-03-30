package ru.job4j.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Matrix {
    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        try (FileOutputStream out = new FileOutputStream("matrix.txt")) {
            for (int row = 0; row < matrix.length; row++) {
                for (int cell = 0; cell < matrix[row].length; cell++) {
                    matrix[row][cell] = (row + 1) * (cell + 1);
                    int p = matrix[row][cell];
                    String s =  Integer.toString(p);
                    out.write(s.getBytes());
                    out.write("\t".getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    }

