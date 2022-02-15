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
        while (row < data.length - 1 && data[row].length == 0 && column <= row) {
            row++;
            column = 0;
        }
        return data[row].length != 0;
    }

    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }

    public static void main(String[] args) {
  /*      int[][] data = {{1}, {3, 4}, {} };
        int[][] data2 = {{}, {1, 2}, {}};
        int[][] data3 = {{}};
        System.out.println(data.length);
        System.out.println(data[2].length);
        System.out.println("_______");
        System.out.println(data2.length);
        System.out.println(data2[0].length);
        System.out.println(data2[1].length);
        System.out.println("_______");
        System.out.println(data3.length);
        System.out.println(data3[0].length);
        System.out.println("___");*/
        int[][] in = {
                {1}, {2, 3}
        };
        MatrixIt test = new MatrixIt(in);
        System.out.println(test.next());
        System.out.println(test.next());

    }
}

/*
В методе hasNext()  организуйте один цикл while() с условиями, при которых требуется переход на следующую строку,
в теле цикла организуйте переход на следующую строку, в операторе return проверьте корректность найденных индексов.
 */