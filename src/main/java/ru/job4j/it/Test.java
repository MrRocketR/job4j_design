package ru.job4j.it;

public class Test {
    public static void main(String[] args) {
        int[][] in = {
                {}, {1}, {11, 12, 14}, {}, {26, 22}
        };
        System.out.println(in.length);
        System.out.println(in[0].length);
        System.out.println(in[1].length);
        System.out.println("_____________");
        for (int j = 0; j < in.length; j++) {
            for (int k = 0; k < in[j].length; k++) {
                System.out.println(in[j][k]);
            }
        }
        System.out.println("_____________");

    }
}
