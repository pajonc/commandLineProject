package com.chrzanop.draw;

public class Pyramid {

    public static void main(String[] args) {
        draw(4);
    }


    public static void draw(int levels) {

        int star = 1;

        while (levels>0) {
            for (int i = 0; i < levels -1 ; i++) {
                System.out.print(" ");
            }
            for (int j = 0; j < star; j++) {
                System.out.print("*");
            }
            System.out.println();
            star = star + 2;
            levels--;

        }

    }
}
