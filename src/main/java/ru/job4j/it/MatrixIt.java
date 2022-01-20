package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (column >= data[row].length) {
            row++;
            column = 0;
            if (row == data.length) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];

    }

    public static void main(String[] args) {
        int[][] arr = {{1}, {2, 3}};
        MatrixIt t = new MatrixIt(arr);
        System.out.println(t.next());
        System.out.println(t.next());
        System.out.println(t.next());




    }
}